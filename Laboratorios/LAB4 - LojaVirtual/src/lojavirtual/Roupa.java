
package lojavirtual;

public class Roupa extends Produto {
    private final char tamanho;
    private String cor;

    public Roupa(char tamanho, String cor, long id, int pesoEmGranas, float preçoEmReais, String categoria, int quantidadeEmEstoque) {
        super(id, pesoEmGranas, preçoEmReais, categoria, quantidadeEmEstoque);
        this.tamanho = tamanho;
        this.cor = cor;
        this.categoria = "Vestuario";
    }

    public char getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return String.format("Tamanho da Roupa: %s, "
                + "Cor: %s, "
                + "Peso:%d, "
                + "Preço: %.2f, "
                + "Categoria: %s, ", 
                this.getTamanho(), this.getCor(), this.getPesoEmGranas(), this.getPreçoEmReais(), this.getCategoria());
    }
}