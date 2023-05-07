import java.util.Scanner;
import java.util.Arrays;

public class Ex495 {
    
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        String nomes[] = new String[5];

        for(int i = 0; i < 5; i++) {
            System.out.print("Digite nome " + (i+1) + ": ");
            nomes[i] = recebe.nextLine();
        }

        ordena(nomes);

        System.out.println("\n\nNOMES ORDENADOS");

        for(int i = 0; i < 5; i++) {
            System.out.println((i+1) + " - " + nomes[i]);
        }

        recebe.close();
    }

    public static void ordena(String[] vetor) {
        Arrays.sort(vetor);
    }
}
