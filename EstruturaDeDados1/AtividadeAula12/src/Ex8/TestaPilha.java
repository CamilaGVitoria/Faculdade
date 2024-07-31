package Ex8;

import java.util.Random;
import java.util.Stack;

public class TestaPilha {

    public static void main(String[] args) {
        Stack<Integer> pilhaN = new Stack<>(); 
        Stack<Integer> pilhaP = new Stack<>(); 
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(201) - 100;

            if (numero > 0) {
                pilhaP.push(numero); 
            } else if (numero < 0) {
                pilhaN.push(numero); 
            } else {
                if (!pilhaN.isEmpty() && !pilhaP.isEmpty()) {
                    int negativo = pilhaN.pop();
                    int positivo = pilhaP.pop();
                    System.out.println("Zero encontrado. Removidos: " + negativo + " de N e " + positivo + " de P");
                } else {
                    System.out.println("Zero encontrado, mas uma das pilhas está vazia.");
                }
            }
        }

        System.out.println("\nElementos na pilha N: " + pilhaN);
        System.out.println("Elementos na pilha P: " + pilhaP);
    }
}
