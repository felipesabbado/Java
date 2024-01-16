package com.sabbado.testes;

import com.sabbado.models.Aluno;
import com.sabbado.models.Aula;
import com.sabbado.models.Curso;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {
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

        System.out.println("Todos os alunos matriculados: ");
        javaColecoes.getAlunos().forEach(System.out::println);

        System.out.println("O aluno " + a1.getNome() + " está matriculado?");
        System.out.println(javaColecoes.estaMatriculado(a1));

        Aluno rodrigo = new Aluno("Rodrigo", 34672);
        System.out.println("E esse Rodrigo, está matriculado?");
        System.out.println(javaColecoes.estaMatriculado(rodrigo));

        System.out.println("O a1 é equals ao Rodrigo?");
        System.out.println(a1.equals(rodrigo));

        System.out.println("Hash code do a1: " + a1.hashCode());
        System.out.println("Hash code do rodrigo: " + rodrigo.hashCode());
        System.out.println("Os hash codes são iguals? " + (a1.hashCode() == rodrigo.hashCode()));

        // Iteração de um anterior ao Java 5 e ao enhanced for.
        System.out.println("Todos os alunos matriculados:");
        Set<Aluno> alunos = javaColecoes.getAlunos();
        Iterator<Aluno> iterador = alunos.iterator();
        while (iterador.hasNext()) {
            Aluno proximo = iterador.next();
            System.out.println(proximo);
        }
        /* Enhanced for
        for (Aluno proximo : alunos) {
            System.out.println(proximo);
        }*/
    }
}
