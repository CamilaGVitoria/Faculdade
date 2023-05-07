import java.util.Scanner;

public class Ex467 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        double z = 0;
        double L = 0;
        double b = 0;
        int c= 0;

        for (c = 1; c <= 3; c++) {
            System.out.print("\nDigite logaritmando maior do que 0: ");
            L = recebe.nextDouble();
            
            while (L <= 0) {
                System.out.print("\nInválido. Digite logaritmando maior do que 0: ");
                L = recebe.nextDouble();
            }
            
            System.out.print("\nDigite base maior que 0 e diferente de 1: ");
            b = recebe.nextDouble();
            
            while (b <= 0 || b == 1) {
                System.out.print("\nInválido. Digite base maior que 0 e diferente de 1: ");
                b = recebe.nextDouble();
            }
            
            System.out.printf("\nlogaritmo é %.5f\n", logaritmo(L, b));
            
            z = logaritmo(L, b);
            
            System.out.println("z = " + z);
        }

        recebe.close();
    }

    public static double logaritmo(double base, double expo) {
        double i;
        
        i = Math.log(base) / Math.log(expo);
        
        return i;
    }
}
