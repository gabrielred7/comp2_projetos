
package albuminterface;

import java.util.ArrayList;


public class Album<T extends Colecionavel> {
    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%
    private int totalItensDoAlbumCompleto;
    private int quantItensPorPacotinho;
    private int quantItensColados;
    private int totalItensRecebidos;
    
    // guardaremos os itens no álbum usando ENDEREÇAMENTO DIRETO, ou seja,
    // item de chave (no caso, a posição no álbum) x na posição x do array
    private ArrayList<T> itensColados;
    private ArrayList<T> itensRepetidos;

    public Album(int totalItensDoAlbumCompleto, int quantItensPorPacotinho) {
        this.totalItensDoAlbumCompleto = totalItensDoAlbumCompleto;
        this.quantItensPorPacotinho = quantItensPorPacotinho;
        this.totalItensRecebidos = 0;
        this.quantItensColados = 0;
        // album inicializado com nulls, para que todas as posições do álbum já possam ser acessadas
        this.itensColados = new ArrayList<>();
        for (int i = 1; i < this.totalItensDoAlbumCompleto + 1; i++) {
            this.itensColados.add(null);
        }
        this.itensRepetidos = new ArrayList<>();
    }
    
     /**
     * Recebe um novo pacotinho. Se o tamanho do pacotinho 
     * não for o tamanho "correto", ignora este pacotinho.
     * @param pacotinho O pacotinho novo.
     */

    public void receberNovoPacotinho(T[] pacotinho) {
        if (pacotinho.length != this.quantItensPorPacotinho) {
            return;
        }
        this.totalItensRecebidos++;
        for (int i = 0; i < pacotinho.length; i++) {
            T item = pacotinho[i];
            if (possuiItemColado(item)) {
                this.itensRepetidos.add(item);
            } else {
                colarItem(item);
            }
        }
    }
    
    private void colarItem(T item) {
        this.itensColados.set(item.getPosicao(), item);
        this.quantItensColados++;
    }
    
    public boolean possuiItemColado(int posicao) {
        return this.itensColados.get(posicao) != null;
    }
    
    public boolean possuiItemColado(T figurinha) {
        return possuiItemColado(figurinha.getPosicao());
    }
    
    public boolean possuiItemRepetido(int posicao){
        for (T item : this.itensRepetidos) {
            if (item.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }
    
    public boolean possuiItemRepetido(T item){
        return possuiItemRepetido(item.getPosicao());
    }
    
    // Metodos Acessores
    public int getQuantItensColados() {
        return this.quantItensColados;
    }

    public int getTotalItensRecebidos() {
        return this.totalItensRecebidos;
    }
    
    public int getQuantItensRepetidos(){
        return this.itensRepetidos.size();
    }
    
    public int getQuantItensFaltando(){
        return this.totalItensDoAlbumCompleto - this.getQuantItensColados();
    }
    
    public T getItem(int posicao){
        if (possuiItemColado(posicao)) {
            return this.itensColados.get(posicao);
        }
        return null;
    }   
}