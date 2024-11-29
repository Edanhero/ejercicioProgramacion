import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

public class GestionProductos {
    private static final String ARCHIVO_JSON = "productos.json";

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        // Leer productos existentes del archivo JSON
        try (Reader reader = new FileReader(ARCHIVO_JSON)) {
            Type listType = new TypeToken<ArrayList<Producto>>() {}.getType();
            productos = gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("No se encontraron productos guardados.");
        }

        // Mostrar productos existentes
        System.out.println("Productos guardados:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("\nIngresa tus productos (escribe 'salir' para terminar):");
        while (true) {
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }
            System.out.print("Precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();  
            productos.add(new Producto(nombre, precio));
        }

        try (Writer writer = new FileWriter(ARCHIVO_JSON)) {
            gson.toJson(productos, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar los productos.");
        }

        System.out.println("Productos guardados correctamente.");
    }
}
