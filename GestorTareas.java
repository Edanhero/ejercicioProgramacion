import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {
        String[] tareas = new String[100];
        int[] prioridades = new int[100];
        int numTareas = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Agregar tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Completar tarea de mayor prioridad");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            if (opcion == 1 && numTareas < 100) {
                System.out.print("Ingrese la tarea: ");
                tareas[numTareas] = sc.nextLine();
                System.out.print("Ingrese la prioridad (1-5): ");
                prioridades[numTareas] = sc.nextInt();
                numTareas++;
            } else if (opcion == 2) {
                for (int i = 0; i < numTareas; i++) {
                    System.out.println(tareas[i] + " (Prioridad: " + prioridades[i] + ")");
                }
            } else if (opcion == 3 && numTareas > 0) {
                int indiceMayorPrioridad = 0;
                for (int i = 1; i < numTareas; i++) {
                    if (prioridades[i] > prioridades[indiceMayorPrioridad]) {
                        indiceMayorPrioridad = i;
                    }
                }
                System.out.println("Tarea completada: " + tareas[indiceMayorPrioridad]);
                for (int i = indiceMayorPrioridad; i < numTareas - 1; i++) {
                    tareas[i] = tareas[i + 1];
                    prioridades[i] = prioridades[i + 1];
                }
                numTareas--;
            } else if (opcion == 4) {
                break;
            } else {
                System.out.println("Opción no válida o lista de tareas llena");
            }
        }
        sc.close();
    }
}