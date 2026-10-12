import models.BinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree<Integer>();
        BinarySearchTree emptyTree = new BinarySearchTree<Integer>();
        BinarySearchTree unitaryTree = new BinarySearchTree<Integer>();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        unitaryTree.add(90);

        

        System.out.println("Percurso padrão preOrder: ");
        tree.preOrder();

        System.out.println("\n\nPercurso vazio preOrder: ");
        emptyTree.preOrder();

        System.out.println("\n\nPercurso unitário preOrder: ");
        unitaryTree.preOrder();
    }
}
