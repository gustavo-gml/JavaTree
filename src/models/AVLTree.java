package models;

import java.lang.Comparable;

public class AVLTree<T extends Comparable<T>> {
    private Node<T> raiz;

    public AVLTree() {
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

        raiz.fb = altura(raiz.direita) - altura(raiz.esquerda);
        System.out.println("Altura do no " + raiz.dado + ": " + altura(raiz));

        switch (raiz.fb) {
            case -2:
                if (raiz.esquerda.fb <= 0) // rotacao simples a direita
                    raiz = rotacaoDir(raiz);
                else { // rotacao dupla a direita
                    raiz.esquerda = rotacaoEsq(raiz.esquerda);
                    raiz = rotacaoDir(raiz);
                }
                break;

            case 2:
                if (raiz.direita.fb >= 0) // rotacao simples a esquerda
                    raiz = rotacaoEsq(raiz);
                else { // rotacao dupla a esquerda
                    raiz.direita = rotacaoDir(raiz.direita);
                    raiz = rotacaoEsq(raiz);
                }

                break;
        }

        return raiz; // retorna a raiz atualizada
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

    // Remove o nó raiz passado por parâmetro e retorna a nova raiz da subárvore
    private Node<T> removeNode(Node<T> raiz) {
        Node<T> nova, pai;
        // Caso 1 e Caso 2 (nó sem filho direito: retorna o filho esquerdo ou null)
        if (raiz.direita == null) {
            nova = raiz.esquerda;
            return nova;
        }
        // Caso 3: percorrer até achar o menor elemento da subárvore à direita
        pai = raiz;
        nova = raiz.direita;
        while (nova.esquerda != null) {
            pai = nova;
            nova = nova.esquerda;
        } // fim while

        // Reorganizar os ponteiros
        if (pai != raiz) {
            pai.esquerda = nova.direita;
            nova.direita = raiz.direita;
        }
        nova.esquerda = raiz.esquerda;
        System.out.println("Retornando nova raiz: " + nova.dado);
        return nova;
    }

    public void remove(T dadoRemover) {
        this.raiz = remove(this.raiz, dadoRemover);
    }

    private Node<T> remove(Node<T> raiz, T dadoRemover) {
        if (raiz == null) {
            System.out.println("Não encontrado - :(");
            return null;
        }
        if (raiz.dado.equals(dadoRemover)) {
            System.out.println("Encontrado - removendo");
            return removeNode(raiz);
        }
        if (dadoRemover.compareTo(raiz.dado) < 0)
            raiz.esquerda = remove(raiz.esquerda, dadoRemover);
        else
            raiz.direita = remove(raiz.direita, dadoRemover);

        // Atualizar o fb e aplicar rotações após a remoção
        raiz.fb = altura(raiz.direita) - altura(raiz.esquerda);
        switch (raiz.fb) {
            case 2:
                if (raiz.direita.fb >= 0) // rotacao simples a esquerda
                    raiz = rotacaoEsq(raiz);
                else { // rotacao dupla a esquerda
                    raiz.direita = rotacaoDir(raiz.direita);
                    raiz = rotacaoEsq(raiz);
                }
                break;
            case -2:
                if (raiz.esquerda.fb <= 0) // rotacao simples a direita
                    raiz = rotacaoDir(raiz);
                else { // rotacao dupla a direita
                    raiz.esquerda = rotacaoEsq(raiz.esquerda);
                    raiz = rotacaoDir(raiz);
                }
                break;
        }

        return raiz;
    } // fim buscaRemove
    

    public int altura() {
        return altura(this.raiz);
    }

    public int altura(Node<T> raiz) {
        int altEsq, altDir;

        if (raiz == null) {
            return -1;
        }

        altEsq = altura(raiz.esquerda);
        altDir = altura(raiz.direita);

        if (altDir > altEsq)
            return altDir + 1;
        else
            return altEsq + 1;
    }

    // ------------------- Rotacao Simples a Direita -------------------
    public Node<T> rotacaoDir(Node<T> raiz) {
        Node<T> nova = raiz.esquerda;
        raiz.esquerda = nova.direita;
        nova.direita = raiz;
        // atualizar fator de balanceamento
        raiz.fb = altura(raiz.direita) - altura(raiz.esquerda);
        nova.fb = altura(nova.direita) - altura(nova.esquerda);
        System.out.println("Rotacao Direita -->");
        return nova;
    }

    // ------------------- Rotacao Simples a Esquerda ------------------
    public Node<T> rotacaoEsq(Node<T> raiz) {
        Node<T> nova = raiz.direita;
        raiz.direita = nova.esquerda;
        nova.esquerda = raiz;
        // atualizar os fb
        raiz.fb = altura(raiz.direita) - altura(raiz.esquerda);
        nova.fb = altura(nova.direita) - altura(nova.esquerda);
        System.out.println("Rotacao Esquerda -->");
        return nova;
    }

    private void preOrder(Node<T> raiz) {
        if (raiz == null) {
            return;
        }
        System.out.print(raiz.dado + " (fb:" + raiz.fb + ") ");
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

    public void preOrder() {
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
