import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";

    public static void main(String[] args) {
        Connection conexion = conectar();

        if (conexion != null) {
            agregarUsuario(conexion, "Juan Perez", "juan@example.com");

            actualizarUsuario(conexion, 1, "Juan Perez", "juanp@example.com");

            eliminarUsuario(conexion, 1);

            cerrarConexion(conexion);
        }
    }

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            manejarSQLException(e);
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada exitosamente");
            } catch (SQLException e) {
                manejarSQLException(e);
            }
        }
    }

    public static void agregarUsuario(Connection conn, String nombre, String email) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, email);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario agregado exitosamente.");
            }
        } catch (SQLException e) {
            manejarSQLException(e);
        }
    }

    public static void actualizarUsuario(Connection conn, int id, String nombre, String email) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, email);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado exitosamente.");
            }
        } catch (SQLException e) {
            manejarSQLException(e);
        }
    }

    public static void eliminarUsuario(Connection conn, int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado exitosamente.");
            }
        } catch (SQLException e) {
            manejarSQLException(e);
        }
    }

    public static void manejarSQLException(SQLException e) {
        switch (e.getErrorCode()) {
            case 1049:
                System.out.println("Error: Base de datos no encontrada.");
                break;
            case 1045:
                System.out.println("Error: Usuario/Contraseña incorrectos.");
                break;
            case 0:
                System.out.println("Error: No se puede conectar al servidor de base de datos.");
                break;
            default:
                System.out.println("Error en la operación de base de datos: " + e.getMessage());
                break;
        }
        e.printStackTrace();
    }
}
