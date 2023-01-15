/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtualinterface;

import java.util.Date;

public class ServicoImpressao extends Servico implements Vendavel {
    private boolean impressaoEmCores;
    private int tamanhoDoPapel;
    private float precoEmReais;
    private int numeroDePaginas;
    
    public ServicoImpressao(){
        setTipo(TipoServico.IMPRESSAO);
    }
    
    @Override
    public void agendar(Date dataDesejada, Pessoa contratante) {
        super.agendar(dataDesejada, contratante);
        mandarConfirmacao(contratante.getEmail());
    }

    private void mandarConfirmacao(String emailDestinatario) {
        // ToDo IMPLEMENT ME!!
    }
    
    @Override
    public void setTipo(TipoServico tipo) {
        // não faz nada, mantém sempre o tipo correto
    }

    public float getPrecoEmReais() {
        return precoEmReais;
    }
    
    public void setPrecoEmReais(float precoEmReais) {
        this.precoEmReais = precoEmReais;
    }

    @Override
    public int getPesoEmGramas() {
        return 1000;
    }

    @Override
    public int getVolumeEmCentimetrosCubicos() {
        return 2000;
    }

}
