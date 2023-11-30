public class Calculos {
    public static int fibonacciRecursivo(int quantidade) {
        if (quantidade < 2) {
            return quantidade;
        } else {
            return fibonacciRecursivo(quantidade - 1) + fibonacciRecursivo(quantidade - 2);
        }
    }

    public static int fibonacciIterativo(int quantidade) {
        int j = 1;
        int i = 0;

        for (int k = 0; k < quantidade; k++) {
            int t = i + j;
            i = j;
            j = t;
        }

        return i;
    }

    public static void celsiusParaFahrenheit(double celsius) {
        double fahrenheit = (celsius * 1.8) + 32;

        String mensagem = "A temperatura de %.1f° Celsius em Fahrenheit é de %.1f°.\n";

        System.out.printf(mensagem, celsius, fahrenheit);
    }
}
