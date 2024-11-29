import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Heroe {
    private String nombre;

    public Heroe(String nombre) {
        this.nombre = nombre;
    }

    public void salvarMundo() {
        System.out.println(nombre + " ha salvado el mundo!");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

public class HeroeTest {
    private Heroe heroe;

    @BeforeEach
    public void setUp() {
        heroe = new Heroe("Superman");
    }

    @Test
    public void testSalvarMundo() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(salida);
        PrintStream consolaOriginal = System.out;
        System.setOut(ps);

        heroe.salvarMundo();

        System.setOut(consolaOriginal);

        String salidaEsperada = "Superman ha salvado el mundo!\n";
        assertEquals(salidaEsperada, salida.toString());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Superman", heroe.getNombre());
    }

    @Test
    public void testSetNombre() {
        heroe.setNombre("Batman");
        assertEquals("Batman", heroe.getNombre());
    }
}
