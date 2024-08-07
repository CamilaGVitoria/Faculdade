package Ex2;

import java.util.Scanner;
import java.util.Stack;

public class RemoveItem {

    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Digite os números para a pilha e para encerrar digite uma letra:");

        while (true) {
            try {
                stack.push(recebe.nextInt());
            } catch (Exception e) {
                break; 
            }
        }

        recebe.nextLine();

        System.out.println("Pilha original: " + stack);

        System.out.print("Digite a chave do item a ser removido: ");
        int c = recebe.nextInt();

        removeItem(stack, c);

        System.out.println("Pilha após a remoção do item: " + stack);

        recebe.close();
    }

    public static void removeItem(Stack<Integer> stack, int c) {
        Stack<Integer> tempStack = new Stack<>();
        boolean encontra = false;

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (top == c && !encontra) {
                encontra = true;
            } else {
                tempStack.push(top); 
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
