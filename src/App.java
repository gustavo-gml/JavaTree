import java.util.*;

import models.Aluno;
import models.BinarySearchTree;

public class App {

    static int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Arvore Binária de Busca");
        System.out.println("1. Inserir elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Buscar elemento");
        System.out.println("4. Exibir árvore");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return sc.nextInt();
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Aluno> arvore = new BinarySearchTree<>(); // Instanciar a arvore
        int opcao=0;
        do {
            System.out.println("----------------------------------");
            opcao = menu();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a matricula ");
                    int matricula = Integer.parseInt(sc.nextLine());

                    System.out.print("Digite o nome do aluno: ");
                    String nome = sc.nextLine();

                    arvore.add(new Aluno(nome, matricula)); // inserir
                    System.out.println("Elemento inserido com sucesso!");

                    break;
                case 2:
                    System.out.print("Digite o elemento a ser removido: ");
                    int elementoRemover = Integer.parseInt(sc.nextLine());
                    // Implementar a remoção do elemento na árvore
                    System.out.println("Elemento removido com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite a matrícula do aluno a ser buscado: ");
                    int elementoBuscar = Integer.parseInt(sc.nextLine());
                    Aluno alunoBusca = new Aluno(elementoBuscar);

                    Aluno resultado = arvore.buscar(alunoBusca);
                    
                    if (resultado != null) 
                        System.out.println("Aluno [" + resultado + "] encontrado!");
                    else
                        System.out.println("Aluno não encontrado na árvore!");
                        
                    break;

                case 4:
                    System.out.println("Exibindo a árvore em pré-ordem:");
                    arvore.preOrder();// percurso 

                    System.out.println("\nExibindo a árvore ordenada:");
                    arvore.inOrder();

                    System.out.println("\nExibindo a árvore pós-ordem:");
                    arvore.postOrder();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}

