package tienda.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author finfanterodal
 */
public class TiendaDaoJDBC {

    //Utilizar la misma conexion para todas las acciones
    /**
     *
     * @param userConn
     */
    public TiendaDaoJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    private Connection userConn;

    private String sql_INSERT;
    private String sql_UPDATE;
    private String sql_DELETE;
    private String sql_SELECT;

    /**
     * Creamos las tablas que utilizamos en nuestra base de datos.
     *
     *
     */
    public void crearTablas() {

        Connection conn = null;
        Statement stmt = null;

        String sql1 = "CREATE TABLE IF NOT EXISTS tienda (\n"
                + " isbn integer PRIMARY KEY,\n"
                + " autor text NOT NULL,\n"
                + " titulo text NOT NULL,\n"
                + " idGenero integer NOT NULL REFERENCES generos (idGenero) \n"
                + ");";
        String sql2 = "CREATE TABLE IF NOT EXISTS carro (\n"
                + "	idGenero integer PRIMARY KEY,\n"
                + "	genero text NOT NULL \n"
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

}
