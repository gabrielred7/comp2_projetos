
package mailwebclient;

import java.util.Date;

public abstract class Arquivo {
    
    private String nome;
    private String extensao;
    private int tamanhoEmBytes;
    private Byte[] conteudoEmBytes;
    private final Date dataCriacao;
    private Date dataUltimaModificacao;

    public Arquivo(String nome, String extensao) {
        this.nome = nome;
        this.extensao = extensao;
        this.dataCriacao = new Date();
    }
    
    public int getTamanhoEmBytes() {
        return tamanhoEmBytes;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Byte[] getConteudoEmBytes() {
        return conteudoEmBytes;
    }
    
    /**
     * Exibe o conteúdo do arquivo de forma amigável, isto é, dependendo do tipo
     * do arquivo, a exibição deverá ser feita de uma maneira muito específica
     * (um som deve ser tocado, um filme deve ser exibido, um texto deve ser impresso
     * na tela, etc.)
     */
    
    public void exibir() {}
        /**
     * Copia o conteúdo a partir de um Arquivo de origem.
     * @param outroArquivo o arquivo-fonte (origem)
     */
    public void copiar(Arquivo outroArquivo) {
        this.conteudoEmBytes = outroArquivo.getConteudoEmBytes();
        this.tamanhoEmBytes = outroArquivo.getTamanhoEmBytes();
        this.dataUltimaModificacao = new Date();
    }
}