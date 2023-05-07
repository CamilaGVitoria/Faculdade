import java.util.Scanner;
import java.util.Arrays;

public class Ex497 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        int vetor[] = new int[10];
        int busca= 0;
        int posicao = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            vetor[i] = recebe.nextInt();
        }

        Arrays.sort(vetor);

        System.out.println("VETOR ORDENADO");
        
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(i + 1 + " - " + vetor[i]);
        }

        System.out.print("\nDigite o número de busca: ");
        busca = recebe.nextInt();

        posicao = buscaBinaria(vetor, busca);

        if (posicao == -1) {
            System.out.println("\nNÃO ENCONTRADO");
        } else {
            System.out.println("\nENCONTRADO na posição " + posicao);
        }

        recebe.close();
    }

    public static int buscaBinaria(int[] vetor, int chave) {
        int inicio = 0;
        int meio= 0;        
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (vetor[meio] == chave) {
                return meio;
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}
