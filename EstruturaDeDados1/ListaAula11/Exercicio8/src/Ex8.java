import java.util.Random;
import java.util.Stack;

public class Ex8 {
    public static void main(String[] args) {
        Stack<Integer> positivos = new Stack<>(); 
        Stack<Integer> negativos = new Stack<>();

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(201) - 100;
            
            if (numero > 0) {
                positivos.push(numero);
            } else if (numero < 0) {
                negativos.push(numero);
            } else {
                if (!positivos.isEmpty() && !negativos.isEmpty()) {
                    System.out.println("Número retirado da pilha de positivos: " + positivos.pop());
                    System.out.println("Número retirado da pilha de negativos: " + negativos.pop());
                }
            }
        }
    }
}
