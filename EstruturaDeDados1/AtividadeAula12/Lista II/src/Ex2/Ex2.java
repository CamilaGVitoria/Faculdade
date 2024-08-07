package Ex2;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        System.out.println( "Digite o prieiro núero: ");
        int x = recebe.nextInt();

        System.out.println("Digite o segundo número: ");
        int y = recebe.nextInt();

        int resultado = mdc(x, y);

        System.out.println("O MDC de " + x + " e " + y + " é: " + resultado);

        recebe.close();
    }

    public static int mdc(int x, int y) {
        if (x == y) {
            return x;
        } else if (x > y) {
            return mdc(x - y, y);
        } else {
            return mdc(y, x);
        }
    }
}
