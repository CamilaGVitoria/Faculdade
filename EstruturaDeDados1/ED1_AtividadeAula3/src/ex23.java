import java.util.Scanner;

public class ex23 {
    
    public static void main(String[] args) throws Exception {
    Scanner recebe = new Scanner(System.in);

    int a, d;
    
    System.out.println("Digite um número de três casas: ");
    a = recebe.nextInt();
    

    d = a % 100 / 10;
    
    System.out.println("Algarismo da casa das dezenas: " + d);
    
    recebe.close();

    }

    
}
