package Ex1;

import java.util.Arrays;

public class BuscaSequencialWhile {
    public static void main(String[] args) {

        int vetor[] = new int[10];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = i+1;
        }

    

        System.out.println(" Vetor: " + Arrays.toString(vetor));
        System.out.println(buscaSequencial(vetor, 0));
        
    }

    public static int buscaSequencial(int[] vetor, int chaveBusca) {
        int i = 0;
        
        while (i < vetor.length) {
            if (vetor[i] == chaveBusca) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
}