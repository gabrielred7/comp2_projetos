
package fracao;

public final class Fracao {
    
    public static final String SEPARADOR = "/";
    
    private int numerador;
    private int denominador;
    private boolean positiva;
    /**
     * Construtor. Regras:
     * O sinal da fração é passado no parâmetro específico.
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */
    // Construtor
    public Fracao(int numerador, int denominador, boolean positiva) {
        // Se parametros forem invalidos, criaremos Fração Nula
        if (numerador < 0 || denominador <= 0) {
                this.setNumerador(0);
        }
        // Padroniza Frações nulas
        if (numerador == 0) {
            this.setNumerador(0);
            this.setDenominador(1);
            this.setPositiva(false);
        } else { // Para Frações Gerais
            this.setNumerador(numerador);
            this.setDenominador(denominador);
            this.setPositiva(positiva);
        }
    }
    
    // Metodos Acessores
    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public boolean isPositiva() {
        return positiva;
    }

    public void setPositiva(boolean positiva) {
        this.positiva = positiva;
    }

    public double getValorNumerico() {
        double valor = this.getNumerador() / (double) this.getDenominador();
        return this.isPositiva() ? valor : -valor;
    }   
     
    public int euclides(int a, int b){
        if (a < b) {
            int aux = a;
            a = b;
            b = aux;
        }
        int resto = a % b;
        while (resto != 0) {
            a = b;
            b = resto;
            resto = b % a;
        }
        return a;
    }
    
    public Fracao getFracaoGeratriz() {
        if (this.getNumerador() == 0) {
            return this;
        }
        
        int mdc = euclides(this.getNumerador(), this.getDenominador());
        if (mdc == 1) {
            return this;
        }
        int novoNum = this.getNumerador() / mdc;
        int novoDen = this.getDenominador() / mdc;
        Fracao fracaoGeratriz = new Fracao(novoNum, novoDen, this.isPositiva());
        return fracaoGeratriz;
    }
    
    @Override
    public String toString() {
        return String.format("%s%d%s",
                !this.isPositiva() && this.getNumerador() != 0 ? "-" : "",
                this.getNumerador(),
                this.getDenominador() == 1 ? "" : String.format("%s%d", SEPARADOR, this.getDenominador()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Fracao.class) {
            return false;
        }
        Fracao outraFracao = (Fracao) obj;

        // um jeito não muito bom (porque pode ter problema de precisão)
        // return outraFracao.getValorNumerico() == this.getValorNumerico();

        Fracao minhaFracaoGeratriz = this.getFracaoGeratriz();
        Fracao outraFracaoGeratiz = outraFracao.getFracaoGeratriz();

        return minhaFracaoGeratriz.getNumerador() == outraFracaoGeratiz.getNumerador() &&
                minhaFracaoGeratriz.getDenominador() == outraFracaoGeratiz.getDenominador() &&
                this.isPositiva() == outraFracao.isPositiva();
    }
}