package grafica;
import java.awt.*;

public abstract class Impressora {
    
    private String nome;
    private String marca;
    
    private float consumoPercentualPorCaracter;

    private int quantCaracteresImpressos;
    protected int quantCaracteresImpressosDesdeUltimaRecarga;
    
    public Impressora(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
        this.consumoPercentualPorCaracter = 0.001f;
    }

    public float getConsumoPercentualPorCaracter() {
        return consumoPercentualPorCaracter;
    }

    public void setConsumoPercentualPorCaracter(float consumoPercentualPorCaracter) {
        this.consumoPercentualPorCaracter = consumoPercentualPorCaracter;
    }
   
    public void imprimir(String texto) throws FaltouTintaException, AcabouOPapelException{
        boolean faltouTinta = true;  // ToDo teria que verificar de alguma forma real
        boolean acabouOPapel = false;  // ToDo teria que verificar de alguma forma real

        if (faltouTinta) {
            FaltouTintaException exception = new FaltouTintaException("magenta");
            throw exception;
        }

        if (acabouOPapel) {
            throw new AcabouOPapelException();
        }
        quantCaracteresImpressos = quantCaracteresImpressos + texto.length();
        quantCaracteresImpressosDesdeUltimaRecarga = quantCaracteresImpressosDesdeUltimaRecarga + texto.length();
        boolean sucesso = executarImpressaoNoPapel(texto);
        if (sucesso) {
            System.out.println("Texto impresso com sucesso!");
        } else {
            System.out.println("Falha na impressão do texto");
        }
    }
    
    protected abstract boolean executarImpressaoNoPapel(String texto);
    
    public boolean verificarNecessidadeRecarga(String texto){
        System.out.println("Verificando a Necessidade de Reccarga");
        
        float percentualConsumido = quantCaracteresImpressosDesdeUltimaRecarga * consumoPercentualPorCaracter;
        
        float percentualRequerido = texto.length() *  consumoPercentualPorCaracter;
        
        boolean decisao = percentualConsumido + percentualRequerido > 100;
                
        return decisao;
    }
    
    public void recarregar() {
        efetuarRecarga();
        this.quantCaracteresImpressosDesdeUltimaRecarga = 0;
    }       
    
    protected abstract void efetuarRecarga();
    
    public void imprimir(Image imagem){}
}