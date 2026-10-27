# Atividade Prática: Árvore Binária de Busca com Objetos (`Aluno`)

## Objetivo
Adaptar a implementação genérica de **Árvore Binária de Busca** (`BinarySearchTree<T>`) para armazenar, buscar e percorrer objetos da classe `Aluno`, utilizando o número de matrícula como chave de comparação.

---

## Requisitos da Atividade

### 1. Criar a classe `Aluno`
Crie o arquivo `src/Aluno.java` atendendo às seguintes especificações:

- **Atributos**:
  - `nome` (`String`)
  - `matricula` (`int`)
- **Construtor(es)** e métodos **Getters/Setters** adequados.
- **Interface `Comparable<Aluno>`**:
  - A classe deve assinar `implements Comparable<Aluno>`.
  - Implemente o método `compareTo(Aluno outro)` realizando a comparação **pela `matricula`** (ex.: `Integer.compare(this.matricula, outro.matricula)`).
- **Sobrescrita do método `equals(Object obj)`**:
  - Dois objetos `Aluno` devem ser considerados iguais quando possuírem a mesma **`matricula`** (utilizado pelo método `buscar` da árvore).
- **Sobrescrita do método `toString()`**:
  - Retorne uma representação textual legível do aluno contendo matrícula e nome (ex.: `"[Matrícula: 101 - Nome: Maria]"`).

---

### 2. Adaptar a classe principal (`App.java`)
Altere o método `main` em `src/App.java` para manipular objetos `Aluno` em vez de `Integer` (ou outros cadastros):

1. **Instanciação da Árvore**:
   - Altere o tipo genérico da árvore para `BinarySearchTree<Aluno>`.
2. **Opção 1 — Inserir Aluno**:
   - Leia pelo `Scanner` a **matrícula** (`int`) e o **nome** (`String`) do aluno.
   - Instancie um novo objeto `Aluno` com os dados informados e insira-o na árvore com `arvore.add(aluno)`.
3. **Opção 3 — Buscar Aluno**:
   - Solicite ao usuário a **matrícula** do aluno que deseja buscar.
   - Instancie um objeto `Aluno` de busca contendo a matrícula informada e chame `arvore.buscar(...)`.
   - Caso o aluno seja encontrado, exiba seus dados completos retornados pela árvore; caso contrário, informe que não foi encontrado.
4. **Opção 4 — Exibir Árvore**:
   - Exiba os alunos nos percursos em **pré-ordem** (`preOrder()`), **em ordem** (`inOrder()`) e complete a chamada do percurso em **pós-ordem** (`postOrder()`).

---

## Critérios de Verificação
- [ ] A classe `Aluno` implementa `Comparable<Aluno>` comparando pela `matricula`.
- [ ] O método `equals` de `Aluno` compara corretamente pela `matricula`.
- [ ] O método `toString` de `Aluno` formata os dados de forma clara nos percursos.
- [ ] O percurso `inOrder()` exibe os alunos ordenados de forma crescente pela matrícula.
- [ ] A busca na árvore localiza um aluno cadastrado informando apenas a sua matrícula.

