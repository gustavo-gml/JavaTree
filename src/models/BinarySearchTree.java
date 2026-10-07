package models;
import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> raiz;

    private Node<T> add(Node<T> raiz, Node<T> novoNo) {
        if (raiz == null) {
            raiz = novoNo;
            return raiz;
        } else if (novoNo.dado.compareTo(raiz.dado) < 0)
            raiz.esquerda = add(raiz.esquerda, novoNo);

        else
            raiz.direita = add(raiz.direita, novoNo);

        return raiz;
    }// fim funcao inserir

    public Node<T> add(T dado) {
        Node<T> node = new Node(dado);
        raiz = add(raiz, node);
        return raiz;
    }

    private void preOrder(Node <T> raiz){
        System.out.println(raiz.dado + " - ");
        preOrder(raiz.esquerda);
        preOrder(raiz.direita);
        
    }

    public void preOrder(){
        preOrder(this.raiz);
    }
}
