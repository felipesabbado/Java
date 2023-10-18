package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme filme01 = new Filme("Star Wars: Ameaça Fantasma",
                2006);
        filme01.setDuracaoEmMinutos(180);

        Filme filme02 = new Filme("Avatar",
                2023);
        filme02.setDuracaoEmMinutos(200);

        Filme filme03 = new Filme("Dogville",
                2003);
        filme03.setDuracaoEmMinutos(200);
        filme03.avalia(10);

        ArrayList<Filme> filmes = new ArrayList<>();
        filmes.add(filme01);
        filmes.add(filme02);
        filmes.add(filme03);
        System.out.println("Tamanho da lista: "
                + filmes.size());
        System.out.println("Primeiro filme "
                + filmes.get(0).getNome());
        System.out.println(filmes);
        System.out.println("toString do filme "
                + filmes.get(0).toString());


        filme01.exibeFichaTecnica();
        filme01.avalia(8);
        filme01.avalia(10);
        filme01.avalia(7);

        System.out.println("Média " + filme01.retornaMedia());
        System.out.println("Total de Avaliações "
                + filme01.getTotalDeAvaliacoes());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(12);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração total da Série: "
                + lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme01);
        calculadora.inclui(filme02);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        Episodio ep01 = new Episodio();
        ep01.setNumero(1);
        ep01.setSerie(lost);
        ep01.setTotalVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme01);
        filtro.filtra(filme02);
        filtro.filtra(ep01);

    }
}
