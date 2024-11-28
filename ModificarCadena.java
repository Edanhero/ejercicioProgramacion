public class ModificarCadena {

    public static void modificarCadena(String texto) {
        texto = texto + " modificado";
        System.out.println("Dentro del método: " + texto);
    }

    public static void main(String[] args) {
        String textoOriginal = "Hola";
        System.out.println("Antes de modificar: " + textoOriginal);
        modificarCadena(textoOriginal);
        System.out.println("Después de modificar: " + textoOriginal);  // No cambia
    }
}
