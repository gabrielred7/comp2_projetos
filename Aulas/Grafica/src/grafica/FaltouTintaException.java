/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica;

/**
 *
 * @author gabri
 */
public class FaltouTintaException extends Exception{
    private String corFaltante;

    public FaltouTintaException(String corFaltante) {
        super();
        this.corFaltante = corFaltante;
    }

    public String getCorFaltante() {
        return corFaltante;
    }
}
