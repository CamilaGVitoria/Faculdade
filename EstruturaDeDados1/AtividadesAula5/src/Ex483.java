import java.util.Scanner;

public class Ex483 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
    
        int[] vetorA = new int[4];
        int[] vetorB = new int[4];
        int produtoInterno = 0;

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + (i + 1) + "º número do vetor A: ");
            vetorA[i] = recebe.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + (i + 1) + "º número do vetor B: ");
            vetorB[i] = recebe.nextInt();
        }

        produtoInterno = calcularProduto(vetorA, vetorB, 4);

        System.out.println("\nVetor A\tVetor B");
        for (int i = 0; i < 4; i++) {
            System.out.println(vetorA[i] + "\t" + vetorB[i]);
        }
        
        System.out.println("\nProduto interno: " + produtoInterno);

        recebe.close();
    }

    public static int calcularProduto(int[] vetorA, int[] vetorB, int tamanho) {
        int produtoInterno = 0;
        
        for (int i = 0; i < tamanho; i++) {
            produtoInterno += vetorA[i] * vetorB[i];
        }
        
        return produtoInterno;
    }
}
