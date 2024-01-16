package com.sabbado.models;

import java.util.Objects;

public class Aluno {

    private String nome;
    private int numeroMatricula;

    public Aluno() {
    }

    public Aluno(String nome, int numeroMatricula) {
        if (nome == null) {
            throw new NullPointerException("Nome não pode ser null");
        }
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return getNumeroMatricula() == aluno.getNumeroMatricula() && Objects.equals(getNome(), aluno.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numeroMatricula);
    }

    @Override
    public String toString() {
        return "[Aluno: " + nome +
               " - matricula: " + numeroMatricula + "]";
    }
}
