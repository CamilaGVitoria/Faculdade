package Atividade1;

import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] numeros = numerosAleatorios(1000, -9999, 9999);
        int[] lista = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            insereNumero(lista, i, numeros[i]);
            imprimeListaCrescente(lista, i);
        }

        System.out.println("Lista em ordem crescente:");
        imprimeListaCrescente(lista, numeros.length);

        System.out.println("Lista em ordem decrescente:");
        imprimeListaDescrescente(lista, numeros.length);

        removePrimos(lista, numeros.length);

        System.out.println("Lista sem números primos em ordem crescente:");
        imprimeListaCrescente(lista, numeros.length);
    }
    
    private static int[] numerosAleatorios(int count, int min, int max) {
        int[] numeros = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numeros[i] = random.nextInt(max - min + 1) + min;
        }

        return numeros;
    }

    private static void insereNumero(int[] arr, int size, int num) {
        int i = size;

        while (i > 0 && arr[i - 1] > num) {
            arr[i] = arr[i - 1];
            i--;
        }

        arr[i] = num;
    }

    private static void imprimeListaCrescente(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void imprimeListaDescrescente(int[] arr, int size) {
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static boolean primo(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void removePrimos(int[] arr, int size) {
        int primeiroItemRemovido = size - 1;
        int[] novoArray = Arrays.copyOf(arr, primeiroItemRemovido + 1);

        for (int i = 0; i < size; i++) {
            if (primo(arr[i])) {
                arr[i] = Integer.MAX_VALUE; 
            }
        }

        Arrays.sort(arr); 

        while (primeiroItemRemovido >= 0 && arr[primeiroItemRemovido] == Integer.MAX_VALUE) {
            primeiroItemRemovido--;
        }

        System.arraycopy(arr, primeiroItemRemovido + 1, novoArray, 0, size - primeiroItemRemovido - 1);
        Arrays.fill(arr, novoArray.length, size, 0);

        System.arraycopy(novoArray, 0, arr, 0, novoArray.length);
    }
}