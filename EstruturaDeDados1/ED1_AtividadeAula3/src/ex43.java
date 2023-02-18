import java.util.Scanner;

public class ex43 {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        double num, logaritimo;

        System.out.println("entre com o logaritimo: ");
        num = recebe.nextDouble();

        logaritimo = Math.log(num) / Math.log(10);
    
        System.out.println("logaritimo: " + logaritimo);

        recebe.close();
    }
}
