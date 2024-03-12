package Ex346;

import java.util.Scanner;

public class Ex346 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        String frase = "";
        int menu = 0;

        System.out.println("Digie uma frase: ");
        frase = recebe.nextLine();

        char[] vetorFrase = frase.toCharArray();

        System.out.println("MENU\n" +
                "1 - Imprime o comprimento da frase\n" +
                "2 - Imprime os dois primeiros e os dois últimos caracteres da frase\n" +
                "3 - Imprime a frase espelhada\n" +
                "4 - Termina o algoritmo");
        menu = recebe.nextInt();

        switch (menu) {
            case 1:
                int comprimento = vetorFrase.length;

                System.out.println("O comprimento da frase é " + comprimento);
                break;

            case 2:
                char[] doisPrimeiros = new char[2];
                char[] doisUltimos = new char[2];

                for (int i = 0; i < 2; i++) {
                    doisPrimeiros[i] = vetorFrase[i];

                }
                for (int i = vetorFrase.length - 2, j = 0; i < vetorFrase.length; i++, j++) {
                    doisUltimos[j] = vetorFrase[i];

                }

                System.out.println("Os dois primeiros caracteres são: " + new String(doisPrimeiros) +
                        "\nOs dois ultimos caracteres são: " + new String(doisUltimos));

                break;

            case 3:
                String fraseEspelhada = "";

                for(int i=0; i < vetorFrase.length / 2; i++){
                    char temp = vetorFrase[i];
                    vetorFrase[i] = vetorFrase[vetorFrase.length - 1 - i];
                    vetorFrase[vetorFrase.length - 1 - i] = temp;
                }

                fraseEspelhada = new String(vetorFrase);

                System.out.println("A frase espelhada é: " + fraseEspelhada);

                break;

            case 4:
                System.out.println("Programa encerrado!");

                break;

            default:
                System.out.println("Opção inesistente!");
                break;
        }

        recebe.close();
    }
}
