import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex7 {        
    public static void main(String[] args) {
        Queue<Integer> f = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            f.add(i);
        }
        System.out.println("Fila original: " + f);
        inverterFilaComPilha(f);
        System.out.println("Fila invertida: " + f);
    }
    
    public static void inverterFilaComPilha(Queue<Integer> f) {
        Stack<Integer> p = new Stack<>();
        while (!f.isEmpty()) {
            p.push(f.poll());
        }
        while (!p.isEmpty()) {
            f.add(p.pop());
        }
    }
}
