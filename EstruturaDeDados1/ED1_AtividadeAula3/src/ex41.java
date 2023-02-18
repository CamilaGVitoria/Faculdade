import java.util.Scanner;

public class ex41 {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        double a, b, c, d, mp;

        System.out.println("entre com o 1 numero: ");
        a = recebe.nextInt();

        System.out.println("entre com o 2 numero: ");
        b = recebe.nextInt();

        System.out.println("entre com o 3 numero: ");
        c = recebe.nextInt();

        System.out.println("entre com o 4 numero: ");
        d = recebe.nextInt();

        mp = (a*1 + b*2 + c*3 + d*4) / 10;

        System.out.println("media ponderada: " + mp);

        recebe.close();
    }
    
}
