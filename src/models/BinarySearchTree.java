package models;
import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> raiz;

    public BinarySearchTree(){
        this.raiz = null;
    }

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

   
    public void add(T dado) {
        Node<T> novoNo = new Node<>(dado);
        this.raiz = add(raiz, novoNo);
    }

    public T buscar(T dadoBusca) {
        return (T) buscar(this.raiz, dadoBusca);
    }

    private T buscar(Node<T> raiz, T dadoBusca) {
        if (raiz == null)
            return null; // Dado não encontrado na árvore

        if (raiz.dado.equals(dadoBusca))
            return raiz.dado; // Dado encontrado

        if (dadoBusca.compareTo(raiz.dado) < 0)
            return buscar(raiz.esquerda, dadoBusca);
        else
            return buscar(raiz.direita, dadoBusca);
    }
    

    private void preOrder(Node <T> raiz) {
        if (raiz == null) {
            return;
        }
        System.out.print(raiz.dado + " - ");
        preOrder(raiz.esquerda);
        preOrder(raiz.direita);
        
    }

    private void inOrder(Node<T> raiz) {
        if (raiz == null) {
            return;
        }
        inOrder(raiz.esquerda);
        System.out.print(raiz.dado + " ");
        inOrder(raiz.direita);
    }

     private void postOrder(Node<T> raiz) {
        if (raiz == null) {
            return;
        }
        postOrder(raiz.esquerda);
        postOrder(raiz.direita);
        System.out.print(raiz.dado + " ");
    }

    public void preOrder(){
        preOrder(this.raiz);
    }

    public void inOrder() {
        inOrder(this.raiz);
        System.out.println();
    }

    public void postOrder() {
        postOrder(this.raiz);
        System.out.println();
    }


    


    
}
