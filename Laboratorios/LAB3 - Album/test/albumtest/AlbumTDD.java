
package albumtest;

import album.Album;
import album.Figurinha;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Gabriel - Trabalho
 */
public class AlbumTDD {
    
    private Random random = new Random();
    private final int TOTAL_FIGURINHAS = 200;
    private final int QUANT_FIGURINHAS_POR_PACOTE = 3;
    private Album album;
    
    private int escolherPosicaoAleatoria() {
        return random.nextInt(TOTAL_FIGURINHAS) + 1;
    }
    
    private Figurinha[] criarPacotinho(int[] posicoesDesejadas){
        //VFerifica se o tamnhjo do pacotinho e o padrao ou nao e criar um objeto array com o tamnaho do pacotinho
        int tamanhoPacotinho;
        if (posicoesDesejadas == null) {
            tamanhoPacotinho = QUANT_FIGURINHAS_POR_PACOTE; 
        } else { 
            tamanhoPacotinho = posicoesDesejadas.length;
        }
        Figurinha[] novoPacotinho = new Figurinha[tamanhoPacotinho];
        // percorre o tamanho do pacotinho
        for (int i = 0; i < tamanhoPacotinho; i++) {
            int posicaoDaFigurinha;
            if (posicoesDesejadas == null) {
                posicaoDaFigurinha = escolherPosicaoAleatoria();
            } else {
                posicaoDaFigurinha = posicoesDesejadas[i];
            }
            // prenchede os dados de cada uma das 3 figurinhas
            Figurinha figurinha = new Figurinha(posicaoDaFigurinha, String.format("http://urlFakeDaFigurinha%d.jpg", posicaoDaFigurinha));
            // adiciona cada uma das novas figurinhas a um dos slots do array
            novoPacotinho[i] = figurinha;
        }
        return novoPacotinho;
    }
    
    @Before
    public void setUp() {
        album = new Album(TOTAL_FIGURINHAS, QUANT_FIGURINHAS_POR_PACOTE);
    }
    
    @Test
    public void testarRecebimentoPacoteQualquer(){
        Figurinha[] novoPacotinho = criarPacotinho(null);  // posições aleatórias
        album.receberNovoPacotinho(novoPacotinho);
        
        assertEquals(1, album.getTotalPacotinhoRecebidos());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE,
                album.getQuantFigurinhasColadas() + album.getQuantFigurinhasRepetidas());
        for (Figurinha fig : novoPacotinho) {
            assertTrue(album.possuiFigurinhaColada(fig));
        }
    }
    
    @Test
    public void testarRecebimentoFigurinhaRepetida(){
        int[] posicoes = new int[] {1, 1, 1};
        
        Figurinha[] primeiroPacotinho = criarPacotinho(posicoes);

        album.receberNovoPacotinho(primeiroPacotinho);
        assertEquals(1, album.getQuantFigurinhasColadas());
        assertEquals(TOTAL_FIGURINHAS - 1, album.getQuantFigurinhasFaltando());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE - 1, album.getQuantFigurinhasRepetidas());
        assertTrue(album.possuiFigurinhaRepetida(1));
        assertTrue(album.possuiFigurinhaRepetida(primeiroPacotinho[0]));  // outra forma
        assertTrue(album.possuiFigurinhaRepetida(new Figurinha(1, "dskdfsk")));  // outra forma

        posicoes = new int[] {10, 23, 1};
        Figurinha[] segundoPacotinho = criarPacotinho(posicoes);
        album.receberNovoPacotinho(segundoPacotinho);
        assertEquals(3, album.getQuantFigurinhasColadas());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE, album.getQuantFigurinhasRepetidas());
        assertTrue(album.possuiFigurinhaColada(10));
        assertTrue(album.possuiFigurinhaColada(23));
        assertFalse(album.possuiFigurinhaRepetida(10));
        assertFalse(album.possuiFigurinhaRepetida(23));
        assertTrue(album.possuiFigurinhaRepetida(1));
        assertEquals(2, album.getTotalPacotinhoRecebidos());
    }
    
    @Test
    public void testarPreenchimentoAutomaticoDasUltimasFigurinhas() {
        album.encomendarFigurinhasRestantes();
        assertEquals("Não deve ser possível encomendar as figurinhas faltantes " +
                "antes de ter 90% ou mais do álbum já preenchido",
                0, album.getQuantFigurinhasColadas());

        // vamos agora preencher o álbum quase totalmente
        float limiteMinimo = TOTAL_FIGURINHAS * Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR;
        while (album.getQuantFigurinhasColadas() < limiteMinimo) {
            Figurinha[] pacotinho = criarPacotinho(null);
            album.receberNovoPacotinho(pacotinho);
        }
        album.encomendarFigurinhasRestantes();
        assertEquals("Depois da encomenda, o álbum deve estar completo",
                TOTAL_FIGURINHAS, album.getQuantFigurinhasColadas());
    }
    
    @Test
    public void testarPacotinhoRecebidoComTamanhoErrado() {
        Figurinha[] pacotinhoTosco = criarPacotinho(new int[] {2, 7});
        album.receberNovoPacotinho(pacotinhoTosco);
        assertEquals(0, album.getTotalPacotinhoRecebidos());
        assertEquals(0, album.getQuantFigurinhasColadas());
        assertEquals(0, album.getQuantFigurinhasRepetidas());
    }
}