import java.util.Scanner;

public class Ex471 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
 
        int num = 0;
        int numl = 0;
        int n = 0;

        System.out.print("Digite o dividendo: ");
        num = recebe.nextInt();

        System.out.print("Digite o divisor: ");
        numl = recebe.nextInt();

        while (numl > num) {
            System.out.print("INVALIDO. Digite numero menor do que o dividendo: ");
            numl = recebe.nextInt();
        }

        n = divisor(num, numl);

        if (n == 0) {
            System.out.println("Nenhuma vez");
        } else {
            System.out.println("Numero de vezes: " + n);
        }

        recebe.close();
    }

    public static int divisor(int x, int y) {
        int r= 0;
        int n = 0;
        
        r = x % y;
        
        while (r == 0) {
            n++;
            x = x / y;
            r = x % y;
        }
        
        return n;
    }
}
