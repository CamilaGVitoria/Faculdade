import java.util.Scanner;

public class ex40 {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        int quoc, rest, val1, val2;

        System.out.println("entre com o dividendo: ");
        val1 = recebe.nextInt();

        System.out.println("entre com o divisor: ");
        val2 = recebe.nextInt();

        quoc = val1 / val2;
        rest = val1 % val2;

        System.out.println("dividendo: " + val1);
        System.out.println("divisor: " + val2);
        System.out.println("quociente: " + quoc);
        System.out.println("resto: " + rest);
    
        recebe.close();
    }
}
