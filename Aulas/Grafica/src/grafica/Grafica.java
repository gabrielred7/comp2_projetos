
package grafica;

import java.util.Scanner;

public class Grafica {

    public static void main(String[] args) {
        Impressora minhaImpressora = criarImpressora();
        try {
            minhaImpressora.imprimir("Hello!");
        } catch(FaltouTintaException e) {
            System.out.println(String.format("acabou a tinta %s!!!", e.getCorFaltante()));
        } catch(AcabouOPapelException e) {
            System.out.println("acabou o papel!!!");
        }
        
        System.out.println(minhaImpressora.getConsumoPercentualPorCaracter());
    }

    private static Impressora criarImpressora() {
        Impressora impressora;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual tipo (J: Jato de tinta | L: Laser | M: Matriz): ");
        String tipo = scanner.nextLine();
        System.out.println("Qual a marca? ");
        String marca = scanner.nextLine();
        System.out.println("Qual o modelo? ");
        String modelo = scanner.nextLine();
        
        char c = tipo.toLowerCase().charAt(0); //recuperat o primeiro caractere e avaliar
        switch  (c) {
            case 'j':
                System.out.println("Colorida? (S|N): ");
                String colorida = scanner.nextLine();
                boolean decisao = colorida.toLowerCase().charAt(0) == 's';
                impressora = new ImpressoraJatoTinta(marca, modelo, decisao);
                break;
                
            case 'm':
                impressora = new ImpressoraMatriz(marca);
                break;
            
            case 't':
                impressora = new ImpressoraTanqueDeTinta(marca, modelo);
                break;
            
            case 'l': default:
                impressora = new ImpressoraLaser();
                break;
                
        }
        return impressora;
    }
}