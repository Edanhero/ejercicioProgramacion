import java.sql.*;

public class GestionUsuario {

    private static final String URL = "jdbc:mysql://localhost:3306/usuariosdb";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");

            agregarUsuario(conn, "Juan Perez", "juan@example.com");

            actualizarUsuario(conn, 1, "Juan Perez", "juanp@example.com");

            eliminarUsuario(conn, 1);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
