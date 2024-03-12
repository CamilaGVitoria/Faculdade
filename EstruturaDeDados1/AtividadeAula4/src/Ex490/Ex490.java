package Ex490;

import java.util.Scanner;

public class Ex490 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);


        String palavras[] = new String[10];
        int totalRetirado = 0;
        char caractere;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a palavra " + (i+1) + ": ");
            palavras[i] = recebe.nextLine();
        }

        System.out.print("Digite o caractere a ser retirado: ");
        caractere = recebe.nextLine().charAt(0);

        for (int i = 0; i < palavras.length; i++) {
            String palavraModificada = retirarCaractere(palavras[i], caractere);
            System.out.println((i+1) + " - " + palavraModificada);

            if(palavraModificada.contains("*")) {
                totalRetirado += palavraModificada.chars().filter(ch -> ch == '*').count();
            }
        }

        System.out.println("O total de caracteres retirados é: " + totalRetirado);

        recebe.close();

    }

    public static String retirarCaractere(String palavra, char caractere) {
        char caracteres[] = palavra.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == caractere) {
                caracteres[i] = '*';
            }
        }

        return new String(caracteres);
    }
}
