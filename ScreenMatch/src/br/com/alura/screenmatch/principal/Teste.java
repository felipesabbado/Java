package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;

public class Teste {
    public static void main(String[] args) {
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        buscaPorArtista.add("Ana");
        buscaPorArtista.add("Fernanda");
        buscaPorArtista.add("Felipe");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);

        System.out.println(buscaPorArtista);
    }
}
