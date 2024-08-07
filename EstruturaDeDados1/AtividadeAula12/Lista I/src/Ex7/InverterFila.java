package Ex7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InverterFila {

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        for (int i = 1; i <= 20; i++) {
            fila.add(i);
        }

        System.out.println("Fila inicial: " + fila);

        inverteFila(fila);

        System.out.println("Fila invertida: " + fila);
    }

    public static void inverteFila(Queue<Integer> fila) {
        Stack<Integer> pilha = new Stack<>();

        while (!fila.isEmpty()) {
            pilha.push(fila.remove());
        }

        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }
    }
}
