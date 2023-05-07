import java.util.Scanner;

public class Ex493 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        int num[] = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite número " + (i+1) + ": ");
            num[i] = recebe.nextInt();
        }

        int ordem = verificaOrdem(num, 10);
        if (ordem == 1) {
            System.out.println("\nORDENAÇÃO CRESCENTE");
        } else if (ordem == 2) {
            System.out.println("\nORDENAÇÃO DECRESCENTE");
        } else {
            System.out.println("\nNÃO ESTÁ ORDENADO");
        }

        recebe.close();
    }

    public static int verificaOrdem(int[] vetor, int tamanho) {
        int crescente = 1;
        int decrescente = 2;
        int naoOrdenado = 0;
        boolean ordemCrescente = true;
        boolean ordemDecrescente = true;

        for (int i = 0; i < tamanho - 1; i++) {
            if (vetor[i] > vetor[i+1]) {
                ordemCrescente = false;
            } else if (vetor[i] < vetor[i+1]) {
                ordemDecrescente = false;
            }
        }

        if (ordemCrescente) {
            return crescente;
        } else if (ordemDecrescente) {
            return decrescente;
        } else {
            return naoOrdenado;
        }
    }
}
