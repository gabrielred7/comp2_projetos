
package lendodearquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LendoDeArquivo {
    
    private static void gerandoArquivo(String nomeDoArquivo){
        try {
            File arquivoX = new File(nomeDoArquivo);
            if (arquivoX.createNewFile()) {
                System.out.println("O Arquivo foi criado");
            } else {
                System.out.println("O Arquivo " + arquivoX.getName() + " está na base.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
        
        try {
            FileWriter escrever = new FileWriter(nomeDoArquivo);
            escrever.write(8);
            escrever.write(6);
            escrever.write(9);
            escrever.write(10);
            escrever.write(3);
            escrever.write(2);
            escrever.write(7);
            escrever.close();
            System.out.println("O dados foram gravados com sucesso no arquivo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
    }
    
    private static float calcularMedia(String nomeDoArquivo) {
        File arquivoX = new File(nomeDoArquivo);
        int contDados = 0;
        float resultado = 0;
        float media = 0;
        int linhasInvalidas = 0;
        try {
            Scanner input = new Scanner(arquivoX);
            while(input.hasNext()){
                System.out.println(input.nextLine());
                try {
                    float dados = input.nextFloat();
                    contDados = contDados + 1;
                    media = media + dados;
                } catch(Exception e){
                    linhasInvalidas = linhasInvalidas + 1;
                }
            }
            resultado = media / contDados;
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Esse arquivo não foi encontrado. Submeta um arquivo valido");
            e.printStackTrace();
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        gerandoArquivo("media.txt");
        System.out.println("Submeta o arquivo: ");
        Scanner teclado = new Scanner(System.in);
        String nomeDoArquivo = teclado.nextLine();
        calcularMedia(nomeDoArquivo);
        // System.out.println("O resultado da media é " + resultado + " .");
    }
}
