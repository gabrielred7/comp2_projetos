/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

/**
 *
 * @author gabri
 */
public class SenhaInvalidaException extends Exception {
    private float deficit;

    public float getDeficit() {
        return deficit;
    }

    public void setDeficit(float deficit) {
        this.deficit = deficit;
    }
}
