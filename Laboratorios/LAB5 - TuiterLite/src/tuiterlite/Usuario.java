
package tuiterlite;

import java.awt.Image;

public class Usuario {
    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;
    
    private NivelUsuario nivel;
    private String nome;
    private final String email;
    private int quantidadeDeTuites;
    private Image foto;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.quantidadeDeTuites = 1000;
        this.nivel = NivelUsuario.INICIANTE;
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public Image getFoto() {
        return this.foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }  

    public int getQuantidadeDeTuites() {
        return quantidadeDeTuites;
    }

    public void setQuantidadeDeTuites(int numero) {
        this.quantidadeDeTuites = quantidadeDeTuites + numero;
        this.setNivel(quantidadeDeTuites);
    }
    
    public NivelUsuario getNivel() {
        return nivel;
    }

    public void setNivel(int quantidadeDeTuites) {
        if (this.quantidadeDeTuites >= MIN_TUITES_SENIOR) {
            this.nivel = NivelUsuario.SENIOR;
        }
        if (this.quantidadeDeTuites >= MIN_TUITES_NINJA) {
            this.nivel = NivelUsuario.NINJA;
        }
    }
    
    @Override
    public String toString() {
        return String.format("Usuario de nome: %s do email: %s. É de nivel %s e já fez %d tuites", 
                this.nome, this.email, this.nivel, this.quantidadeDeTuites);
    }
}