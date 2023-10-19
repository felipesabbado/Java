import br.com.alura.modelos.CartaoDeCredito;
import br.com.alura.modelos.Compra;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");

        System.out.println("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int continua = 1;
        while (continua == 1) {
            System.out.println("Digite a descrição da compra: ");
            String descricao = scanner.next();

            System.out.println("Digite o valor da compra: ");
            double valor = scanner.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair " +
                        "ou 1 para continuar");
                continua = scanner.nextInt();
            } else {
                System.out.println("\nSaldo insuficiente!\n");
                continua = 0;
            }
        }

        System.out.println("******************************");
        System.out.println("COMPRAS REALIZADAS\n");

        cartao.ordenaCompras();

        cartao.getCompras().forEach(System.out::println);

        System.out.printf("\nSaldo do cartão: R$%.2f\n",
                cartao.getSaldo());
        System.out.println("******************************");
    }
}
