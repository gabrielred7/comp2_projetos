
package historico;

import entidades.Aluno;
import entidades.Disciplinas;
import ui.Siguinha;

public class ItemDeHistoricoDisciplinaCursada extends ItemDeHistorico{
    
    private Disciplinas disciplina;
    private float mediaFinal;

    public ItemDeHistoricoDisciplinaCursada(Aluno aluno, int ano, int semestre, Disciplinas disciplina, float mediaFinal) {
        super(aluno, ano, semestre);
        this.disciplina = disciplina;
        this.mediaFinal = mediaFinal;
    }
    
    public boolean obteveAprovacao(){
        return this.mediaFinal >= Siguinha.MEDIA_MINIMA_PARA_APROVACAO;
    }
    
    @Override
    protected String getDescricao() {
        return String.format("%s (%s) - média %.1f - %d créditos",
                this.disciplina.getNome(), this.disciplina.getCodigo(),
                this.mediaFinal, this.disciplina.getCreditos());
    }

    public Disciplinas getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplinas disciplina) {
        this.disciplina = disciplina;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
}