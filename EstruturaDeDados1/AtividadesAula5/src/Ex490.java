import java.util.Scanner;

public class Ex490 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        String palavras[] = new String[10];
        int totalRetirado1 = 0;
        char caractere;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a palavra " + (i+1) + ": ");
            palavras[i] = recebe.nextLine();
        }

        System.out.print("Digite o caractere a ser retirado: ");
        caractere = recebe.nextLine().charAt(0);

        for (int i = 0; i < palavras.length; i++) {
            int totalRetirado = retirarCaractere(palavras[i], caractere);
            System.out.println((i+1) + " - " + palavras[i]);

            if(totalRetirado >= 1){
                totalRetirado1 ++;
            }
        }

        System.out.println(totalRetirado1);

        recebe.close();

    }

    public static int retirarCaractere(String palavra, char caractere) {
        int totalRetirado = 0;
        char caracteres[] = palavra.toCharArray();
       
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == caractere) {
                caracteres[i] = '*';
                totalRetirado++;
            }
        }

        palavra = new String(caracteres);
        return totalRetirado;
    }
}
