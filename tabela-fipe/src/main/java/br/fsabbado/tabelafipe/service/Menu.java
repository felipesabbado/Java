package br.fsabbado.tabelafipe.service;

public class Menu {
    private static final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public static void MenuInicial() {
        System.out.println("*** OPÇÕES ***");
        System.out.println("Carro\nMoto\nCaminhão");
        System.out.println("Digite uma das opções para consultar valores:");
    }

    public static String tipoVeiculo(String tipo) {
        if (tipo.toLowerCase().contains("car")) {
            return ENDERECO + "carros/marcas";
        } else if (tipo.toLowerCase().contains("mot")) {
            return ENDERECO + "motos/marcas";
        } else {
            return ENDERECO + "caminhoes/marcas";
        }
    }
}
