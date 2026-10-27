package models;

import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private Integer matricula;

    public Aluno() {
        this.nome = null;
        this.matricula = null;
    }

    public Aluno(int matricula) {
        this.nome = null;
        this.matricula = matricula;
    }
    
    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    

    @Override 
    public boolean equals(Object comp){
        if (this == comp) 
            return true;
        
        if (comp instanceof Aluno aluno){
            return Objects.equals(matricula, aluno.getMatricula());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    
    @Override 
    public int compareTo(Aluno a1){
        return this.matricula.compareTo(a1.getMatricula());
    }

    @Override
    public String toString() {
        return  "Matrícula: " + this.matricula + " - " + "Nome: " + this.nome;
    }

    
}
