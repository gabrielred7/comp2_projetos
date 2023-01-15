
package mailwebclient;

public class MailWebClient {
    
    private int numeroExibiçõesArquivos;
    
    public void exibirArquivo(EmailRecebido email){
        email.extrairArquivo();
        Arquivo arquivo = email.getArquivoEmAnexo();
        if (arquivo == null) {
            System.out.println("Arquivo nulo ou inexistente");
            return;
        }
        arquivo.exibir();
        this.numeroExibiçõesArquivos++;
    }
    
    public static void main(String[] args) {
        MailWebClient mailWebClient = new MailWebClient();

        // suponha que recebemos um email...
        EmailRecebido emailRecebido = new EmailRecebido();
        // ...e queremos exibir seu arquivo em anexo
        mailWebClient.exibirArquivo(emailRecebido);
    }
}
