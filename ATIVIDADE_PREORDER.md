# Atividade: percurso pré-ordem em uma árvore binária de busca

## Objetivo

Utilizar a classe `BinarySearchTree` para construir uma árvore binária de busca e exibir seus elementos no percurso pré-ordem (*preOrder*).

## O que fazer

1. Na classe `App`, implemente o método `main`.
2. Crie uma árvore de inteiros usando `BinarySearchTree<Integer>`.
3. Insira, nesta ordem, os valores `50`, `30`, `70`, `20`, `40`, `60` e `80`.
4. Exiba uma identificação para o percurso e chame `preOrder()` para apresentar os valores.
5. Execute o programa e compare a saída com o resultado esperado.

## Resultado esperado

```text
Percurso preOrder:
50 30 20 40 70 60 80
```

No percurso pré-ordem, visita-se primeiro a raiz, depois a subárvore esquerda e, por fim, a subárvore direita. Por isso, a ordem dos valores exibidos deve corresponder à ordem acima.

## Desafio

Altere a ordem de inserção dos valores e observe como a forma da árvore e o resultado do percurso mudam. Teste também a árvore vazia e uma árvore com apenas um elemento.
