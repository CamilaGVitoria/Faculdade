package Ex3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        App pista = new App();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Listar o número de aviões aguardando na fila");
            System.out.println("2. Autorizar a decolagem do primeiro avião da fila");
            System.out.println("3. Adicionar um avião à fila de espera");
            System.out.println("4. Listar todos os aviões na fila de espera");
            System.out.println("5. Listar as características do primeiro avião da fila");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    pista.listarNumeroAviões();
                    break;
                case 2:
                    pista.autorizarDecolagem();
                    break;
                case 3:
                    System.out.print("Digite o nome do avião: ");
                    String nome = scan.nextLine();
                    System.out.print("Digite o ID do avião: ");
                    int id = scan.nextInt();
                    scan.nextLine(); // Consumir a nova linha
                    pista.adicionarAviao(new Aviao(nome, id));
                    break;
                case 4:
                    pista.listarTodosAviões();
                    break;
                case 5:
                    pista.listarPrimeiroAviao();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scan.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private Queue<Aviao> fila = new LinkedList<>();

    public void adicionarAviao(Aviao aviao) {
        fila.add(aviao);
        System.out.println("Avião " + aviao.getNome() + " adicionado à fila.");
    }

    public void autorizarDecolagem() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum avião na fila para decolagem.");
        } else {
            Aviao aviao = fila.poll();
            System.out.println("Decolagem autorizada para o: " + aviao);
        }
    }

    public void listarNumeroAviões() {
        System.out.println("Número de aviões na fila: " + fila.size());
    }

    public void listarTodosAviões() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Aviões na fila:");
            for (Aviao aviao : fila) {
                System.out.println(aviao);
            }
        }
    }

    public void listarPrimeiroAviao() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Primeiro avião da fila: " + fila.peek());
        }
    }
}
