import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notas {
    private static final String ARCHIVO_NOTAS = "notas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> notas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_NOTAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                notas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("No se encontraron notas guardadas.");
        }

        System.out.println("Notas guardadas:");
        for (String nota : notas) {
            System.out.println(nota);
        }

        System.out.println("\nIngresa tus notas (escribe 'salir' para terminar):");
        while (true) {
            String nota = scanner.nextLine();
            if (nota.equalsIgnoreCase("salir")) {
                break;
            }
            notas.add(nota);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_NOTAS))) {
            for (String nota : notas) {
                bw.write(nota);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las notas.");
        }

        System.out.println("Notas guardadas correctamente.");
    }
}
