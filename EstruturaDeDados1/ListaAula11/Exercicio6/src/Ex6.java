import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex6 {
    public static void main(String[] args) {
        Queue<Integer> f = new LinkedList<>();
        Stack<Integer> p = new Stack<>();

        for (int i = 0; i < 1000; i++) {
            f.offer((int) (Math.random() * 1000));
            f.offer((int) (Math.random() * -1000));
        }

        while (!f.isEmpty()) {
            int valor = f.poll();

            if (valor >= 0) {
                p.push(valor);
            } else {
                if (!p.isEmpty()) {
                    int topo = p.pop();
                    System.out.println("Número retirado da pilha: " + topo);
                }
            }
        }

        System.out.println("Fila final: " + f);
        System.out.println("Pilha final: " + p);
    }
}
