package Ex470;

import java.util.Scanner;

public class Ex470 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        int num = 0; 
        int numPrimo = 0;

        System.out.println("Digite um número maior que 0:");
        num = recebe.nextInt();
        
        numPrimo = verificaPrimo(num);
        
        if (numPrimo == 0) {
            System.out.println(num + " é primo");
        } else {
            System.out.println(num + " não é primo");
        }

        recebe.close();
    }

    public static int verificaPrimo(int n) {
        int c = 0;
        int p = 2;
        
        while (c == 0 && p <= n / 2) {
            if (n % p == 0) {
                c = 1;
            }
            p++;
        }

        return c;
    }
}
