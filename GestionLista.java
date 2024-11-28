import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionLista {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Lista de elementos:");
        for (String item : lista) {
            System.out.println(item);
        }

        System.out.println("\nIntroduce el índice del elemento que deseas ver:");
        int indice = scanner.nextInt();

        try {
            String elemento = lista.get(indice);
            System.out.println("El elemento en el índice " + indice + " es: " + elemento);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: El índice " + indice + " está fuera de los límites de la lista.");
        }

        scanner.close();
    }
}
