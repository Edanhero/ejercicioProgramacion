import java.util.Scanner;

public class DivisionPorCero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el primer número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Introduce el segundo número:");
        double numero2 = scanner.nextDouble();

        try {
            if (numero2 == 0) {
                throw new ArithmeticException("Error: No se puede dividir por cero.");
            }
            double resultado = numero1 / numero2;
            System.out.println("El resultado de la división es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
