package Ex5;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class FilaPilha {

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();
        Set<Integer> conjuntoFila = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(10000); 

            if (!conjuntoFila.contains(numero)) {
                fila.add(numero);
                conjuntoFila.add(numero);
            } else {
                pilha.push(numero);
            }
        }


        System.out.println("Fila F:");
        for (int num : fila) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nPilha P:");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }
    }
}


