
package albuminterface;

public class Figurinha extends ItemPapelaria implements Colecionavel{
    
    private int posicao;
    private String urlImage;

    public Figurinha(){}
    
    public Figurinha(int posicao, String urlImage) {
        this.posicao = posicao;
        this.urlImage = urlImage;
    }
    
    /**
     * Indica a posição, no álbum, que esta figurinha deve ocupar.
     * @return Um int dizendo a posição da figurinha
     */
    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    /**
     * Retorna a URL de onde a imagem associada a esta figurinha deverá ser baixada.
     * @return uma String com o endereço desejado
     */
    public String getUrlImage() {
        return urlImage;
    }
    
    public static Figurinha criarFigurinhaComUrlFake(int posicao){
        return new Figurinha(posicao, "http://urlDaFigurinha" + posicao + ".jpg");
    }
}
