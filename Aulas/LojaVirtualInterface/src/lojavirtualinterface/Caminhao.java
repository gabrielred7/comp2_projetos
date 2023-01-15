/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtualinterface;


public class Caminhao implements Transportador{
    private String nome;
    private int capacidadeMaximaEmKg;
    private int volumeMaximoEmCentimetrosCubicos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeMaximaEmKg() {
        return capacidadeMaximaEmKg;
    }

    public void setCapacidadeMaximaEmKg(int capacidadeMaximaEmKg) {
        this.capacidadeMaximaEmKg = capacidadeMaximaEmKg;
    }

    public int getVolumeMaximoEmCentimetrosCubicos() {
        return volumeMaximoEmCentimetrosCubicos;
    }

    public void setVolumeMaximoEmCentimetrosCubicos(int volumeMaximoEmCentimetrosCubicos) {
        this.volumeMaximoEmCentimetrosCubicos = volumeMaximoEmCentimetrosCubicos;
    }
    
    @Override
    public void transportar(Vendavel item, int quantidade, String enderecoDeEntrega) {
    }  
}
