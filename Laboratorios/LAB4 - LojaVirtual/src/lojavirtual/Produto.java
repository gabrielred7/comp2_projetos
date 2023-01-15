
package lojavirtual;

public class Produto {
    protected final long id;
    private int pesoEmGranas;
    private float preçoEmReais;
    protected String categoria;
    protected int quantidadeEmEstoque = 0;
    protected int quantTotalDosProduto = 0;
    
    public Produto(long id, int pesoEmGranas, float preçoEmReais, String categoria, int quantidadeEmEstoque) {
        this.id = id;
        this.pesoEmGranas = pesoEmGranas;
        this.preçoEmReais = preçoEmReais;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    public long getId() {
        return id;
    }

    public int getPesoEmGranas() {
        return pesoEmGranas;
    }

    public float getPreçoEmReais() {
        return preçoEmReais;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
}