package Ex2;

import java.util.Scanner;

public class CifraDeCesarAritimeticaModular {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String palavra = recebe.nextLine();

        System.out.println("Digite a sua chave (um número inteiro): ");
        int chave = recebe.nextInt();

        long inicioTempo = System.nanoTime();
        String palavraCifrada = criptar(palavra, chave);
        String palavraDecifrada = decriptar(palavraCifrada, chave);
        long fimTempo = System.nanoTime();
        double tempo = (fimTempo - inicioTempo) / 1_000_000.0;

        System.out.println("\nPalavra digitada: " + palavra);
        System.out.println("Chave: " + chave);
        System.out.println("Palavra encriptada: " + palavraCifrada);
        System.out.println("Palavra decriptada: " + palavraDecifrada);
        System.out.println("Tempo de descriptografia: " + tempo+ " ms");

        recebe.close();
    }

    public static String criptar(String palavra, int chave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palavra.length(); i++) {
            char caractere = palavra.charAt(i);
            if (Character.isUpperCase(caractere)) {
                char ch = (char) (((caractere - 'A' + chave) % 26 + 26) % 26 + 'A');
                resultado.append(ch);
            } else if (Character.isLowerCase(caractere)) {
                char ch = (char) (((caractere - 'a' + chave) % 26 + 26) % 26 + 'a');
                resultado.append(ch);
            } else {
                resultado.append(caractere);
            }
        }
        return resultado.toString();
    }

    public static String decriptar(String palavraCifrada, int chave) {
        return criptar(palavraCifrada, -chave);
    }
}


