package entidades;

import historico.ItemDeHistorico;
import historico.ItemDeHistoricoDisciplinaCursada;
import java.util.ArrayList;
import java.util.Calendar;

public class Aluno {
    
    // atributos
    private String nome;
    private final long dre;
    private final int anoDeMatricula;
    private int creditosAcumulados; // Somatorio_d [creditos(d)]
    private float cra;  // cra = Somatorio_d [media(d) * reditos(d)]
    
    private ArrayList<ItemDeHistorico> historico;
    
    
    // construtores
    public Aluno(long dre, int anoDeMatricula, String nome ) {
        this.dre = dre;
        this.anoDeMatricula = anoDeMatricula;
        this.nome = nome;
        this.historico = new ArrayList<>();
    }
    
    // metodos
    public void registrarConclusaoDisciplina(Disciplinas disciplina, float mediaFinal, int anoConclusao, int semestreConclusao){
        ItemDeHistoricoDisciplinaCursada novoItem = new ItemDeHistoricoDisciplinaCursada (this, anoConclusao, semestreConclusao, disciplina, mediaFinal);

        this.historico.add(novoItem);
        
        // recupero o numerador corrente (antes da nova disciplina)
        float numeradorCorrenteCra = this.cra * this.creditosAcumulados;

        int creditos = disciplina.getCreditos();
        this.creditosAcumulados = this.creditosAcumulados + creditos;

        // atualizar o CRA do aluno
        float novaParcela = creditos * mediaFinal;
        this.cra = (numeradorCorrenteCra + novaParcela) / this.creditosAcumulados;
    }
    
    //Override
    public void registrarConclusaoDisciplina(Disciplinas disciplina, float mediaFinal){
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        int semestre = mes <= 6 ? 1 : 2;
        
        // passa ano e semestre correntes para a versão "principal" deste método
        registrarConclusaoDisciplina(disciplina, mediaFinal, ano, semestre);
    }
    
    public String retornarHistoricoAsString(){
        String resultado = " ";
        for (int i = 0; i < this.historico.size(); i++) {
            ItemDeHistorico item = this.historico.get(i);
            resultado = resultado + item.toString();
            if (i < this.historico.size() - 1) {
                resultado = resultado + "\n";
            }
        }
        return resultado;
    }
    
    public int quantDisciplinasCursadas(){
        int contDisciplinas = 0;
        for (ItemDeHistorico item : this.historico) {
            if (item instanceof ItemDeHistoricoDisciplinaCursada) {
                contDisciplinas++;
            }
        }
        return contDisciplinas;
    }
    
    @Override
    public String toString() {
        return String.format("%s (DRE: %d", this.nome, this.dre);
    }  
    
    // acessores
    public String getNome() {
        return nome == null ? "Sem Nome" : nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 30) {
            return;
        }
        this.nome = nome;
    }
    
    public long getDre() {
        return dre;
    }

    public int getAnoDeMatricula() {
        return anoDeMatricula;
    }

    public int getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public float getCra() {
        return cra;
    }

    public ArrayList<ItemDeHistorico> getHistorico() {
        return historico;
    }
    
    public static void main(String[] args) {
        Aluno aluno = new Aluno(111, 2018, "entidades.AlunoParaTestes Teste");
        Disciplinas d1 = new Disciplinas("D1", "qualquer coisa");
        Disciplinas d2 = new Disciplinas("D2", "qualquer outra coisa");
        aluno.registrarConclusaoDisciplina(d1, 8, 2019, 1);
        aluno.registrarConclusaoDisciplina(d2, 6.5f);
        System.out.println(aluno.retornarHistoricoAsString());
    }
}