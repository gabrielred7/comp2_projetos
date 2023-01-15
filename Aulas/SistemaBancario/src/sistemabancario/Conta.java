
package sistemabancario;

import java.util.Objects;

public class Conta {
    //atributos
    public final static int LIMITE = 100;
    private final long numero;
    private final Correntista correntista;
    private float saldo;
    private String[] historicoOperacoes;
    private int quantItensHistorico;
    private Gerente gerente;
    private Agencia agencia;
    
    private static int numeroSaques = 0;
    private static int numeroTransferencias = 0;
    private static int numeroDepositos= 0;
            
    //metodos
    public Conta(long numero,  Agencia agencia, Correntista correntista) {
        this.numero = numero;
        this.agencia = agencia; // agregaçao
        this.correntista = correntista;
        this.saldo = 0;
        this.historicoOperacoes = new String[0]; // composição
        this.quantItensHistorico = 0;
        this.gerente = agencia.getGerenteGeral(); // gerente default
    }
            
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    public long getNumero() {
        return numero;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public float getSaldo() {
        return saldo;
    }

    public String[] getHistoricoOperacoes() {
        return historicoOperacoes;
    }

    public static int getNumeroSaques() {
        return numeroSaques;
    }

    public static int getNumeroTransferencias() {
        return numeroTransferencias;
    }

    public static int getNumeroDepositos() {
        return numeroDepositos;
    }
    
    public void receberDepositoEmDinheiro(float valor){
        depositar(valor, "em dinheiro");    
    }
     /**
     *
     * @param valor
     * @param senha
     * @throws SaldoInsuficienteException
     * @throws SenhaInvalidaException se a senha estiver incorreta
     */
    public void sacar(float valor, int senha) throws SaldoInsuficienteException, SenhaInvalidaException {
        if (this.saldo - valor < -LIMITE) {
             throw new SaldoInsuficienteException();
        }
        if (senha!= this.correntista.getSenhaNumerica()) {
            throw new SenhaInvalidaException();
        }
        numeroSaques++;
        this.saldo = this.saldo - valor;
        String novoItem = String.format("Saque: R$.2f", valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }
    /**
     * Transfere fundos desta conta (this) para a conta destino informada.
     *
     * @param contaDestino a conta que receberá o valor transferido
     * @param valor o valor desejado
     * @param senha a senha do correntista dono desta conta de origem
     *
     * @throws SaldoInsuficienteException se não houver saldo e não for possível
     *                                    resgatar o valor que está faltando de uma
     *                                    aplicação automática
     * @throws SenhaInvalidaException se a senha estiver incorreta
     */
    
    public void efetuarTransferencia(Conta contaDestino, float valor, int senha) throws SaldoInsuficienteException, SenhaInvalidaException {

        if (valor > this.saldo + LIMITE) {  // saldo insuficiente
            SaldoInsuficienteException e = new SaldoInsuficienteException();
            e.setDeficit(valor - (this.saldo + LIMITE));
            throw e;
        }
        if (senha != this.correntista.getSenhaNumerica()) {
            throw new SenhaInvalidaException();
        }    numeroTransferencias++;
        this.saldo = this.saldo - valor;
        contaDestino.depositar(valor, this.getCorrentista().getNome());
        String novoItem = String.format("Transferência efetuada para a conta %d: R$%.2f",
                contaDestino.getNumero(), valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }
    
    public void depositar(float valor, String descricaoOrigem){
        numeroDepositos++;
        this.saldo += valor;
        String novoItem = String.format("Depósito %s: R$%.2f", descricaoOrigem, valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }
    
    public static void facaAlgumaCoisa(int x) {
        String msg = "Estou fazendo algo num contexto static com ";
        System.out.println(msg + x + " --- " + numeroDepositos);

    }
    
    public void bloquear(){}
    
    @Override
    public int hashCode() {
         return Objects.hash(numero, agencia);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || this.getClass() != obj.getClass()) { return false; }
        Conta conta = (Conta) obj;
        return this.numero == conta.numero && Objects.equals(this.agencia, conta.agencia);
    }
}