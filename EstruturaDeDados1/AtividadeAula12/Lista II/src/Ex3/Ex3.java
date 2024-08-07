package Ex3;
import java.util.Scanner;

public class Ex3 {

    public static int calcularMOD(int x, int y) {
        if (x == y) {
            return 0;
        }
        if (x < y) {
            return x;
        }
        return calcularMOD(x - y, y);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o valor de x (inteiro positivo): ");
        int x = scan.nextInt();

        System.out.print("Digite o valor de y (inteiro positivo): ");
        int y = scan.nextInt();

        if (x <= 0 || y <= 0) {
            System.out.println("Ambos os números devem ser inteiros positivos.");
        } else {
            int resultado = calcularMOD(x, y);

            System.out.println("O resto da divisão de " + x + " por " + y + " é: " + resultado);
        }

        scan.close();
    }
}
