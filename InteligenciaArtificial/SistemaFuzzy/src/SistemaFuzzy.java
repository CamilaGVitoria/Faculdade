import java.util.*;

public class SistemaFuzzy {
    private Map<String, VariavelLinguistica> variaveisEntrada;
    private VariavelLinguistica variavelSaida;
    private List<RegraFuzzy> regras;

    public SistemaFuzzy() {
        this.variaveisEntrada = new HashMap<>();
        this.regras = new ArrayList<>();
    }

    public void adicionarVariavelEntrada(VariavelLinguistica variavel) {
        variaveisEntrada.put(variavel.getNome(), variavel);
    }

    public void definirVariavelSaida(VariavelLinguistica variavel) {
        this.variavelSaida = variavel;
    }

    public void adicionarRegra(RegraFuzzy regra) {
        regras.add(regra);
    }

    public double inferir(Map<String, Double> entradas) {
        Map<String, Map<String, Double>> valoresFuzzificados = new HashMap<>();

        // Fuzzificação
        for (String nomeVar : entradas.keySet()) {
            VariavelLinguistica var = variaveisEntrada.get(nomeVar);
            double valor = entradas.get(nomeVar);
            valoresFuzzificados.put(nomeVar, var.fuzzificar(valor));
        }

        // Agregação das regras
        Map<String, Double> saidaAgregada = new HashMap<>();
        for (RegraFuzzy regra : regras) {
            double forca = regra.calcularForca(valoresFuzzificados);
            String conjunto = regra.getConsequenteConjunto();
            double valorAtual = saidaAgregada.getOrDefault(conjunto, 0.0);
            saidaAgregada.put(conjunto, Math.max(forca, valorAtual));
        }

        // Defuzzificação (método do centroide simplificado)
        double numerador = 0.0;
        double denominador = 0.0;

        for (ConjuntoFuzzy conjunto : variavelSaida.getConjuntos()) {
            double grau = saidaAgregada.getOrDefault(conjunto.getNome(), 0.0);
            double centro = (conjunto.getA() + conjunto.getB() + conjunto.getC()) / 3.0; // centro aproximado
            numerador += grau * centro;
            denominador += grau;
        }

        if (denominador == 0)
            return 0;
        return numerador / denominador;
    }
}