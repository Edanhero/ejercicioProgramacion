public class tiendaDeRopa {
    public static void main(String[] args) {
        final double PRECIO_CAMISETA = 25.0;
        final double PRECIO_PANTALON = 30.0;
        final double DESCUENTO_GENERAL = 0.15;
        final double DESCUENTO_ADICIONAL = 0.05;

        double precioCamisetaConDescuento = PRECIO_CAMISETA * (1 - DESCUENTO_GENERAL);
        double precioPantalonConDescuento = PRECIO_PANTALON * (1 - DESCUENTO_GENERAL);
        double precioSegundaCamisetaConDescuento = precioCamisetaConDescuento * (1 - DESCUENTO_ADICIONAL);

        double precioTotal = precioCamisetaConDescuento + precioPantalonConDescuento + precioSegundaCamisetaConDescuento;

        System.out.println("El precio total después de aplicar los descuentos es: $" + precioTotal);
    }
}
