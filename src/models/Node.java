package models;
import java.lang.Comparable;

public class Node<T extends Comparable<T>> {
    T dado;
    Node<T> esquerda;
    Node<T> direita;

    public Node(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    
}
