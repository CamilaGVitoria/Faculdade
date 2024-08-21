package Atividade1;

import java.util.Scanner;
import java.util.Stack;

public class VerificaExpressoesAritimeticas {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        System.out.println("Digite uma expressão aritmética:");
        String expressao = recebe.nextLine();

        if (verificaExpressao(expressao)) {
            System.out.println("A expressão está correta.");
        } else {
            System.out.println("A expressão está incorreta.");
        }

        recebe.close();
    }

    public static boolean verificaExpressao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false;
                }
                char topo = pilha.pop();
                if (!corresponde(topo, caractere)) {
                    return false;
                }
            }
        }
        return pilha.isEmpty();
    }

    private static boolean corresponde(char abre, char fecha) {
        return (abre == '(' && fecha == ')') ||
                (abre == '[' && fecha == ']') ||
                (abre == '{' && fecha == '}');
    }

}
