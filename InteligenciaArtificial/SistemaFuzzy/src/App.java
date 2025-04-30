import java.util.*;

public class App {
    public static void main(String[] args) {

        // 🔵 Criando variáveis linguísticas de entrada
        VariavelLinguistica temperatura = new VariavelLinguistica("Temperatura");
        temperatura.adicionarConjunto(new ConjuntoFuzzy("Baixa", 0, 0, 50));
        temperatura.adicionarConjunto(new ConjuntoFuzzy("Media", 30, 60, 90));
        temperatura.adicionarConjunto(new ConjuntoFuzzy("Alta", 70, 100, 100));

        VariavelLinguistica pressao = new VariavelLinguistica("Pressao");
        pressao.adicionarConjunto(new ConjuntoFuzzy("Baixa", 0, 0, 2));
        pressao.adicionarConjunto(new ConjuntoFuzzy("Media", 1, 3, 5));
        pressao.adicionarConjunto(new ConjuntoFuzzy("Alta", 4, 6, 6));

        // 🔴 Variável de saída
        VariavelLinguistica aberturaValvula = new VariavelLinguistica("AberturaValvula");
        aberturaValvula.adicionarConjunto(new ConjuntoFuzzy("Fechada", 0, 0, 30));
        aberturaValvula.adicionarConjunto(new ConjuntoFuzzy("Parcial", 20, 50, 80));
        aberturaValvula.adicionarConjunto(new ConjuntoFuzzy("Total", 70, 100, 100));

        // ⚙️ Criando o sistema fuzzy
        SistemaFuzzy sistema = new SistemaFuzzy();
        sistema.adicionarVariavelEntrada(temperatura);
        sistema.adicionarVariavelEntrada(pressao);
        sistema.definirVariavelSaida(aberturaValvula);

        // 📐 Regras fuzzy
        // Se Temperatura é Alta e Pressão é Alta, então Abertura é Total
        Map<String, String> regra1 = new HashMap<>();
        regra1.put("Temperatura", "Alta");
        regra1.put("Pressao", "Alta");
        sistema.adicionarRegra(new RegraFuzzy(regra1, "AberturaValvula", "Total"));

        // Se Temperatura é Media e Pressão é Media, então Abertura é Parcial
        Map<String, String> regra2 = new HashMap<>();
        regra2.put("Temperatura", "Media");
        regra2.put("Pressao", "Media");
        sistema.adicionarRegra(new RegraFuzzy(regra2, "AberturaValvula", "Parcial"));

        // Se Temperatura é Baixa e Pressão é Baixa, então Abertura é Fechada
        Map<String, String> regra3 = new HashMap<>();
        regra3.put("Temperatura", "Baixa");
        regra3.put("Pressao", "Baixa");
        sistema.adicionarRegra(new RegraFuzzy(regra3, "AberturaValvula", "Fechada"));

        // 🔢 Valores de entrada
        Map<String, Double> entradas = new HashMap<>();
        entradas.put("Temperatura", 85.0); // valor real da temperatura
        entradas.put("Pressao", 5.0); // valor real da pressão

        // 📤 Rodar inferência
        double saida = sistema.inferir(entradas);
        System.out.println("Abertura da válvula (0-100): " + saida);
    }
}