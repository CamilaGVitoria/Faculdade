package Atividade1;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        String expressao;

        System.out.print("Digite a expressão matemática: ");
        expressao = recebe.nextLine();
        
        recebe.close();

        if (verificaParametrizacao(expressao)) {
            System.out.println("Expressão correta.");
        } else {
            System.out.println("Expressão incorreta.");
        }
    }

    public static boolean verificaParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            char topo = pilha.pop();

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false; 
                }
                
                if ((caractere == ')' && topo != '(') ||
                    (caractere == ']' && topo != '[') ||
                    (caractere == '}' && topo != '{')) {
                    return false; 
                }
            }
        }

        return pilha.isEmpty();
    }
}