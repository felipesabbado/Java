import java.util.Random;
import java.util.Scanner;

public class JogoAdivinha {
    public static void main(String[] args) {
        int tentativas;
        int numAlvo = new Random().nextInt(100);
        Scanner leitura = new Scanner(System.in);

        for (tentativas = 5; tentativas > 0; tentativas--) {
            System.out.printf("Tente adivinhar qual é o número, de 0 a 100, em %d tentativas.\n", tentativas);
            int palpite = leitura.nextInt();

            if (palpite == numAlvo) {
                System.out.println("Parabéns, você acertou o número.");
                break;
            } else if (palpite > numAlvo) {
                System.out.println("Errado! Seu palpite é MAIOR que o número.");
            } else {
                System.out.println("Errado! Seu palpite é MENOR que o número.");
            }
        }

        if (tentativas == 0) {
            System.out.printf("Acabaram suas tentativas, o número correto era %d.", numAlvo);
        }
    }
}
