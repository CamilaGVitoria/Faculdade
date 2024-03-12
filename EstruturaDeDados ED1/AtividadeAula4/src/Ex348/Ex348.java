package Ex348;
import java.util.Arrays;
import java.util.Scanner;

public class Ex348 {

    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        String nome[] = new String[5];
        double nota1[] = new double[5];
        double nota2[] = new double[5];
        double media[] = new double[5];

        for(int i = 0; i < 5; i++){
            System.out.println("Digite o nome do "+ (i+1) +"º aluno: ");
            nome[i] = recebe.nextLine();
            
            System.out.println("Digite a primeia nota do "+ (i+1) +"º aluno: ");
            nota1[i] = recebe.nextDouble();

            System.out.println("Digite a segunda nota do "+ (i+1) +"º aluno: ");
            nota2[i] = recebe.nextDouble();

            media[i] = (nota1[i] + nota2[i]) / 2;
            
            recebe.nextLine();
        }

        System.out.println("\nRELAÇÃO FINAL");

        System.out.println(Arrays.toString(nome) + "\n" +Arrays.toString(nota1) + "\n" + 
            Arrays.toString(nota2) + "\n" + Arrays.toString(media));
    
        recebe.close();
    }
}