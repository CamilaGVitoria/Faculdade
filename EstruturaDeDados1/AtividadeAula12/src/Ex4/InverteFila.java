package Ex4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class InverteFila {
    public static void main(String[] args) {
        Queue<Integer> filaF1 = gerarFilaAleatoria(100);
        System.out.println("Fila F1: " + filaF1);

        Queue<Integer> filaF2 = inverterFila(filaF1);
        System.out.println("Fila F2 (invertida): " + filaF2);
    }

    private static Queue<Integer> gerarFilaAleatoria(int tamanho) {
        Queue<Integer> fila = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            fila.add(random.nextInt(1000));
        }
        return fila;
    }

    private static Queue<Integer> inverterFila(Queue<Integer> filaOriginal) {
        Queue<Integer> filaInvertida = new LinkedList<>();
        LinkedList<Integer> pilha = new LinkedList<>(filaOriginal);

        while (!pilha.isEmpty()) {
            filaInvertida.add(pilha.removeLast());
        }

        return filaInvertida;
    }
}
