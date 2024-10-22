package Ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listaOrdenada = new ArrayList<>();

        System.out.print("Digite o número de elementos que deseja inserir: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            int valor = scanner.nextInt();
            insertionSort(listaOrdenada, valor);

            System.out.println("Lista após a inserção do " + (i + 1) + "º número:"  + listaOrdenada);
        }

        scanner.close();
    }

    public static void insertionSort(ArrayList<Integer> lista, int valor) {
        int i = 0;

        while (i < lista.size() && lista.get(i) < valor) {
            i++;
        }

        lista.add(i, valor);
    }
}
