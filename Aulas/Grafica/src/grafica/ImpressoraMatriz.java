
package grafica;

public class ImpressoraMatriz extends Impressora{
    
    public ImpressoraMatriz(String nome) {
        super(nome, "Unica Marca do Mundo Para Matriciais");
    }

    @Override
    protected boolean executarImpressaoNoPapel(String texto) {
        System.out.println("Jogando tinta no papel do jeito que uma matricial faz...");
        return true;   
    }

    @Override
    protected void efetuarRecarga() {
        System.out.println("Trocando fita da impressora matricial...");
    }
}