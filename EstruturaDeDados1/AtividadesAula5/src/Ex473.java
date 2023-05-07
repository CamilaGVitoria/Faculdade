import java.util.Scanner;

public class Ex473 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        String c = "";
        int x = 0;
        
        System.out.print("Digite letra: ");
        c = recebe.nextLine();
        
        x = maiuscula(c);
        
        if (x == 1) {
            System.out.println("É uma consoante");
        } else {
            System.out.println("Não é uma consoante");
        }

        recebe.close();
    }

    public static int maiuscula(String letra) {
        
        if (letra.equals("A") || letra.equals("a") ||
                letra.equals("E") || letra.equals("e") ||
                letra.equals("I") || letra.equals("i") ||
                letra.equals("O") || letra.equals("o") ||
                letra.equals("U") || letra.equals("u")) {
            return 0;
        } else {
            return 1;
        }
    }
}
