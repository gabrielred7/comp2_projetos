
package albuminterface;

public class Selo extends ArtigoNacional implements Colecionavel {
    
    private int posicao;
    private String pais;
    private float valorNominal;

    public Selo(){}
    
    public Selo(int posicao) {
        this.posicao = posicao;
    }
    
    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(float valorNominal) {
        this.valorNominal = valorNominal;
    }
}