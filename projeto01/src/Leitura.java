import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = leitura.nextLine();

        System.out.println("Digite sua avaliação:");
        double rate = leitura.nextDouble();

        System.out.printf("Olá, %s! Sua avaliação é %.2f", nome, rate);
    }
}
