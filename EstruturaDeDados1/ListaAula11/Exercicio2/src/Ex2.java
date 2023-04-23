import java.util.Scanner;
import java.util.Stack;

public class Ex2 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();

        System.out.print("Digite uma sequência de números separados por espaço: ");
        String input = recebe.nextLine();

        String[] numerosString = input.split(" ");

        for (String numero : numerosString) {
            pilha.push(Integer.parseInt(numero));
        }

        System.out.print("Digite o número que deseja remover da pilha: ");
        int c = recebe.nextInt();

        removerItemPilha(pilha, c);
        
        System.out.println("Pilha atualizada: " + pilha);

        recebe.close();
    }

    public static void removerItemPilha(Stack<Integer> pilha, int c) {
        Stack<Integer> aux = new Stack<>();

        while (!pilha.isEmpty()) {
            int elemento = pilha.pop();
            if (elemento != c) {
                aux.push(elemento);
            } else {
                break;
            }
        }

        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }
    }
}
