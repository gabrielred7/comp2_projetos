
package matematica;

import java.util.Scanner;
import java.lang.Math;

public class Matematica {

    private static long fibonacci(int n){
        if (n < 2){
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }   
    
    private static long fatorial(long num){
        if (num <= 1) {
            return 1;
        } else {
            return num * fatorial (num - 1);
        }
    }
    
    private static float media(float p1, float p2){
        float resultado = (p1 * p2) / 2;
        return resultado;
    }
    
    private static String situação(float p1, float p2){
        float resultado = (p1 * p2) / 2;
        String men1 = "Aprovado";
        String men2 = "Prova final";
        if (resultado >= 6.0){
            return men1;
        } else {
            return men2;
        }
    }
    
    public static void main(String[] args) {
        /**
        for (int i = 0; i < 30; i++){
            System.out.print("(" + i + "):" + Matematica.fibonacci(i) + "\n");
        }
        
        for (long j = 0; j <= 10; j++){
            System.out.print(j + "! =" + fatorial(j) + "\n");
        }
        
        Scanner valores = new Scanner(System.in);
        int Fat = 1;
        int valor = valores.nextInt();
        for (int k = 2; k <= valor; k++){
            Fat = Fat * k;
        }
        System.out.println("O fatorial de " + valor + " é igual a: " + Fat);
        **/
        Scanner comp2 = new Scanner(System.in);
        System.out.println("Digita a primeira nota: ");
        float p1 = comp2.nextFloat();
        System.out.println("Digita a segunda nota: ");
        float p2 = comp2.nextFloat();
        System.out.println("Sua media é: " + Matematica.media(p1, p2) + " então sua situação é: " + Matematica.situação(p1, p2));
        
    }
}