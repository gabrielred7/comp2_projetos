
package testes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import entidades.Aluno;
import entidades.Disciplinas;
import historico.ItemDeHistorico;
import historico.ItemDeHistoricoDisciplinaCursada;
import java.util.ArrayList;
import ui.Siguinha;

public class AlunoTeste {
    
    private Aluno aluno;
    private Disciplinas disciplina1;
    private Disciplinas disciplina2;
    private Disciplinas disciplina3;
    
    @Before
    public void setUp() {
        aluno = new Aluno(12345, 2018, "Aluno Teste");

        disciplina1 = new Disciplinas("MAB001", "Disciplina 1");
        disciplina1.setCreditos(4);

        disciplina2 = new Disciplinas("MAB002", "Disciplina 2");
        disciplina2.setCreditos(6);

        disciplina3 = new Disciplinas("MAJ003", "Disciplina 3");
        disciplina3.setCreditos(6);
    }
    
    @Test
    public void getDreTeste(){
        assertEquals(12345, aluno.getDre());
    }
    
    @Ignore
    @Test
    public void getCraTeste(){}
    
    @Test
    public void getConclusaoDisciplinaTeste(){
        ArrayList<ItemDeHistorico> historico = aluno.getHistorico();
        assertNotNull(historico);
        for (int i = 0; i < historico.size(); i++) {
            assertNull(historico.get(i));
        }
        assertEquals(0, aluno.quantDisciplinasCursadas());

        // o aluno vai cursar a primeira disciplina
        aluno.registrarConclusaoDisciplina(disciplina1, 6.5f, 2019, 2);

        historico = aluno.getHistorico();
        ItemDeHistoricoDisciplinaCursada primeiroItem = (ItemDeHistoricoDisciplinaCursada) historico.get(0);
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals(2019, primeiroItem.getAno());
        assertEquals(2, primeiroItem.getSemestre());
        verificarAtualizacaoCreditos(1, 6.5f, 4);

        aluno.registrarConclusaoDisciplina(disciplina2, 8, 2020, 1);
        // verificar todas as disciplinas do histórico até aqui
        historico = aluno.getHistorico();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        ItemDeHistoricoDisciplinaCursada segundoItem = (ItemDeHistoricoDisciplinaCursada) historico.get(1);        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        verificarAtualizacaoCreditos(2, 7.4f, 10);

        // o aluno vai cursar a terceira disciplina
        aluno.registrarConclusaoDisciplina(disciplina3, 10, 2020, 1);

        historico = aluno.getHistorico();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        ItemDeHistoricoDisciplinaCursada terceiroItem = (ItemDeHistoricoDisciplinaCursada) historico.get(2);        assertEquals("MAJ003", terceiroItem.getDisciplina().getCodigo());
        assertEquals("MAJ003", terceiroItem.getDisciplina().getCodigo());
        verificarAtualizacaoCreditos(3, 8.375f, 16);
    }
    
    @Test
    public void retornarHistoricoTest() {
        aluno.registrarConclusaoDisciplina(disciplina1, 6.5f, 2019, 2);
        aluno.registrarConclusaoDisciplina(disciplina2, 8, 2020, 1);
        aluno.registrarConclusaoDisciplina(disciplina3, 10, 2020, 2);

        char sep = Siguinha.getSeparadorDecimal();

        String historicoRetornado = aluno.retornarHistoricoAsString();
        String historicoEsperado =
                "2019.2 - entidades.Disciplina 1 (MAB001) - média 6" + sep + "5 - 4 créditos\n" +
                "2020.1 - entidades.Disciplina 2 (MAB002) - média 8" + sep + "0 - 6 créditos\n" +
                "2020.2 - entidades.Disciplina 3 (MAJ003) - média 10" + sep + "0 - 6 créditos";
        assertEquals(historicoEsperado, historicoRetornado);
    }

    @Test
    public void testarMuitasDisciplinasCursadas() {
        for (int i = 1; i <= 1000; i++) {
            aluno.registrarConclusaoDisciplina(disciplina1, 10, 2020, 1);
        }
        assertEquals(1000, aluno.quantDisciplinasCursadas());
    }


    private void verificarAtualizacaoCreditos(int quantDiscipinasEsperado,
                                              float craEsperado,
                                              int creditosAcumuladosEsperado) {
        assertEquals(quantDiscipinasEsperado, aluno.quantDisciplinasCursadas());
        assertEquals(craEsperado, aluno.getCra(), 0);  // o terceiro parâmetro é a maior diferença aceitável
        assertEquals(creditosAcumuladosEsperado, aluno.getCreditosAcumulados());
    }
    
}
