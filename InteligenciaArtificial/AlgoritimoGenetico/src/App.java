import java.util.*;

class Item {
    int valor, peso;

    public Item(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }
}

public class App {
    static final int pesoMax = 15;
    static final int tamanhoPopulacao = 10;
    static final double chanceMutacao = 0.1;
    static final int geracoes = 50;
    static final Random rand = new Random();

    static List<Item> itens = Arrays.asList(
            new Item(10, 2), new Item(5, 3), new Item(15, 5),
            new Item(7, 7), new Item(6, 1), new Item(18, 4),
            new Item(3, 1));

    static int[] geraIndividuo() {
        int[] individuo = new int[itens.size()];
        for (int i = 0; i < itens.size(); i++) {
            individuo[i] = rand.nextInt(2);
        }
        return individuo;
    }

    // fitness - calcula valor total do individuo
    static int avaliarIndividuo(int[] individuo) {
        int valorTotal = 0, pesoTotal = 0;
        for (int i = 0; i < itens.size(); i++) {
            if (individuo[i] == 1) {
                valorTotal += itens.get(i).valor;
                pesoTotal += itens.get(i).peso;
            }
        }
        return (pesoTotal <= pesoMax) ? valorTotal : 0;
    }

    // calcula peso total do individuo
    static int calcularPeso(int[] individuo) {
        int pesoTotal = 0;
        for (int i = 0; i < individuo.length; i++) {
            if (individuo[i] == 1) {
                pesoTotal += itens.get(i).peso;
            }
        }
        return pesoTotal;
    }

    // seleciona aleatoriamente um individuo
    static int[] selecao(List<int[]> populacao) {
        return populacao.get(rand.nextInt(populacao.size()));
    }

    // Crossover
    static int[][] combinarPais(int[] pai1, int[] pai2) {
        int tamanho = itens.size();
        int meio = tamanho / 2;

        int[] filho1 = new int[tamanho];
        int[] filho2 = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            if (i < meio) {
                filho1[i] = pai1[i];
                filho2[i] = pai2[i];
            } else {
                filho1[i] = pai2[i];
                filho2[i] = pai1[i];
            }
        }

        return new int[][] { filho1, filho2 };
    }

    // mutação que inverte os genes aleatoriamente
    static void mutacao(int[] individuo) {
        for (int i = 0; i < individuo.length; i++) {
            if (rand.nextDouble() < chanceMutacao) {
                individuo[i] = 1 - individuo[i];
            }
        }
    }

    // encontrando o melhor valor possivel
    static int encontrarValorMaximoPossivel() {
        int maxValor = 0;
        int n = itens.size();
        for (int i = 0; i < (1 << n); i++) {
            int valor = 0, peso = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    valor += itens.get(j).valor;
                    peso += itens.get(j).peso;
                }
            }
            if (peso <= pesoMax) {
                maxValor = Math.max(maxValor, valor);
            }
        }
        return maxValor;
    }

    // executa o algoritmo genético
    static int[] algoritmoGenetico() {
        int melhorValorPossivel = encontrarValorMaximoPossivel();
        System.out.println("Melhor valor possível: " + melhorValorPossivel);

        // inicia a população aleatoriamente
        List<int[]> populacao = new ArrayList<>();
        for (int i = 0; i < tamanhoPopulacao; i++) {
            populacao.add(geraIndividuo());
        }

        for (int i = 0; i < geracoes; i++) {
            List<int[]> novaPopulacao = new ArrayList<>();
            for (int j = 0; j < tamanhoPopulacao / 2; j++) {
                int[] pai1 = selecao(populacao);
                int[] pai2 = selecao(populacao);
                int[][] filhos = combinarPais(pai1, pai2);
                mutacao(filhos[0]);
                mutacao(filhos[1]);
                novaPopulacao.add(filhos[0]);
                novaPopulacao.add(filhos[1]);
            }
            populacao = novaPopulacao;
            populacao.sort(Comparator.comparingInt(App::avaliarIndividuo).reversed());

            int[] melhor = populacao.get(0);
            int valor = avaliarIndividuo(melhor);
            int peso = calcularPeso(melhor);

            System.out.println("Geração " + (i + 1) + ": " +
                    Arrays.toString(melhor) + " | Valor: " + valor + " | Peso: " + peso);

            if (valor == melhorValorPossivel) {
                System.out.println("Melhor solução atingida na geração " + (i + 1) + "!");
                return melhor;
            }
        }
        // retorna melhor indivíduo
        return populacao.get(0);
    }

    public static void main(String[] args) {
        int[] melhorSolucao = algoritmoGenetico();
        int valorTotal = avaliarIndividuo(melhorSolucao);
        int pesoTotal = calcularPeso(melhorSolucao);

        System.out.println("\nMelhor solução encontrada:");
        System.out.println("Indivíduo: " + Arrays.toString(melhorSolucao));
        System.out.println("Valor total: " + valorTotal);
        System.out.println("Peso total: " + pesoTotal);
    }
}