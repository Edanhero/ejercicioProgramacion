import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}

public class GestionLibros {
    private static final String ARCHIVO_LIBROS = "libros.txt";

    public static void main(String[] args) {
        List<Libro> libros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        leerLibros(libros);

        while (true) {
            System.out.println("\n1. Añadir libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Listar libros");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    anadirLibro(libros, scanner);
                    break;
                case 2:
                    buscarLibro(libros, scanner);
                    break;
                case 3:
                    listarLibros(libros);
                    break;
                case 4:
                    guardarLibros(libros);
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void leerLibros(List<Libro> libros) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_LIBROS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                libros.add(new Libro(datos[0], datos[1]));
            }
        } catch (IOException e) {
            System.out.println("No se encontraron libros guardados.");
        }
    }

    private static void guardarLibros(List<Libro> libros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_LIBROS))) {
            for (Libro libro : libros) {
                bw.write(libro.getTitulo() + "," + libro.getAutor());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los libros.");
        }
    }

    private static void anadirLibro(List<Libro> libros, Scanner scanner) {
        System.out.print("Introduce el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el autor del libro: ");
        String autor = scanner.nextLine();
        libros.add(new Libro(titulo, autor));
        System.out.println("Libro añadido exitosamente.");
    }

    private static void buscarLibro(List<Libro> libros, Scanner scanner) {
        System.out.print("Introduce el título del libro que buscas: ");
        String titulo = scanner.nextLine();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado: " + libro);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    private static void listarLibros(List<Libro> libros) {
        System.out.println("Lista de libros:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}
