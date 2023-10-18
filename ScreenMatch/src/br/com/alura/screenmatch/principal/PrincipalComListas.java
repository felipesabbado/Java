package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme filme01 = new Filme("Star Wars IV",
                2006);
        Filme filme02 = new Filme("Avatar",
                2009);
        Filme filme03 = new Filme("Dogville",
                2003);
        Filme filme04 = new Filme("O poderoso chefão",
                1970);
        Serie lost = new Serie("Lost", 2000);

        filme01.avalia(9);
        filme02.avalia(6);
        filme03.avalia(10);
        lost.avalia(7);

        List<Titulo> titulos = new LinkedList<>();
        titulos.add(filme01);
        titulos.add(filme02);
        titulos.add(filme03);
        titulos.add(filme04);
        titulos.add(lost);

        /*titulos.forEach(item
        -> System.out.println(item.getNome()));
        titulos.forEach(System.out::println);*/

        for (Titulo item: titulos) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme) {
                System.out.println("Classificação "
                        + filme.getClassificacao());
            }
        }

        Collections.sort(titulos);
        System.out.println(titulos);

        titulos.sort(
                Comparator.comparing(Titulo::getAnoDeLancamento)
        );
        System.out.println(titulos);
    }
}
