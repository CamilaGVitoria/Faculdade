package Ex2;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();

        int vetor[] = new int[100000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100000);
        }

        int[] vetorBubble = vetor.clone();
        int[] vetorInsertion = vetor.clone();
        int[] vetorSelection = vetor.clone();
        int[] vetorShell = vetor.clone();
        int[] vetorMerge = vetor.clone();
        int[] vetorQuick = vetor.clone();

        long tempoInicial = 0;
        long tempoFinal = 0;

        tempoInicial = System.currentTimeMillis();
        bubbleSort(vetorBubble);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo BubbleSort: " + (tempoFinal - tempoInicial) + " ms");

        tempoInicial = System.currentTimeMillis();
        insertionSort(vetorInsertion);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo InsertionSort: " + (tempoFinal - tempoInicial) + " ms");

        tempoInicial = System.currentTimeMillis();
        selectionSort(vetorSelection);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo SelectionSort: " + (tempoFinal - tempoInicial) + " ms");

        tempoInicial = System.currentTimeMillis();
        shellSort(vetorShell);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo ShellSort: " + (tempoFinal - tempoInicial) + " ms");

        tempoInicial = System.currentTimeMillis();
        mergeSort(vetorMerge, 0, vetorMerge.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo MergeSort: " + (tempoFinal - tempoInicial) + " ms");

        tempoInicial = System.currentTimeMillis();
        quickSort(vetorQuick, 0, vetorQuick.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo QuickSort: " + (tempoFinal - tempoInicial) + " ms");

    }

    // BubleSort
    public static void bubbleSort(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            for (int j = 0; j < vetor.length - 1; j++) {

                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    // InsertionSort
    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {

            int elemento = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > elemento) {
                vetor[j + 1] = vetor[j];
                j--;
                vetor[j + 1] = elemento;
            }
        }
    }

    // SelectionSort
    public static void selectionSort(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {
            int pos_menor = i;

            for (int j = i + 1; j < vetor.length; j++)

                if (vetor[j] < vetor[pos_menor])
                    pos_menor = j;

            if (i != pos_menor) {
                int aux = vetor[i];
                vetor[i] = vetor[pos_menor];
                vetor[pos_menor] = aux;

            }
        }
    }

    // ShellSort
    public static void shellSort(int[] vetor) {
        int tamanho = vetor.length;
        int h = 1;

        while (h < tamanho) {
            h = 3 * h + 1;
        }

        while (h > 1) {
            h /= 3;

            for (int i = h; i < tamanho; i++) {
                int temp = vetor[i];
                int j = i - h;

                while (j >= 0 && temp < vetor[j]) {
                    vetor[j + h] = vetor[j];
                    j -= h;
                }
                vetor[j + h] = temp;

            }
        }
    }

    // MergeSort

    public static void mergeSort(int[] vetor, int esq, int dir) {
        if(esq >= dir) {
            return;
        } else {
            int meio = (esq + dir) / 2;

            mergeSort(vetor, esq, meio);
            mergeSort(vetor, meio + 1, dir);

            merge(vetor, esq, meio, dir);
        }
    }

    public static void merge(int[] vetor, int esq, int meio, int dir) {
        int[] helper = new int[vetor.length];

        for (int i = esq; i <= dir; i++) {
            helper[i] = vetor[i];
        }

        int i = esq;
        int j = meio + 1;
        int k = esq;

        while (i <= meio && j <= dir) {
            if (helper[i] <= helper[j]) {
                vetor[k] = helper[i];
                i++;
            } else {
                vetor[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            vetor[k] = helper[i];
            i++;
            k++;
        }
    }

    // QuickSort
    public static void quickSort(int[] vetor, int ini, int fim) {
        if (ini < fim) {
            int index_pivot = particionaLomuto(vetor, ini, fim);
            quickSort(vetor, ini, index_pivot - 1);
            quickSort(vetor, index_pivot + 1, fim);
        }
    }

    public static int particionaLomuto(int[] vetor, int ini, int fim) {
        int pivot = vetor[ini];
        int i = ini;

        for (int j = ini + 1; j <= fim; j++) {

            if (vetor[j] <= pivot) {
                i += 1;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        int temp = vetor[ini];
        vetor[ini] = vetor[i];
        vetor[i] = temp;

        return i;
    }
}
