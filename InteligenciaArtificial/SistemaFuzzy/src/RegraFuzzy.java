import java.util.*;

public class RegraFuzzy {
    private Map<String, String> antecedentes; // Nome da variável -> nome do conjunto (ex: "Temperatura" -> "Alta")
    private String consequenteVariavel;
    private String consequenteConjunto;

    public RegraFuzzy(Map<String, String> antecedentes, String consequenteVariavel, String consequenteConjunto) {
        this.antecedentes = antecedentes;
        this.consequenteVariavel = consequenteVariavel;
        this.consequenteConjunto = consequenteConjunto;
    }

    public double calcularForca(Map<String, Map<String, Double>> valoresFuzzificados) {
        double forca = 1.0;
        for (String variavel : antecedentes.keySet()) {
            String conjunto = antecedentes.get(variavel);
            double pertinencia = valoresFuzzificados.get(variavel).getOrDefault(conjunto, 0.0);
            forca = Math.min(forca, pertinencia); // Operador fuzzy "E" (mínimo)
        }
        return forca;
    }

    public String getConsequenteVariavel() {
        return consequenteVariavel;
    }

    public String getConsequenteConjunto() {
        return consequenteConjunto;
    }
}
