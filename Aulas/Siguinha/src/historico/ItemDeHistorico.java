
package historico;
import entidades.Aluno;
import java.util.Calendar;

public abstract class ItemDeHistorico {
   
    // atributos
    private final Aluno aluno;
    private int ano;
    private int semestre;
    
    //construtor

    public ItemDeHistorico(Aluno aluno, int ano, int semestre) {
        this.aluno = aluno;
        this.ano = ano;
        this.semestre = semestre;
    }
   
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);
        if (ano < aluno.getAnoDeMatricula() || ano > anoCorrente) {
            return;
        }
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        if (semestre < 1 || semestre > 2) {
            return;
        }
        this.semestre = semestre;
    }
    
    protected abstract String getDescricao();
    
    @Override
    public String toString() {
        return String.format("%d.%d - %s", this.ano, this.semestre, getDescricao());
    }
}