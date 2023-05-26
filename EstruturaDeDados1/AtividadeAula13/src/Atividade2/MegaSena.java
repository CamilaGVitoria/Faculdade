package Atividade2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MegaSena {
    public static void main(String[] args) {
        int[] numerosSorteados = {1, 15, 16, 25, 32, 36};
        int posicao = -1;
        int contadorSequencia = 0;
        List<Integer> listaNumerosSorteados = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 51000000; i++) {
            int numero = random.nextInt(60000000) + 1; 
            listaNumerosSorteados.add(numero);
        }

        for (int i = 0; i < listaNumerosSorteados.size() - numerosSorteados.length + 1; i++) {
            if (listaNumerosSorteados.get(i) == numerosSorteados[0]) {
                boolean sequenciaEncontrada = true;
                for (int j = 1; j < numerosSorteados.length; j++) {
                    if (listaNumerosSorteados.get(i + j) != numerosSorteados[j]) {
                        sequenciaEncontrada = false;
                        break;
                    }
                }
                if (sequenciaEncontrada) {
                    posicao = i;
                    contadorSequencia++;
                }
            }
        }

        System.out.println("Sequência encontrada na ordem direta:");
        
        if (posicao != -1) {
            System.out.println("Posição: " + posicao);
            System.out.println("Quantidade de vezes que a sequência aparece: " + contadorSequencia);
        } else {
            System.out.println("Sequência não encontrada.");
        }

        Collections.reverse(listaNumerosSorteados);
        posicao = -1;
        contadorSequencia = 0;

        for (int i = 0; i < listaNumerosSorteados.size() - numerosSorteados.length + 1; i++) {
            if (listaNumerosSorteados.get(i) == numerosSorteados[0]) {
                boolean sequenciaEncontrada = true;
    
                for (int j = 1; j < numerosSorteados.length; j++) {
                    if (listaNumerosSorteados.get(i + j) != numerosSorteados[j]) {
                        sequenciaEncontrada = false;
                        break;
                    }
                }

                if (sequenciaEncontrada) {
                    posicao = i;
                    contadorSequencia++;
                }
            }
        }

        System.out.println("Sequência encontrada na ordem inversa:");
        
        if (posicao != -1) {
            System.out.println("Posição: " + posicao);
            System.out.println("Quantidade de vezes que a sequência aparece: " + contadorSequencia);
        } else {
            System.out.println("Sequência não encontrada.");
        }
    }
}