package Ex5;
import java.util.Scanner;

public class Ex5 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lista lista = new Lista();
        
        System.out.println("Digite 5 elementos para a lista:");
        for (int i = 0; i < 5; i++) {
            int valor = scan.nextInt();
            lista.insert(valor);
        }
        
        lista.print();

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Verificar se a lista é vazia");
            System.out.println("2. Inserir um dado elemento");
            System.out.println("3. Remover um dado elemento");
            System.out.println("4. Tamanho da lista");
            System.out.println("5. Busca de um elemento");
            System.out.println("6. Eliminar todas as ocorrências de um elemento");
            System.out.println("7. Eliminar um elemento por posição");
            System.out.println("8. Inserir um valor à direita de um elemento");
            System.out.println("9. Inserir um valor à esquerda de um elemento");
            System.out.println("10. Média dos elementos");
            System.out.println("11. Verificar se duas listas são iguais");
            System.out.println("12. Sair");
            int opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Lista vazia? " + lista.isEmpty());
                    break;
                case 2:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scan.nextInt();
                    lista.insert(valorInserir);
                    lista.print();
                    break;
                case 3:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scan.nextInt();
                    lista.remove(valorRemover);
                    lista.print();
                    break;
                case 4:
                    System.out.println("Tamanho da lista: " + lista.getSize());
                    break;
                case 5:
                    System.out.print("Digite o valor a ser buscado: ");
                    int valorBusca = scan.nextInt();
                    System.out.println("Elemento " + valorBusca + " está na lista? " + lista.busca(valorBusca));
                    break;
                case 6:
                    System.out.print("Digite o valor a ser eliminado: ");
                    int valorEliminar = scan.nextInt();
                    lista.elimina(valorEliminar);
                    lista.print();
                    break;
                case 7:
                    System.out.print("Digite a posição do elemento a ser eliminado: ");
                    int posicaoEliminar = scan.nextInt();
                    try {
                        lista.eliminaPosicao(posicaoEliminar);
                        lista.print();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.print("Digite a posição à direita da qual o valor será inserido: ");
                    int posicaoDireita = scan.nextInt();
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorDireita = scan.nextInt();
                    try {
                        lista.insereDireita(posicaoDireita, valorDireita);
                        lista.print();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.print("Digite a posição à esquerda da qual o valor será inserido: ");
                    int posicaoEsquerda = scan.nextInt();
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorEsquerda = scan.nextInt();
                    try {
                        lista.insereEsquerda(posicaoEsquerda, valorEsquerda);
                        lista.print();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("Média dos elementos: " + lista.media());
                    break;
                case 11:
                    Lista outraLista = new Lista();
                    System.out.println("Digite 5 elementos para a outra lista:");
                    for (int i = 0; i < 5; i++) {
                        int valor = scan.nextInt();
                        outraLista.insert(valor);
                    }
                    System.out.println("Listas são iguais? " + lista.iguais(outraLista));
                    break;
                case 12:
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}