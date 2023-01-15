
package tuiterlite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Principal {
    
    public static void main(String[] args) {
        
         // Mainzinho bobo, apenas ilustrando String.split(regexp), e o String.startsWith()
        int tamanho = 500_000_000;
        List<Integer> lista = new ArrayList<>(tamanho);

        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            lista.add(random.nextInt());
        }

        // Ilustrando o uso de um StringBuilder (ou StringBuffer)
        System.out.println("Encontrando o maior...");
        long inicio = System.currentTimeMillis();
        int maior = encontrarMaior(lista);
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nmaior = %d (duracao = %d milissegundos)", maior, duracao);
    }

    private static int encontrarMaior(List<Integer> lista) {
        return Collections.max(lista);

        //        int maior = Integer.MIN_VALUE;
        //        for (int elemento : lista) {
        //            if (elemento > maior) {
        //                maior = elemento;
        //            }
        //        }
        //
        //        return maior    }
    }
}