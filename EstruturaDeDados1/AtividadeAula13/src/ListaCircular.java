import java.util.Random;

public class ListaCircular {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        int[] vetor = new int[1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            vetor[i] = random.nextInt(19999) - 9999;
        }

        System.out.println("Vetor original:");
        for (int i : vetor) {
            System.out.print(i + ", ");
        }
        System.out.println("\n");

        System.out.println("Inserção na Lista em ordem crescente:");
        for (int i : vetor) {
            lista.inserirOrdenado(i);
            lista.imprimirCrescente();
        }

        System.out.println("\nLista em ordem crescente:");
        lista.imprimirCrescente();

        System.out.println("Lista em ordem decrescente:");
        lista.imprimirDecrescente();

        lista.removerPrimos();
        System.out.println("\nLista após remoção dos números primos em ordem crescente:");
        lista.imprimirCrescente();

        System.out.println("Lista após remoção dos números primos em ordem decrescente:");
        lista.imprimirDecrescente();
    }
}
