package Ex358;
import java.util.Scanner;

public class Ex358 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        double precoCompra[] = new double[100];
        double precoVenda[] = new double[100];
        double lucro = 0;
        int lucroMenor10 = 0;
        int lucroMenor20 = 0;
        int lucroMaior20 = 0;
         

        for(int i=0; i<100; i++){
            System.out.println("Digite o preço de compra do " + (i+1) +"º produto: ");
            precoCompra[i] = recebe.nextDouble();

            System.out.println("Digite o preço de venda do " + (i+1) +"º produto: ");
            precoVenda[i] = recebe.nextDouble();

            lucro = precoVenda[i] - precoCompra[i];

            if( ((10/precoCompra[i]) * 100) > lucro ){
                lucroMenor10 ++;
            }else if(((20/precoCompra[i]) * 100) > lucro){
                lucroMenor20 ++;
            }else{
                lucroMaior20 ++;
            }
        }

        System.out.println("Há " + lucroMenor10 + " mercadorias com lucro menor que 10%.");
        System.out.println("Há " + lucroMenor20 + " mercadorias com lucro menor que 20% e maior que 10%.");
        System.out.println("Há " + lucroMaior20 + " mercadorias com lucro maior que 20%.");

        recebe.close();
    }
}