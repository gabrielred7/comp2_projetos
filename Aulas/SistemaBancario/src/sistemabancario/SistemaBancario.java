
package sistemabancario;

public class SistemaBancario {

    public static void main(String[] args) throws SenhaInvalidaException {
        Correntista cor1 = new Correntista("Carla Costa", 11111);
        Correntista cor2 = new Correntista("João da Silva", 11111);
        
        Agencia agencia = new Agencia();
        
        Conta cont1 = new Conta(1234, agencia, cor1);        
        Conta cont2 = new Conta(5679, agencia, cor2);
        
        cont1.depositar(400, "dinheiro");
        cont2.depositar(200, "dinheiro");    
        
        System.out.println(cont1.getNumeroDepositos());  // 3
        System.out.println(cont2.getNumeroDepositos());  // 3
        System.out.println(Conta.getNumeroDepositos());   // 3 (porque o atributo é static)

        try {
            cont1.efetuarTransferencia(cont2, 506, 11111);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente!!");  // e/ou outros tratamentos
            System.out.println(String.format("Ficaram faltando R$%.2f para conseguir!",
                    e.getDeficit()));
        }

        System.out.println(4);
    }
}