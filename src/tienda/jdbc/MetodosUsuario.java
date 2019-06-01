package tienda.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilities.IO;

/**
 *
 * @author aparcerozas
 */
public class MetodosUsuario {

    /**
     * Constructor con parámetros.
     *
     * @param userConn
     */
    public MetodosUsuario(Connection userConn) {
        this.userConn = userConn;
    }

    /**
     * Constructor sin parámetros.
     */
    public MetodosUsuario() {
    }
    
    /**
     * Atributos.
     */
    private Connection userConn;
    private String sql_INSERT;
    private String sql_UPDATE;
    private String sql_DELETE;
    private String sql_SELECT;

    /**
     * Método que crea la tabla usuarios dónde se guardarán los datos de los
     * clientes y el administrador que se quieran conectar a la tienda
     */
    public void crearTablaUsuarios() {

        Connection conn = null;
        Statement stmt = null;

        String sql1 = "DROP TABLE IF EXISTS usuarios;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                + "usuario text PRIMARY KEY,\n"
                + "contraseña text NOT NULL,\n"
                + "tipo text\n"
                + ");";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.createStatement();

            // create new tables
            stmt.execute(sql1);
            stmt.execute(sql2);
            JOptionPane.showMessageDialog(null, "Tablas creadas correctamente.", "Succed", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        } finally {
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
    }

    /**
     * Método para insertar usuarios de tipo cliente a la tabla usuarios.
     *
     * @param usuario
     * @param contraseña
     * @return
     *
     */
    public int registrarCliente(String usuario, String contraseña) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_INSERT = "INSERT INTO usuarios VALUES(?,?,?)";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_INSERT);
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);
            stmt.setString(3, "cliente");
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
        } catch (SQLException ex) {
            IO.devolver(IO.VENTANA, "Usuario ya existente.");
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    /**
     * Método para insertar los datos del administrador a la tabla usuarios
     *
     * @return rows
     */
    public int registrarAdmin() {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_INSERT = "INSERT INTO usuarios VALUES(?,?,?)";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_INSERT);
            stmt.setString(1, "admin");
            stmt.setString(2, "admin");
            stmt.setString(3, "admin");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    /**
     * Método que busca un usuario en la tabla usuarios, buscando por todos los
     * campos, para que devuelva solo una resultado Si lo encuentra, devuelve
     * true. Si no, devuelve false.
     *
     * @param usuario
     * @param contraseña
     * @param tipo
     * @return encontrado
     *
     */
    public boolean buscarUsuario(String usuario, String contraseña, String tipo) {
        boolean encontrado = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        String resultado = "";
        String sql = "SELECT usuario,contraseña"
                + " FROM usuarios WHERE usuario = ? AND contraseña = ? AND tipo = ?";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);
            stmt.setString(3, tipo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                encontrado = true;
                return encontrado;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
            return encontrado;
        }
    }

    /**
     * Método que busca todos los usuarios y devuelcve un ArrayList.
     *
     * @return usuarios
     */
    public ArrayList<String> buscarUsuarios() {

        int rows;
        Connection conn = null;
        PreparedStatement stmt = null;
        String resultado = "";
        ArrayList<String> usuarios = new ArrayList<>();
        String sql = "SELECT usuario FROM usuarios";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(rs.getString("usuario"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
            return usuarios;
        }
    }
}
