package Ex6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        Queue<Integer> fila = gerarFilaAleatoria(2000);
        System.out.println("Fila gerada: " + fila);

        Stack<Integer> pilha = new Stack<>();

        processarFila(fila, pilha);
    }

    private static Queue<Integer> gerarFilaAleatoria(int tamanho) {
        Queue<Integer> fila = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < tamanho / 2; i++) {
            fila.add(random.nextInt(1000) + 1);
        }

        for (int i = 0; i < tamanho / 2; i++) {
            fila.add(-(random.nextInt(1000) + 1));
        }

        return fila;
    }

    private static void processarFila(Queue<Integer> fila, Stack<Integer> pilha) {
        while (!fila.isEmpty()) {
            int numero = fila.poll();
            if (numero > 0) {

                pilha.push(numero);
                System.out.println("Número positivo " + numero + " empilhado.");
            } else {
                if (!pilha.isEmpty()) {
                    int topoPilha = pilha.pop();
                    System.out.println("Número negativo " + numero + " encontrado. Número do topo da pilha " + topoPilha
                            + " impresso.");
                } else {
                    System.out.println("Número negativo " + numero + " encontrado, mas a pilha está vazia.");
                }
            }
        }
    }
}
