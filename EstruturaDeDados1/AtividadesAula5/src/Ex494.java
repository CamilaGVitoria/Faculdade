import java.util.Scanner;

public class Ex494 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        String nome[] = new String[3];
        String endereco[] = new String[3];
        String professor[] = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite nome: ");
            nome[i] = recebe.nextLine();

            System.out.print("Digite endereco: ");
            endereco[i] = recebe.nextLine();

            System.out.print("Digite profissao: ");
            professor[i] = recebe.nextLine();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (nome[i].compareTo(nome[j]) > 0) {
                    troca(nome, i, j);
                    troca(endereco, i, j);
                    troca(professor, i, j);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(nome[i] + "\t" + endereco[i] + "\t" + professor[i]);
        }

        recebe.close();
    }

    public static void troca(String[] vetor, int i, int j) {
        String temp = vetor[i];
        
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
