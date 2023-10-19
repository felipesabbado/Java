import br.com.alura.modelos.Compra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int continua = 1;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        List<Compra> compras = new ArrayList<>();

        System.out.println("Digite o limite do cartão: ");
        double limiteDoCartao = scanner.nextDouble();

        while (continua == 1) {
            System.out.println("Digite a descrição da compra: ");
            String descricao = scanner.next();

            System.out.println("Digite o valor da compra: ");
            double valor = scanner.nextDouble();

            if (valor > limiteDoCartao) {
                System.out.println("\nSaldo insuficiente!\n");
                continua = 0;
            } else {
                compras.add(new Compra(descricao, valor));
                limiteDoCartao -= valor;
                System.out.println("Digite 0 para sair ou 1 para continuar");
                continua = scanner.nextInt();
            }
        }

        System.out.println("******************************");
        System.out.println("COMPRAS REALIZADAS\n");

        compras.sort(Comparator.comparing(Compra::getValor));

        compras.forEach(System.out::println);

        System.out.printf("\nSaldo do cartão: R$%.2f\n", limiteDoCartao);
        System.out.println("******************************");
    }
}
