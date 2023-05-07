import java.util.Scanner;

public class Ex463 {
    
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        double angulo = 0;
        double radiano = 0;

        System.out.print("Digite o ângulo em graus: ");
        angulo = recebe.nextDouble();
        
        radiano = grausParaRadianos(angulo);
       
        System.out.println("Ângulo em radianos: " + radiano);

        recebe.close();
    }

    public static double grausParaRadianos(double anguloGraus) {
        double anguloRadianos = anguloGraus * Math.PI / 180.0;
        
        return anguloRadianos;
    }
}