import java.util.Scanner;

public class ex42 {
    public static void main(String[] args) throws Exception {
        Scanner recebe =  new Scanner(System.in);

        double angulo, rang;

        System.out.println("digite um angulo em graus: ");
        angulo = recebe.nextDouble();

        rang = angulo* (3.14) /180;

        System.out.println("seno: " + Math.sin(rang));
        System.out.println("co-sen: " + Math.cos(rang));
        System.out.println("tangente: " + Math.tan(rang));
        System.out.println("co-secante: " + (1 / Math.sin(rang)));
        System.out.println("secante: " + (1 / Math.cos(rang)));
        System.out.println("cotangente: " + (1 / Math.tan(rang)));

        recebe.close();
    }
}
