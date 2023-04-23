import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Ex1 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        Stack<Character> pilha = new Stack<>();
        Deque<Character> fila = new LinkedList<>();

        System.out.print("Digite uma sequência de caracteres: ");
        String texto = recebe.nextLine();

        char[] caracteres = texto.toCharArray();

        for (char c : caracteres) {
            pilha.push(c);
        }

        System.out.print("Texto na ordem inversa: ");

        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
    
        System.out.println();

        String textoSemEspacosEPontos = texto.replaceAll("[ .]", "");
        caracteres = textoSemEspacosEPontos.toCharArray();

        for (char c : caracteres) {
            fila.add(c);
        }

        boolean palindromo = true;

        while (fila.size() > 1) {
            char primeiro = fila.remove();
            char ultimo = fila.removeLast();
            if (Character.toLowerCase(primeiro) != Character.toLowerCase(ultimo)) {
                palindromo = false;
                break;
            }
        }
        
        if (palindromo) {
            System.out.println("O texto é um palíndromo.");
        } else {
            System.out.println("O texto não é um palíndromo.");
        }

        recebe.close();
    }
}
