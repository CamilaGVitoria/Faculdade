package Ex4;

public class DecimalParaBinario {

    public static String converterParaBinario(int numeroDecimal) {
        if (numeroDecimal == 0) {
            return "0";
        }

        StringBuilder binario = new StringBuilder();

        while (numeroDecimal > 0) {
            int resto = numeroDecimal % 2;
            binario.insert(0, resto);
            numeroDecimal = numeroDecimal / 2;
        }

        return binario.toString();
    }

}