import java.util.*;

public class VariavelLinguistica {
    private String nome;
    private List<ConjuntoFuzzy> conjuntos;

    public VariavelLinguistica(String nome) {
        this.nome = nome;
        this.conjuntos = new ArrayList<>();
    }

    public void adicionarConjunto(ConjuntoFuzzy conjunto) {
        conjuntos.add(conjunto);
    }

    public Map<String, Double> fuzzificar(double valor) {
        Map<String, Double> pertinencias = new HashMap<>();
        for (ConjuntoFuzzy conjunto : conjuntos) {
            pertinencias.put(conjunto.getNome(), conjunto.calcularPertinencia(valor));
        }
        return pertinencias;
    }

    public String getNome() {
        return nome;
    }

    public List<ConjuntoFuzzy> getConjuntos() {
        return conjuntos;
    }
}
