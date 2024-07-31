package Ex1;

import java.util.Scanner;
import java.util.Stack;

public class SequenciaCaracteres {
        public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite um texto:");
        String texto = scan.nextLine();
        
        imprimirTextoInverso(texto);
        
        if (ehPalindromo(texto)) {
            System.out.println("O texto é um palíndromo.");
        } else {
            System.out.println("O texto não é um palíndromo.");
        }
        
        scan.close();
    }
    
    private static void imprimirTextoInverso(String texto) {
        Stack<Character> pilha = new Stack<>();
        
        for (char c : texto.toCharArray()) {
            pilha.push(c);
        }
        
        System.out.print("Texto na ordem inversa: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
        System.out.println();
    }
    
    private static boolean ehPalindromo(String texto) {
        String textoLimpo = limparTexto(texto);
        Stack<Character> pilha = new Stack<>();
        
        for (char c : textoLimpo.toCharArray()) {
            pilha.push(c);
        }
        
        StringBuilder textoInvertido = new StringBuilder();
        while (!pilha.isEmpty()) {
            textoInvertido.append(pilha.pop());
        }
        
        return textoLimpo.equals(textoInvertido.toString());
    }
    
    private static String limparTexto(String texto) {
        return texto.replaceAll("[ .]", "").toLowerCase();
    }
}
