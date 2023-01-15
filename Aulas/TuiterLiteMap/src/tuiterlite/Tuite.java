
package tuiterlite;

import java.util.ArrayList;

public class Tuite<T> {
    
    private final Usuario autor;
    private final String texto;
    private ArrayList<String> hashtags;
    private T anexo;

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.hashtags = new ArrayList<>();
        extrairHashtags();
    }
    
    public Object getAnexo(){
        return this.anexo;
    }
    
    public void anexarAlgo(T anexo){
        this.anexo = anexo;
    }
    
    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }
    
    public ArrayList<String> getHashtags() {
        return hashtags;
    }    
    
    public void extrairHashtags(){
        String[] linhas = this.texto.split("[\\s, ]");
        for (String linha : linhas) { //for que percorre string
            if (linha.startsWith("#")) {
                this.hashtags.add(linha);
            }
        }
    }
     
    @Override
    public String toString() {
        return String.format("O Tuite do Usuario " + autor.getNome() + ", foi: " + texto + " e tem " + anexo + " anexada.");
    }
}