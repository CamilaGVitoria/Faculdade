package Ex4;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();

        int vetor[] = new int[100000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100000);
        }

        long tempoInicial = System.currentTimeMillis();
        bubbleSort(vetor);
        long tempoFinal = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial) + " ms");
    }

    public static void bubbleSort(int[] vetor) {
        boolean troca;
        
        for (int i = 0; i < vetor.length - 1; i++) {
            troca = false;
            
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    troca = true; 
                }
            }
            
            if (!troca) {
                break;
            }
        }
    }
}
