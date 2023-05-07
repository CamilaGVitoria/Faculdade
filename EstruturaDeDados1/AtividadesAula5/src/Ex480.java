import java.util.Scanner;

public class Ex480 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        int n = 0;
        int x = 0;

        System.out.print("Digite um número: ");
        n = recebe.nextInt();
        
        x = reverso(n);

        System.out.println(n + " - " + x);
        
        if (x == n) {
            System.out.println("É um número capicua.");
        } else {
            System.out.println("Não é um número capicua.");
        }

        recebe.close();
    }

    public static int reverso(int n) {
        int rev = 0;

        while (n != 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }

        return rev;
    }
}
