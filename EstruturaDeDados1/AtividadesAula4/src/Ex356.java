import java.util.Scanner;

public class Ex356 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        String nome[] = new String[15];
        double notaPr1[] = new double[15];
        double notaPr2[] = new double[15];
        double media[] = new double[15];
        String situacao[] = new String[15];
        

        for(int i=0; i<15; i++){
            System.out.println("Digite o nome do " + (i+1) + "º aluno:  ");
            nome[i] = recebe.nextLine();

            System.out.println("Digite a primeira nota do " + (i+1) + "º aluno:  ");
            notaPr1[i] = recebe.nextDouble();

            System.out.println("Digite a primeira nota do " + (i+1) + "º aluno:  ");
            notaPr2[i] = recebe.nextDouble();

            recebe.nextLine();

            media[i] = (notaPr1[i] + notaPr2[i]) / 2;

            if(media[i]< 6){
                situacao[i] = "RP";
            }else{
                situacao[i] = "AP";
            }
 
        }

    System.out.println("\nNome\tNota1\tNota2\tMédia\tSituação");

        for(int i=0; i<15; i++){
            System.out.print(nome[i] + "\t");
            System.out.print(notaPr1[i] + "\t");
            System.out.print(notaPr2[i] + "\t");
            System.out.print(media[i] + "\t");
            System.out.println(situacao[i]);
        }
        
    recebe.close();

    }
}
