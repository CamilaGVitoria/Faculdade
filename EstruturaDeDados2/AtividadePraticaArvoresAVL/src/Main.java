public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.inserir(50);
        tree.inserir(1);
        tree.inserir(64);
        tree.inserir(12);
        tree.inserir(18);
        tree.inserir(66);
        tree.inserir(38);
        tree.inserir(95);
        tree.inserir(58);
        tree.inserir(59);
        tree.inserir(70);
        tree.inserir(68);
        tree.inserir(39);
        tree.inserir(62);
        tree.inserir(7);
        tree.inserir(60);
        tree.inserir(43);
        tree.inserir(43);
        tree.inserir(16);
        tree.inserir(67);
        tree.inserir(34);
        tree.inserir(35);

        tree.printTree();

        System.out.println("\n");

        System.out.println("Removendo 50");
        tree.apagar(50);
        tree.printTree();
        System.out.println("50 Removido");

        System.out.println("\nQuantidade de Nós: " + tree.getQtdNos());

        System.out.println("\nRemovendo 95");
        tree.apagar(95);
        tree.printTree();
        System.out.println("95 Removido");

        System.out.println("\nQuantidade de Nós: " + tree.getQtdNos());

        System.out.println("\nRemovendo 70");
        tree.apagar(70);
        tree.printTree();
        System.out.println("70 Removido");

        System.out.println("\nQuantidade de Nós: " + tree.getQtdNos());

        System.out.println("\nRemovendo 35");
        tree.apagar(35);
        tree.printTree();
        System.out.println("35 Removido");

        System.out.println("\nQuantidade de Nós: " + tree.getQtdNos());

    }
}
