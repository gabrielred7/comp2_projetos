
package graficatdd;

import grafica.AcabouOPapelException;
import grafica.FaltouTintaException;
import grafica.Impressora;
import grafica.ImpressoraMatriz;
import grafica.ImpressoraTanqueDeTinta;
import grafica.ImpressoraJatoTinta;
import grafica.ImpressoraLaser;
import org.junit.Test;
import static org.junit.Assert.*;


public class GraficaTDD {

    @Test
    public void testarImpressoraTanqueDeTinta() {
        ImpressoraTanqueDeTinta impressoraTanqueDeTinta = new ImpressoraTanqueDeTinta(
                "Impressora de Teste", "Sem Marca");
        executarTeste(impressoraTanqueDeTinta);
    }

    @Test
    public void testarImpressoraJatoDeTinta() {
        ImpressoraJatoTinta impressoraJatoTinta = new ImpressoraJatoTinta(
                "Impressora de Teste", "Sem Marca", true);
        executarTeste(impressoraJatoTinta);

        impressoraJatoTinta.executarLimpezaBicos();
    }

    @Test
    public void testarImpressoraLaser() {
        ImpressoraLaser impressoraLaser = new ImpressoraLaser();
        executarTeste(impressoraLaser);
    }

    @Test
    public void testarImpressoraMatricial() {
        ImpressoraMatriz impressoraMatriz = new ImpressoraMatriz("Blah");
        executarTeste(impressoraMatriz);
    }

    private void executarTeste(Impressora impressora) {
        // cada caracter vai consumir 10 porcento da tinta!!
        impressora.setConsumoPercentualPorCaracter(10);

        try {
            impressora.imprimir("1234567");
        } catch (FaltouTintaException e) {
            fail(e.getMessage());
        } catch (AcabouOPapelException e) {
            fail();
        }

        assertTrue(impressora.verificarNecessidadeRecarga("1234"));
    }

}