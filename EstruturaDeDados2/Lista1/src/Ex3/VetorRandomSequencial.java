package Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VetorRandomSequencial {

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
        List<Integer> posicoes = buscaSequencial(vetor, valor);
        long tempoFim = System.currentTimeMillis();

        double tempoExecucao = (tempoFim - tempoInicio) / 1000.0;

        System.out.println("Valor encontrado nas posições: " + posicoes);
        System.out.println("Tempo de busca do valor: " + tempoExecucao + "s.");

        recebe.close();

    }

    public static List<Integer> buscaSequencial(int vetor[], int chaveBusca) {
        List<Integer> posChave = new ArrayList<>();

        for (int i = 0; i < vetor.length; i++) {
            if (chaveBusca == vetor[i]) {
                posChave.add(i);

            }

        }

        return posChave;
    }
}