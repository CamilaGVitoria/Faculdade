import java.util.Scanner;

public class Ex485 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        int[] numeros = new int[6];
        char[] caracteres = new char[6];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = recebe.nextInt();
        }

        for (int i = 0; i < caracteres.length; i++) {
            System.out.print("Digite o caractere " + (i + 1) + ": ");
            caracteres[i] = recebe.next().charAt(0);
        }

        multivetor(numeros, caracteres);

        recebe.close();
    }

    public static void multivetor(int[] numeros, char[] caracteres) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i]; j++) {
                System.out.print(caracteres[i]);
            }
            System.out.println();
        }
    }
}
