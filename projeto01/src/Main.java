public class Main {
    public static void main(String[] args) {
        int celsius = 33;
        double fahrenheit = (celsius * 1.8) + 32;

        String mensagem = "A temperatura de %d° Celsius em Fahrenheit é de %.1f°.";

        System.out.printf(mensagem, celsius, fahrenheit);
    }
}