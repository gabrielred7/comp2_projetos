
package tuiterlite;

import java.util.ArrayList;

public class Tuite<T> {
    
    private final Usuario autor;
    private final String texto;
    private ArrayList<String> hashtags;
    private ArrayList<String> palavras;
    private Object anexo;

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.anexo = "nada";
    }
   
    // Override de Constructor
    public Tuite(Usuario autor, String texto, Object anexo) {
        this.autor = autor;
        this.texto = texto;
        this.anexo = anexo;
    }
    
    public Object getAnexo(){
        return this.anexo;
    }
    
    public void anexarAlgo(Object anexo){
        this.anexo = anexo;
    }
    
    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

     public ArrayList<String> getHashtags() {
        this.hashtags =new ArrayList<>();
        String[] linhas = this.texto.split(" ");
        for (int i = 0; i < linhas.length; i++) {
            if (linhas[i].charAt(0) == '#') {
                 this.hashtags.add(linhas[i]);
            }
        }
        return hashtags;
    }
     
    @Override
    public String toString() {
        return String.format("O Tuite do Usuario " + autor.getNome() + ", foi: " + texto + " e tem " + anexo + " anexada.");
    }
}