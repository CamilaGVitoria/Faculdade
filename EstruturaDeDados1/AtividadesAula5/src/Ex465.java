import java.util.Scanner;

public class Ex465 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        int num1 = 0;
        int num2 =  0;

        System.out.print("Digite o primeiro número: ");
        num1 = recebe.nextInt();

        System.out.print("Digite o segundo número: ");
        num2 = recebe.nextInt();

        maiorNumero(num1, num2);

        recebe.close();
    }

    public static void maiorNumero(int num1, int num2) {
        int maior = num1;

        if (num2 > maior) {
            maior = num2;
        }
        
        System.out.println("O maior número é: " + maior);
    }
}
