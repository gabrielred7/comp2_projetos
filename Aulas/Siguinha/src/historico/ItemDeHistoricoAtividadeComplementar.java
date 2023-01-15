
package historico;

import entidades.Aluno;


public class ItemDeHistoricoAtividadeComplementar extends ItemDeHistorico {
    
    private char conceito;
    
    public ItemDeHistoricoAtividadeComplementar(Aluno aluno, int ano, int semestre) {
        super(aluno, ano, semestre);
    }

    @Override
    protected String getDescricao() {
        return String.format("Atividade Complementar com conceito %c", this.conceito);    
    }

    public char getConceito() {
        return conceito;
    }

    public void setConceito(char conceito) {
        if (conceito != 'A' && conceito != 'B' && conceito != 'C' && conceito != 'D') {
            return;
        }
        this.conceito = conceito;
    }
}