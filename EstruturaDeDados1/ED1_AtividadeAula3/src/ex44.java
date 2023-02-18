import java.util.Scanner;

public class ex44 {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        double num, base, logaritimo;

        System.out.println("entre com o logaritimo: ");
        num = recebe.nextDouble();

        System.out.println("entre com a base: ");
        base = recebe.nextDouble();

        logaritimo = Math.log(num) / Math.log(base);
    
        System.out.println("o logaritimo de " + num + " na base " + base + ": " + logaritimo);

        recebe.close();
    }
}
