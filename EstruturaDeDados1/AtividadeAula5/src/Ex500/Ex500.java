package Ex500;

import java.util.Scanner;

public class Ex500 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        int vetorA[] = new int[5];
        int vetorB[] = new int[5];
        int vetorResultado[] = new int[5];
        int opcao = 0;

        do {
            System.out.println("\n1. Dados do VETOR A\n" +
                    "2. Dados do VETOR B\n" +
                    "3. Imprime VETORES\n" +
                    "4. Soma VETORES\n" +
                    "5. Subtrai VETORES\n" +
                    "6. Sai do programa");
            opcao = recebe.nextInt();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < vetorA.length; i++) {
                        System.out.println("Digite o " + (i + 1) + "º número  do vetor A:");
                        vetorA[i] = recebe.nextInt();
                    }
                    break;

                case 2:
                    for (int i = 0; i < vetorB.length; i++) {
                        System.out.println("Digite o " + (i + 1) + "º número  do vetor B:");
                        vetorB[i] = recebe.nextInt();
                    }

                    break;

                case 3:
                    System.out.println("\nVetor A: ");

                    for(int i=0; i < vetorA.length; i++){
                        System.out.println(vetorA[i]);

                    }

                    System.out.println("\nVetor B: ");

                    for(int i=0; i< vetorB.length; i++){
                        System.out.println(vetorB[i]);
                    }

                    break;

                case 4:
                    System.out.println("\nA soma é:");

                    for(int i=0; i < vetorResultado.length; i++){
                        vetorResultado[i] = vetorA[i] + vetorB[i];
                        System.out.println(vetorResultado[i]);
                    }

                    break;

                case 5:
                    System.out.println("\nA subtração é: ");

                    for(int i=0; i < vetorResultado.length; i++){
                        vetorResultado[i] = vetorA[i] - vetorB[i];
                        System.out.println(vetorResultado[i]);
                    }

                    break;

                case 6:

                    break;

                default:
                    System.out.println("\nOpção invalida!");

                    break;
            }

        } while (opcao != 6);

        recebe.close();
    }
}
