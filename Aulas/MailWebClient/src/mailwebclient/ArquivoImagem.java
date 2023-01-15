
package mailwebclient;

public class ArquivoImagem extends Arquivo{
    
    int numeroCores;
    
    public ArquivoImagem(String nome, String extensao) {
        super(nome, extensao);
    }

    public int getNumeroCores() {
        return numeroCores;
    }

    public void setNumeroCores(int numeroCores) {
        this.numeroCores = numeroCores;
    }

    @Override
    public void exibir() {
        System.out.println("Desenhando imagem na tela...");
    }
}