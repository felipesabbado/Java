package br.fsabbado.tabelafipe.principal;

import br.fsabbado.tabelafipe.models.Dados;
import br.fsabbado.tabelafipe.models.Modelos;
import br.fsabbado.tabelafipe.models.Veiculo;
import br.fsabbado.tabelafipe.service.ConsumoApi;
import br.fsabbado.tabelafipe.service.ConverteDados;
import br.fsabbado.tabelafipe.service.Menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();


    public void exibeMenu() {
        Menu.MenuInicial();
        var opcaoVeiculo = leitura.nextLine();
        String url = Menu.tipoVeiculo(opcaoVeiculo);
        var json = consumo.obterDados(url);

        List<Dados> listaMarcas = conversor.obterLista(json, Dados.class);
        listaMarcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(v -> System.out.println("Cód: " + v.codigo() + " Descrição: " + v.nome()));

        System.out.println("\nInforme o código da marca para consulta:");
        var codigoMarca = leitura.nextInt();
        leitura.nextLine();

        url += "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(url);
        var listaModelo = conversor.obterDados(json, Modelos.class);

        System.out.println("\nModelos dessa marca");
        listaModelo.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(m -> System.out.println("Cód: " + m.codigo() + " Descrição: " + m.nome()));

        System.out.println("\nDigite um trecho do nome do veículo para consulta:");
        var nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrados = listaModelo.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos Filtrados:");
        modelosFiltrados.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(m -> System.out.println("Cód: " + m.codigo() + " Descrição: " + m.nome()));

        System.out.println("\nDigite o código do modelo para buscar os valores de avaliação");
        var codigoModelo = leitura.nextLine();

        url += "/" + codigoModelo + "/anos";
        json = consumo.obterDados(url);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (Dados ano : anos) {
            var urlAnos = url + "/" + ano.codigo();
            json = consumo.obterDados(urlAnos);
            veiculos.add(conversor.obterDados(json, Veiculo.class));
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano:");
        veiculos.forEach(v -> System.out.println(v.modelo() + " " + v.ano() + " " + v.valor() + " " + v.tipoCombustivel()));
    }
}
