import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String palavra = recebe.nextLine();

        System.out.println("Digite a sua chave: ");
        String chave = recebe.nextLine();

        String palavraCifrada = criptar(palavra, chave.toLowerCase());
        String palavraDecifrada = decriptar(palavraCifrada, chave.toLowerCase());

        System.out.println("\nPalavra digitada: " + palavra);
        System.out.println("Chave: " + chave);
        System.out.println("Palavra encriptada: " + palavraCifrada);
        System.out.println("Palavra decriptada: " + palavraDecifrada);

        recebe.close();
    }

    public static String criptar(String palavra, String chave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palavra.length(); i++) {
            char caracterePalavra = palavra.charAt(i);
            char caractereChave = chave.charAt(i % chave.length());
            int deslocamento = caractereChave - 'a';

            if (Character.isUpperCase(caracterePalavra)) {
                char ch = (char) (((int) caracterePalavra + deslocamento - 65) % 26 + 65);
                resultado.append(ch);
            } else if (Character.isLowerCase(caracterePalavra)) {
                char ch = (char) (((int) caracterePalavra + deslocamento - 97) % 26 + 97);
                resultado.append(ch);
            } else {
                resultado.append(caracterePalavra);
            }
        }
        return resultado.toString();
    }

    public static String decriptar(String palavraCifrada, String chave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palavraCifrada.length(); i++) {
            char caracterePalavra = palavraCifrada.charAt(i);
            char caractereChave = chave.charAt(i % chave.length());
            int deslocamento = caractereChave - 'a';

            if (Character.isUpperCase(caracterePalavra)) {
                char ch = (char) (((int) caracterePalavra - deslocamento - 65 + 26) % 26 + 65);
                resultado.append(ch);
            } else if (Character.isLowerCase(caracterePalavra)) {
                char ch = (char) (((int) caracterePalavra - deslocamento - 97 + 26) % 26 + 97);
                resultado.append(ch);
            } else {
                resultado.append(caracterePalavra);
            }
        }
        return resultado.toString();
    }
}
