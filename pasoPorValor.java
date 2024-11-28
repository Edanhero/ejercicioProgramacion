public class pasoPorValor {
    public static void main(String[] args) {
        int valor = 10;
        cambiarValor(valor);
        System.out.println("Valor después de cambiarValor: " + valor);  // Debería imprimir 10
    }

    public static void cambiarValor(int valor) {
        valor = 20;
    }
}

