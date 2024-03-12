package Ex460;

import java.util.Scanner;

public class Ex460 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        int numero = 0;
        int dobro = 0;
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite um número: ");
            numero = recebe.nextInt();
            dobro = dob(numero);
            System.out.println("O dobro de " + numero + " é " + dobro);
        }

        recebe.close();
    }

    public static int dob(int x) {
        return x * 2;
    }
}
