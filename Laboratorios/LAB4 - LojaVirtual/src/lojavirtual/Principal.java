
package lojavirtual;

public class Principal {

    public static void main(String[] args) {
        LojaVirtual loja1 = new LojaVirtual();
        Produto livro1 = loja1.criarProduto("Deuses Caidos", "Gabriel Tennyson", 2018, 288, 002, 39, 39.9f, " ", 20);
        Produto livro2 = loja1.criarProduto("Ordem Vermelha", "Felipe Castilho", 2017, 488, 003, 50, 19.9f, " ", 20);
        Produto livro3 = loja1.criarProduto("CronicaDaTormenta", "JM Trevisan", 2012, 249, 004, 39, 49.9f, " ", 5);
        System.out.println(loja1.getTamanhoEstoque(livro3));
        loja1.incluirProdutoNoEstoque(livro3, 10);
        System.out.println(loja1.getTamanhoEstoque(livro3));
        System.out.println(loja1.efetuarVenda(livro1, 2));
        System.out.println(loja1.getTotalValorVendas());
    }
}