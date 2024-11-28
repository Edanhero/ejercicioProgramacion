public class encontrarMayor {
    public static void main(String[] args) {
        int mayor = encontrarMayor(10, 20, 5);
        System.out.println("El número mayor es: " + mayor);
    }

    public static int encontrarMayor(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}