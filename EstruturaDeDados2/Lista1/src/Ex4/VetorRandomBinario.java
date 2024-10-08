package Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class VetorRandomBinario {

    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        Random random = new Random();
        int vetor[] = new int[100000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(10000);
        }
        

        System.out.println("Digite o valor que deseja procurar: ");
        int valor = recebe.nextInt();

        long tempoInicio = System.currentTimeMillis();
        List<Integer> posicoes = buscaBinaria(vetor, valor);
        long tempoFim = System.currentTimeMillis();

        double tempoExecucao = (tempoFim - tempoInicio) / 1000.0;

        Arrays.sort(vetor);

        long tempoInicioOrdenado = System.currentTimeMillis();
        List<Integer> posicoesOrdenado = buscaBinaria(vetor, valor);
        long tempoFimOrdenado = System.currentTimeMillis();

        double tempoExecucaoOrdenado = (tempoFimOrdenado - tempoInicioOrdenado) / 1000.0;

        System.out.println("Não ordenado - Valor encontrado nas posições: " + posicoes);
        System.out.println("Tempo de busca do valor: " + tempoExecucao + "s.");

        System.out.println("Ordenado - Valor encontrado nas posições: " + posicoesOrdenado);
        System.out.println("Tempo de busca do valor de forma ordeanda: " + tempoExecucaoOrdenado + "s.");

        recebe.close();

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