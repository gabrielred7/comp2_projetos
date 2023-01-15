
package lojavirtual;

public class Livro extends Produto {
    private final String titulo;
    private final String autor;
    private final int anoDePublicacao;
    private final int numeroDePaginas;

    public Livro(String titulo, String autor, int anoDePublicacao, int numeroDePaginas, long id, int pesoEmGranas, float preçoEmReais, String categoria, int quantidadeEmEstoque) {
        super(id, pesoEmGranas, preçoEmReais, categoria, quantidadeEmEstoque);
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDePaginas = numeroDePaginas;
        this.categoria = "Publicação";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }
    
    public int getTamanhoEstoque(Produto produto){
        return quantidadeEmEstoque;
    }
    
    @Override
    public String toString() {
        return String.format("Livro de Titulo: %s, "
                + "Autor: %s, "
                + "Ano de Publicação: %d, "
                + "Nº de Paginas: %d, "
                + "Peso:%d, "
                + "Preço: %.2f, "
                + "Categoria: %s", 
                this.getTitulo(), this.getAutor(), this.getAnoDePublicacao(), this.getNumeroDePaginas(), this.getPesoEmGranas(), this.getPreçoEmReais(), this.getCategoria());
    }
}