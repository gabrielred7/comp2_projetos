
package album;

import java.util.ArrayList;

public class Album {
        public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%
        private int totalFigurinhasDoAlbumCompleto;
        private int quantFigurinhasPorPacotinho;
        private int totalPacotinhosRecebidos = 0;
        private int quantFigurinhasColadas;
        private ArrayList<Figurinha> figurinhasColadas;
        private ArrayList<Figurinha> figurinhasRepetidas;

        public Album(int totalFigurinhasDoAlbumCompleto, int quantFigurinhasPorPacotinho) {
            this.totalFigurinhasDoAlbumCompleto = totalFigurinhasDoAlbumCompleto;
            this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
            this.totalPacotinhosRecebidos = 0;
            this.quantFigurinhasColadas = 0;
            this.figurinhasRepetidas = new ArrayList<>();
            this.figurinhasColadas = new ArrayList<>();
            //inicilizar o album com nulls no total de figurinhas do album, 
            //para que todas as posições ja possam ser acessadas
            for (int i = 1; i < this.totalFigurinhasDoAlbumCompleto + 1; i++) {
                this.figurinhasColadas.add(null);
            }
        }

        public int getTotalFigurinhasDoAlbumCompleto() {
            return totalFigurinhasDoAlbumCompleto;
        }
        public int getQuantFigurinhasPorPacotinho() {
            return quantFigurinhasPorPacotinho;
        }
        public int getTotalPacotinhoRecebidos(){
            return this.totalPacotinhosRecebidos;
        }
        public int getQuantFigurinhasColadas() {
            return this.figurinhasColadas.size();
        }
        public int getQuantFigurinhasRepetidas() {
            return this.figurinhasRepetidas.size();
        }
        public int getQuantFigurinhasFaltando(){
           return this.totalFigurinhasDoAlbumCompleto - getQuantFigurinhasColadas();
       } 
    
        public void receberNovoPacotinho(Figurinha[] pacotinho){
            if (pacotinho.length != this.quantFigurinhasPorPacotinho) {
                return; // nao faz nada
            }
            this.totalPacotinhosRecebidos++;
            for (int i = 0; i < pacotinho.length; i++) {
                Figurinha figurinha = pacotinho[i];
                if (possuiFigurinhaColada(figurinha)) {
                    this.figurinhasRepetidas.add(figurinha);
                } else {
                    colarFigurinha(figurinha);
                }            
            }
        }
     /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente não faz nada.
     */
        public void encomendarFigurinhasRestantes(){
            //valida regra dos 10%
            if (getQuantFigurinhasColadas() < this.totalFigurinhasDoAlbumCompleto * 
                    PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR) {
                return;
            }
            for (int i = 1; i <= this.totalFigurinhasDoAlbumCompleto; i++) {
                if (!possuiFigurinhaColada(i)) {
                    Figurinha figurinha = new Figurinha(i,  "http://urlDaFigurinha" + i + ".jpg");
                    colarFigurinha(figurinha);
                }
            }
        } // (será preciso validar a regra dos 10%)

        private void colarFigurinha(Figurinha figurinha){
            this.figurinhasColadas.set(figurinha.getPosicao(), figurinha);
            this.quantFigurinhasColadas++;
        }

        public boolean possuiFigurinhaColada(int posicao){
            return this.figurinhasColadas.get(posicao) != null;
        }
        public boolean possuiFigurinhaColada(Figurinha figurinha){
            return possuiFigurinhaColada(figurinha.getPosicao());
        } //overload

        public boolean possuiFigurinhaRepetida(int posicao){
            for (Figurinha figurinha : this.figurinhasRepetidas) {
                if (figurinha.getPosicao() == posicao) {
                    return true;
                }
            }
            return false;
        }
        public boolean possuiFigurinhaRepetida(Figurinha figurinha){
            return possuiFigurinhaRepetida(figurinha.getPosicao());
        } //overload
    }