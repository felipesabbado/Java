import java.util.Scanner;

public class ControleBancario {
    public static void main(String[] args) {
        String nomeCliente = "Felipe Campelo Sabbado";
        String tipoDeConta = "Corrente";
        double saldo = 2500.00;
        int opcao = 0;
        Scanner leitura = new Scanner(System.in);

        String msgInicial = """
                **************************
                Dados iniciais do cliente
                
                Nome: %s
                Tipo de conta: %s
                Saldo inicial: R$ %.2f
                **************************
                """.formatted(nomeCliente, tipoDeConta, saldo);

        String menu = """
                ** Digite a opção desejada **
                1 - Consultar saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                """;

        System.out.println(msgInicial);

        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual R$ %.2f\n", saldo);
                    break;
                case 2:
                    System.out.println("Informe o valor a receber:");
                    saldo += leitura.nextDouble();
                    System.out.printf("Saldo atualizado R$ %.2f\n", saldo);
                    break;
                case 3:
                    System.out.println("Informe o valor que deseja transferir:");
                    double valorDaTransferencia = leitura.nextDouble();

                    if (valorDaTransferencia > saldo) {
                        System.out.println("Não há saldo suficiente para fazer esta transferência.");
                    } else {
                        saldo -= valorDaTransferencia;
                    }

                    System.out.printf("Saldo atualizado R$ %.2f\n", saldo);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente.");
            }

        }
    }
}
