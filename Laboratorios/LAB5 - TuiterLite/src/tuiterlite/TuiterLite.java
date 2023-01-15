
package tuiterlite;

import java.util.ArrayList;

public class TuiterLite<T> {
    private ArrayList<Usuario> baseUsuarios;
    private ArrayList<Tuite> bancoTuites;
    private String hashtagMaisComum;
    private String listaDeHashtags;
    public static final int TAMANHO_MAXIMO_TUITES = 120;

    public TuiterLite() {
        this.baseUsuarios = new ArrayList<>();
        this.bancoTuites = new ArrayList<>();
    }
    
    public Usuario cadastrarUsuario(String nome, String email){
        Usuario novoUsuario = new Usuario(nome, email);
        if (this.verificarEmailUsuario(novoUsuario.getEmail())) {
            return null;
        } else {
            this.baseUsuarios.add(novoUsuario);
            return novoUsuario;
        }
    }
    
    private boolean verificarEmailUsuario(String email){
        for (int i = 0; i < this.baseUsuarios.size(); i++) {
            if (email.equals(this.baseUsuarios.get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }
    
    public Tuite tuitarAlgo(Usuario usuario, String texto){
        if (this.verificarCadastroUsuario(usuario) && this.verificarTamanhoTexto(texto)) { 
            Tuite novoTuite = new Tuite(usuario, texto);
            this.bancoTuites.add(novoTuite);
            usuario.setQuantidadeDeTuites(1);
            return novoTuite;
        } else {
            return null; // se pelo menos um dos dois nao for
        }
    }
    
    //Override
    public Tuite tuitarAlgo(Usuario usuario, String texto, Object anexo){
        if (this.verificarCadastroUsuario(usuario) && this.verificarTamanhoTexto(texto)) { 
            Tuite novoTuite = new Tuite(usuario, texto, anexo);
            this.bancoTuites.add(novoTuite);
            usuario.setQuantidadeDeTuites(1);
            return novoTuite;
        } else {
            return null; // se pelo menos um dos dois nao for
        }
    }
    
    private boolean verificarCadastroUsuario(Usuario usuario){
        for (int i = 0; i < this.baseUsuarios.size(); i++) {
            if (usuario == this.baseUsuarios.get(i)) { 
                return true;
            }    
        }
        return false;
    }
    
    private boolean verificarTamanhoTexto(String texto){
        return texto.length() <= TAMANHO_MAXIMO_TUITES;  // se o tuite ultrapassar o limite return true        
    }
    
    
    public String getHashtagMaisComum() {
        StringBuilder hashtags = new StringBuilder();
        for (int i = 0; i < this.bancoTuites.size(); i++) {
            hashtags = hashtags.append(bancoTuites.get(i).getHashtags());
            this.listaDeHashtags = hashtags.toString();
        }
        return listaDeHashtags;    
    }
}