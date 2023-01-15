
package testes;

import entidades.Aluno;

public class AlunoParaTestes extends Aluno {
    
    public AlunoParaTestes(long dre, int anoDeMatricula, String nome) {
        super(dre, anoDeMatricula, nome);
    }

    @Override
    public String retornarHistoricoAsString() {
        return super.retornarHistoricoAsString(); //To change body of generated methods, choose Tools | Templates.
    }
}