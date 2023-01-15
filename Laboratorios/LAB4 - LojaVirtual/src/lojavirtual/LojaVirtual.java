
package lojavirtual;

import java.util.ArrayList;

public class LojaVirtual {
    private ArrayList<Produto> estoque;
    private int quantTodosProdutosEmEstoque = 0;
    private float fluxoCaixa = 0;
    private float valor;

    public LojaVirtual() {
        this.estoque = new ArrayList<>();
    }
    
    public int getTamanhoEstoque() {
        for (int i = 0; i < this.estoque.size(); i++) {
            Produto prototemp = estoque.get(i);
            quantTodosProdutosEmEstoque = quantTodosProdutosEmEstoque + prototemp.getQuantidadeEmEstoque();
        }
        return quantTodosProdutosEmEstoque;
    }
    
    public int getTamanhoEstoque(Produto produto) {
        return produto.getQuantidadeEmEstoque();
    }
       
    public void incluirProdutoNoEstoque(Produto produto, int quantidade){
        for (int i = 0; i < this.estoque.size(); i++) {
            if (produto.equals(estoque.get(i))) {
                Produto prototemp = estoque.get(i);
                prototemp.quantidadeEmEstoque = prototemp.quantidadeEmEstoque + quantidade;
            }
        }
    }
    
    public String efetuarVenda(Produto produto, int quantidade){
        for (int i = 0; i < this.estoque.size(); i++) {
            if (produto.equals(estoque.get(i)) && produto.getQuantidadeEmEstoque() >= quantidade) {
                Produto prototemp = estoque.get(i);
                valor = prototemp.getPreçoEmReais() * quantidade;
                if (this.receberPagamento(valor)){
                    prototemp.quantidadeEmEstoque = prototemp.quantidadeEmEstoque - quantidade;
                }
            }
        }
        return String.format("Recibo da Compra: %d itens equivalente a %.2f. Compra feita com sucesso.", quantidade, valor);
    }

    private boolean receberPagamento(float valor){
        this.fluxoCaixa = fluxoCaixa + valor;
        return true;
    }
    
    public float getTotalValorVendas() {
        return this.fluxoCaixa;
    }
   
    public Produto criarProduto(String titulo, String autor, int anoDePublicacao, int numeroDePaginas, long id, int pesoEmGranas, float preçoEmReais, String categoria, int quantidadeEmEstoque){
         Produto livro = new Livro(titulo, autor, anoDePublicacao, numeroDePaginas, id, pesoEmGranas, preçoEmReais, categoria, quantidadeEmEstoque);
         this.estoque.add(livro);
         return livro;
    }
    
    public Produto criarProduto(char tamanho, String cor, long id, int pesoEmGranas, float preçoEmReais, String categoria, int quantidadeEmEstoque){
         Produto roupa = new Roupa(tamanho, cor, id, pesoEmGranas, preçoEmReais, categoria, quantidadeEmEstoque);
         this.estoque.add(roupa);
         return roupa;
    }
    
    public  ArrayList<Produto> getproduto(){
        return this.estoque;
    }
   
    public Produto getprodutoById(int id){
        for (int i = 0; i < this.estoque.size(); i++) {
            Produto prototemp = estoque.get(i);
            if(id == prototemp.id){
                  return prototemp;
            }
        }    
        return null;
    }

}