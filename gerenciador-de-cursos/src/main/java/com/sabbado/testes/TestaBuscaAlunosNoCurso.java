package com.sabbado.testes;

import com.sabbado.models.Aluno;
import com.sabbado.models.Aula;
import com.sabbado.models.Curso;

public class TestaBuscaAlunosNoCurso {
    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        Aluno a1 = new Aluno("Rodrigo", 34672);
        Aluno a2 = new Aluno("Guilherme", 5617);
        Aluno a3 = new Aluno("Mauricio", 17645);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        System.out.println("Quem é o aluno com matrícula 5617?");
        Aluno aluno = javaColecoes.buscaPorNumeroMatricula(5617);
        System.out.println(aluno);
    }
}
