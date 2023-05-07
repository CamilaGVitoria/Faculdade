import java.util.Scanner;

public class Ex462 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        double nota1 = 0;
        double nota2 = 0;
        double nota3 = 0;
        double media = 0;

        System.out.print("Digite a nota da primeira prova: ");
        nota1 = recebe.nextDouble();
        
        System.out.print("Digite a nota da segunda prova: ");
        nota2 = recebe.nextDouble();
        
        System.out.print("Digite a nota da terceira prova: ");
        nota3 = recebe.nextDouble();
        
        media = calculoMedia(nota1, nota2, nota3);
        
        System.out.println("A média aritmética das notas é " + media + ".");

        recebe.close();
    }

    public static double calculoMedia(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }
}