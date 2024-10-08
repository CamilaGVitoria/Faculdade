package Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BuscaSequencialEBinaria {
    
    public static void main(String[] args) {
        int vetor[] = {1,1,2,3,4,5,6,7,8,9}; 
        int chaveBusca = 1;     

        List<Integer> posChaveSequencial = buscaSequencial(vetor, chaveBusca);  
        List<Integer> posChaveBinaria = buscaBinaria(vetor, chaveBusca);  

        System.out.println(" Vetor: " + Arrays.toString(vetor));
        System.out.println(posChaveSequencial);
        System.out.println(posChaveBinaria);
        
    }

    public static List<Integer> buscaSequencial(int[] vetor, int chaveBusca) {
        List<Integer> posChave = new ArrayList<>();

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chaveBusca) {
             posChave.add(i);
            }
        }
        return posChave;
    }

    public static List<Integer> buscaBinaria(int[] vetor, int chaveBusca) {
        List<Integer> posChave = new ArrayList<>();
        int posInicial = 0;
        int posFinal = vetor.length - 1;
        

        while (posInicial <= posFinal) {
            int posMeio = (posFinal + posInicial) / 2;

            if(vetor[posMeio] == chaveBusca){
                    
                int esquerda = posMeio;
                while (esquerda >= posInicial && vetor[esquerda] == chaveBusca) {
                    posChave.add(esquerda);
                    esquerda--;
                }

                int direita = posMeio + 1;
                while (direita <= posFinal && vetor[direita] == chaveBusca) {
                    posChave.add(direita);
                    direita++;
                }
                break;

            }else if(chaveBusca < vetor[posMeio]) posFinal = posMeio - 1;
            else if(chaveBusca > vetor[posMeio]) posInicial = posMeio + 1;
        
        }
        return posChave;
    } 
}
