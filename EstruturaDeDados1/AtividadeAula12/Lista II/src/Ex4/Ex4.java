package Ex4;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        Scanner recebe = new Scanner(System.in);

        System.out.print("Digite um número decimal: ");
        int numeroDecimal = recebe.nextInt();

        String binario = DecimalParaBinario.converterParaBinario(numeroDecimal);

        System.out.println("O número " + numeroDecimal + " em binário é: " + binario);

        recebe.close();
    }

}
