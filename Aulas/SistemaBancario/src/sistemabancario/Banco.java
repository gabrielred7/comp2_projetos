
package sistemabancario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    
    private String nome;
    
    private Map<Long, Conta> contaByNumeroDaConta;
    private Map<Correntista, List<Conta>> contaByCorrentista;
    private List<Gerente> gerentes;
    private List<Correntista> correntistas;
    private List<Agencia> agencias;

    public Banco() {
        this.contaByNumeroDaConta = new HashMap<>();
        this.contaByCorrentista = new HashMap<>();
        this.correntistas = new ArrayList();
        this.agencias = new ArrayList();
        this.gerentes = new ArrayList();
    }

    public int getQuantAgencias() {
        return this.agencias.size();
    }

    public int getQuantContas() {
        return this.contaByNumeroDaConta.size();
    }
    
    private int obterDigitoVerificador(long numero){
        return Math.abs((int) numero) % 10;
    }
       
    public Gerente adicionarGerente(String nome){
        Gerente novoGerente = new Gerente(nome);
        this.gerentes.add(novoGerente);
        return novoGerente;
    }
    
    public Correntista adicionarCorrentista(String nome, int senhaNumerica){
        Correntista novoCorrentista = new Correntista(nome, senhaNumerica);
        this.correntistas.add(novoCorrentista);
        return novoCorrentista;
    }
    
    public Agencia adicionarAgencia(int codigo, String nome){
        Agencia novaAgencia = new Agencia();
        this.agencias.add(novaAgencia);
        return novaAgencia;
    }
    
    public Conta criarConta(Agencia agencia, Correntista correntista) {
        // bascicamente criar um numero de conta e cria um novo objeto conta
        long numero = getQuantContas() + 1;
        int digitoVerificador = obterDigitoVerificador(numero);
        numero = numero * 10;
        numero = numero + digitoVerificador;
        Conta novaConta = new Conta(numero, agencia, correntista);
        this.contaByNumeroDaConta.put(numero, novaConta);
        List<Conta> contasDesteCorrentista = this.contaByCorrentista.get(correntista);
        if (contasDesteCorrentista == null) {
            contasDesteCorrentista = new ArrayList<>();
            this.contaByCorrentista.put(correntista, contasDesteCorrentista);
        }
        contasDesteCorrentista.add(novaConta);
        return novaConta;
    }
    /**
     * Retorna uma conta pr??-existente a partir do par??metro de busca n??mero da conta.
     * @param numeroDaContaDesejada O n??mero da conta que se quer localizar
     * @return A conta desejada, caso seja localizada; null, caso contr??rio
     */
    public Conta obterConta(long numeroDaContaDesejada) {
        return this.contaByNumeroDaConta.get(numeroDaContaDesejada);
    }
    /**
     * Retorna uma conta pr??-existente a partir do par??metro de busca correntista.
     * Se o mesmo correntista possuir mais de uma conta no banco,
     * retornar?? uma delas, arbitrariamente.
     * @param correntista O dono da conta desejada
     * @return A conta desejada, caso seja localizada E SEJA ??NICA para aquele correntista;
     *                 null, caso contr??rio (ou seja, caso n??o exista ou n??o seja ??nica)
     */
    public Conta obterConta(Correntista correntista) {
        List<Conta> contasDesteCorrentista = this.contaByCorrentista.get(correntista);
        return contasDesteCorrentista != null && contasDesteCorrentista.size() == 1 ? contasDesteCorrentista.get(0) : null;
    }
    /**
     * Retorna as contas pr??-existentes a partir do par??metro de busca correntista.
     * Se o mesmo correntista possuir mais de uma conta no banco,
     * retornar?? TODAS elas, na forma de uma List.
     *
     * @param correntista O dono das contas desejadas
     * @return Uma lista de contas, caso existam;
     *         null, caso contr??rio
     */
    public List<Conta> obterContas(Correntista correntista) {
        List<Conta> contas = this.contaByCorrentista.get(correntista);
        return contas == null ? null : Collections.unmodifiableList(contas);
    }
}