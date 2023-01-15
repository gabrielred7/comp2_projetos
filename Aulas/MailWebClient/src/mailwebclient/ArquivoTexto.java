
package mailwebclient;

public class ArquivoTexto extends Arquivo{
    
    public ArquivoTexto(String nome, String extensao) {
        super(nome, extensao);
    }
    
    public int getTamanhoTexto(){
        return 0;
    }
    
    @Override
    public void exibir() {
         System.out.println("Imprimindo caracteres do arquivo no terminal...");
    }
}