
package lojavirtualinterface;

import java.util.Objects;

public class Produto {
    private static long nextSeqNum = 1;
    protected final long id;
    private String descricao;
    private int pesoEmGramas;
    private int volumeEmCentimentrosCubicos;
    private float precoEmReais;
    private CategoriaProduto categoria;
    private int quantidadeEmEstoque;

    public Produto(String descricao, float precoEmReais, CategoriaProduto categoria) {
        this.id = nextSeqNum++;
        this.descricao = descricao;
        this.precoEmReais = precoEmReais;
        this.categoria = categoria;
    }

    public long getId() {
        return this.id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPesoEmGramas() {
        return pesoEmGramas;
    }

    public void setPesoEmGramas(int pesoEmGramas) {
        this.pesoEmGramas = pesoEmGramas;
    }

    public int getVolumeEmCentimentrosCubicos() {
        return volumeEmCentimentrosCubicos;
    }

    public void setVolumeEmCentimentrosCubicos(int volumeEmCentimentrosCubicos) {
        this.volumeEmCentimentrosCubicos = volumeEmCentimentrosCubicos;
    }

    public float getPrecoEmReais() {
        return precoEmReais;
    }

    public void setPrecoEmReais(float precoEmReais) {
        this.precoEmReais = precoEmReais;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        Produto other = (Produto) obj;
        return this.id == other.id;
    }
}
