import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Ex5 {
    public static void main(String[] args) {
        Random rand = new Random();
        Queue<Integer> f = new LinkedList<>();
        Stack<Integer> p = new Stack<>();

        for (int i = 0; i < 1000; i++) {
            int num = rand.nextInt(1000);

            if (!f.contains(num)) {
                f.offer(num);
            } else {
                p.push(num);
            }
        }

        System.out.println("Fila: " + f);
        System.out.println("Pilha: " + p);
    }
}
