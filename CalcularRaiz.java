import java.util.Scanner;

class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String mensaje) {
        super(mensaje);
    }
}

public class CalcularRaiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un número para calcular su raíz cuadrada:");
        double numero = scanner.nextDouble();

        try {
            double raiz = calcularRaizCuadrada(numero);
            System.out.println("La raíz cuadrada de " + numero + " es: " + raiz);
        } catch (NumeroNegativoException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static double calcularRaizCuadrada(double numero) throws NumeroNegativoException {
        if (numero < 0) {
            throw new NumeroNegativoException("Error: No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(numero);
    }
}
