import java.util.*;

class Item {
    int value, weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class App {
    static final int MAX_WEIGHT = 15;
    static final int POPULATION_SIZE = 10;
    static final double MUTATION_RATE = 0.1;
    static final int GENERATIONS = 50;
    static final Random rand = new Random();

    static List<Item> items = Arrays.asList(
            new Item(10, 2), new Item(5, 3), new Item(15, 5),
            new Item(7, 7), new Item(6, 1), new Item(18, 4),
            new Item(3, 1));

    static int[] generateIndividual() {
        int[] individual = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            individual[i] = rand.nextInt(2);
        }
        return individual;
    }

    static int fitness(int[] individual) {
        int totalValue = 0, totalWeight = 0;
        for (int i = 0; i < items.size(); i++) {
            if (individual[i] == 1) {
                totalValue += items.get(i).value;
                totalWeight += items.get(i).weight;
            }
        }
        return (totalWeight <= MAX_WEIGHT) ? totalValue : 0;
    }

    static int[] selection(List<int[]> population) {
        return population.get(rand.nextInt(population.size()));
    }

    static int[][] crossover(int[] parent1, int[] parent2) {
        int point = rand.nextInt(items.size());
        int[] child1 = Arrays.copyOf(parent1, items.size());
        int[] child2 = Arrays.copyOf(parent2, items.size());

        for (int i = point; i < items.size(); i++) {
            child1[i] = parent2[i];
            child2[i] = parent1[i];
        }
        return new int[][] { child1, child2 };
    }

    static void mutate(int[] individual) {
        for (int i = 0; i < individual.length; i++) {
            if (rand.nextDouble() < MUTATION_RATE) {
                individual[i] = 1 - individual[i];
            }
        }
    }

    static int[] geneticAlgorithm() {
        List<int[]> population = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            population.add(generateIndividual());
        }

        for (int gen = 0; gen < GENERATIONS; gen++) {
            List<int[]> newPopulation = new ArrayList<>();
            for (int i = 0; i < POPULATION_SIZE / 2; i++) {
                int[] parent1 = selection(population);
                int[] parent2 = selection(population);
                int[][] children = crossover(parent1, parent2);
                mutate(children[0]);
                mutate(children[1]);
                newPopulation.add(children[0]);
                newPopulation.add(children[1]);
            }
            population = newPopulation;
            population.sort(Comparator.comparingInt(App::fitness).reversed());
        }
        return population.get(0);
    }

    public static void main(String[] args) {
        int[] bestSolution = geneticAlgorithm();
        int totalValue = fitness(bestSolution);
        int totalWeight = Arrays.stream(bestSolution)
                .map(i -> i == 1 ? items.get(Arrays.asList(bestSolution).indexOf(i)).weight : 0).sum();

        System.out.println("Melhor solução encontrada: " + Arrays.toString(bestSolution));
        System.out.println("Valor total: " + totalValue);
        System.out.println("Peso total: " + totalWeight);
    }
}
