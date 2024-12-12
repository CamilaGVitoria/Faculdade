public class MainSemRecursivo {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.inserirSemRecursivo(50);
        tree.inserirSemRecursivo(30);
        tree.inserirSemRecursivo(70);
        tree.inserirSemRecursivo(20);
        tree.inserirSemRecursivo(40);
        tree.inserirSemRecursivo(60);
        tree.inserirSemRecursivo(80);
        tree.inserirSemRecursivo(10);
        tree.inserirSemRecursivo(25);
        tree.inserirSemRecursivo(35);

        tree.printTree();
    }   
}
