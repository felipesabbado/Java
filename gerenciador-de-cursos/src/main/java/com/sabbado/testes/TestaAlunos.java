package com.sabbado.testes;

import java.util.*;

public class TestaAlunos {
    public static void main(String[] args) {
        Collection<String> alunos = new HashSet<>();
        alunos.add("Rodrigo Turini");
        alunos.add("Alberto Souza");
        alunos.add("Nico Steppat");
        alunos.add("Sergio Lopes");
        alunos.add("Renan Saggio");
        alunos.add("Mauricio Aniche");
        alunos.add("Alberto Souza");

        System.out.println(alunos.size());

        alunos.forEach(System.out::println);

        System.out.println(alunos);

        boolean paulosEstaMatriculado = alunos.contains("Paulo Silveira");
        System.out.println(paulosEstaMatriculado);

        alunos.remove("Sergio Lopes");
        System.out.println(alunos);

        List<String> alunosEmLista = new ArrayList<>(alunos);
        Collections.sort(alunosEmLista);
        System.out.println(alunosEmLista);
    }
}
