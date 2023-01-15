
package lojavirtualinterface;

import java.util.HashMap;
import java.util.Map;

public class LojaVirtual {
    private float valorTotalDasVendas;
    private int tamanhoTotalEstoque;
    
    public Pessoa gerente;
    
    private Caminhao caminhaoPequeno;
    private Caminhao caminhaoGrande;
    
    private Map<Vendavel, Integer> quantidadeByItem;
    
    public LojaVirtual(){
        this.valorTotalDasVendas = 0;
        this.tamanhoTotalEstoque = 0;
        this.quantidadeByItem = new HashMap<>();
    }

    public Pessoa getGerente() {
        return gerente;
    }
    
    public void setGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

    public float getValorTotalDasVendas() {
        return valorTotalDasVendas;
    }

    public int getTamanhoTotalEstoque() {
        return tamanhoTotalEstoque;
    }
    
    public int getTamanhoTotalEstoque(Vendavel item){
        Integer quantidadeEmEstoque = this.quantidadeByItem.get(item);
        return quantidadeEmEstoque == null ? 0 : quantidadeEmEstoque;
    }
    
    /**
     * Adiciona a quantidade informada ao estoque daquele item.
     * Caso o item não exista no estoque, ele será pela primeira vez inserido no estoque.
     * @param item O item desejado
     * @param quantidade A quantidade extra daquele item a ser adicionada
     */
    
    public void incluirItemNoEstoque(Vendavel item, int quantidade){
        Integer quantidadeEmEstoque = this.quantidadeByItem.get(item);
        this.quantidadeByItem.put(item, quantidadeEmEstoque + quantidade);
    }
    
    public String efetuarVenda(Vendavel item, int quantidade, Pessoa comprador) throws EstoqueInsuficienteException, PagamentoException {
        int quantidadeEmEstoque = this.getTamanhoTotalEstoque(item);
        if (quantidadeEmEstoque < quantidade) {
            throw new EstoqueInsuficienteException();
        }
        float valorDaVenda = item.getPrecoEmReais() * quantidade;
        try {
            receberPagamento(valorDaVenda);
        } catch (NomeNoSPCException | CartaoInvalidoException e) {
            throw new PagamentoException();
        }
        int novaQuantidadeDesteItem = quantidadeEmEstoque - quantidade;
        if (novaQuantidadeDesteItem == 0) {
            this.quantidadeByItem.remove(item);
        } else {
            this.quantidadeByItem.put(item, novaQuantidadeDesteItem);
        }
        this.tamanhoTotalEstoque = tamanhoTotalEstoque - quantidade;
        transportarItem(item, quantidade, comprador.getEndereco());
        String recibo = String.format("Recibo para %s no valor de R$%.2f referente a %d unidades de %s",
                        comprador.getNome(), valorDaVenda, quantidade, item.getDescricao());
        return recibo;
    }
    
    private void transportarItem(Vendavel item, int quantidade, String enderecoDeEntrega){
        Transportador transportador = obterTransportador(item, quantidade);
        transportador.transportar(item, quantidade, enderecoDeEntrega);
        System.out.println(String.format("Item %s transportado pelo transportador %s", item, transportador));
    }
    
    private Transportador obterTransportador(Vendavel item, int quantidade){
        if (item instanceof Produto) {
            if (((Produto) item).getCategoria() == CategoriaProduto.BRINQUEDO && quantidade == 1){
                return (Transportador) gerente;
            }
        }
        int volumeTotal = item.getVolumeEmCentimetrosCubicos() * quantidade;
        Caminhao caminhao = volumeTotal < caminhaoPequeno.getVolumeMaximoEmCentimetrosCubicos() ? caminhaoPequeno : caminhaoGrande;
        return caminhao;
    }
    
    private void receberPagamento(float valor) throws NomeNoSPCException, CartaoInvalidoException{
        if (false) {throw new NomeNoSPCException();} // if (pagamento em cheque e nome no SPC) 
        if (false) {throw new CartaoInvalidoException();} // if (pagamento em cartao e cartao invalido)
        this.valorTotalDasVendas = this.valorTotalDasVendas + valor;
    }
}
