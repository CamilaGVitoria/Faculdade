import java.util.Scanner;

public class Ex487 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        int[] num = new int[10];
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite numero " + (i + 1) + ": ");
            num[i] = recebe.nextInt();
        }

        inverte(num, 10);

        System.out.println("\nVETOR");

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + " - " + num[i]);
        }

        recebe.close();
    }

    public static void inverte(int[] vet, int max) {
        int k = max - 1;
        int aux = 0;
        
        for (int i = 0; i < max / 2; i++) {
            aux = vet[i];
            k--;
            vet[i] = vet[k];
            vet[k] = aux;
        }
    }
}
