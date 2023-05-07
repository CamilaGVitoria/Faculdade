import java.util.Scanner;

public class Ex464 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        double angulo = 0;
        double graus = 0;

        System.out.print("Digite o ângulo em radianos: ");
        angulo = recebe.nextDouble();
        
        graus = radianosParaGraus(angulo);
        
        System.out.println(" Ângulo em graus: " + graus);

        recebe.close();
    }

    public static double radianosParaGraus(double anguloRadianos) {
        double anguloGraus = anguloRadianos * 180.0 / Math.PI;
        
        return anguloGraus;
    }
}
