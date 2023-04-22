import java.util.Scanner;

public class Ex351 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        String nomes[] = new String[5];

        for(int i=0; i<5; i++){
            System.out.println("Digite um nome: ");
            nomes[i] = recebe.nextLine();
        }
        
        System.out.println("Digite o número da pessoa: ");
        int numero = recebe.nextInt();

        do{
            System.out.println("Número inválido!");
            
            System.out.println("Digite o número da pessoa: ");
            numero = recebe.nextInt();

        }while (numero>5 || numero<1); 

        System.out.println("O nome pertence a pessoa: " + nomes[numero - 1]);

        recebe.close();

    }
}
