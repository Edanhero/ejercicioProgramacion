class rectangulo {
    int ancho;
    int alto;

    rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
}

public class PasoRectangulo {

    public static void modificarRectangulo(rectangulo r) {
        r.ancho = 50;
        r.alto = 30;
        System.out.println("Dentro del método: ancho = " + r.ancho + ", alto = " + r.alto);
    }

    public static void main(String[] args) {
        rectangulo miRectangulo = new rectangulo(10, 20);
        System.out.println("Antes de modificar: ancho = " + miRectangulo.ancho + ", alto = " + miRectangulo.alto);
        modificarRectangulo(miRectangulo);
        System.out.println("Después de modificar: ancho = " + miRectangulo.ancho + ", alto = " + miRectangulo.alto);
    }
}
