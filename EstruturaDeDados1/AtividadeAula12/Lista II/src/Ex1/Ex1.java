package Ex1;
import java.util.Scanner;

public class Ex1 {

    private static final int N = 0;

    public static int contarDigitos(int N, int K) {
        if (N == 0) {
            return 0;
        }

        int ultimoDigito = N % 10;
        int resto = N / 10;

        if (ultimoDigito == K) {
            return 1 + contarDigitos(resto, K);
        } else {
            return contarDigitos(resto, K);
        }
    }

    public static void main(String[] args) {
       Scanner scan = new Scanner (System.in);
        int N;
        int K;

        System.out.println("Digite um numero: ");
        N = scan.nextInt();

        System.out.println("Digite um numero para reverifivar a quantidade de ocorrencia: ");
        K = scan.nextInt();

        int resultado = contarDigitos(N, K);
        System.out.println("O dígito " + K + " ocorre " + resultado + " vezes no número " + N);

        scan.close();
    }
}
