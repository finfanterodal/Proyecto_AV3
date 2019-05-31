package tienda.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tienda.dto.Producto;

/**
 *
 * @author finfanterodal
 */
public class CarroDaoJDBC {

    public CarroDaoJDBC() {
    }

    
    public CarroDaoJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    private Connection userConn;
    TiendaDaoJDBC tienda = new TiendaDaoJDBC();

    private String sql_INSERT;
    private String sql_UPDATE;
    private String sql_DELETE;
    private String sql_SELECT;

    /**
     * Este método añade un nuevo producto a la tabla existente en la base de
     * datos y quita unidades de la tienda. Si el nombre de este producto ya
     * existe saltará una excepción y no se podrá introducir.
     */
    public int insertProducto(Producto producto, int unidadesCatalogo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_INSERT = "INSERT INTO carro(nombre,precio,numUnidades,tipo) VALUES(?,?,?,?)";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_INSERT);
            stmt.setString(1, producto.getNome());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, unidadesCatalogo);
            stmt.setString(4, producto.getTipo());
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertado correctamente.", "Succed", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(CarroDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    /**
     * Este méto actualiza un producto de nuestra tabla. Si el producto ya está
     * en la base de datos solo añade unidades de este producto.
     */
    /*
    public int updateProducto(Producto libro) throws SQLException {

    }
     */
    /**
     * Elimina este producto de la base de datos, de la tabla en cuestión.
     * Elimina el producto del carro y devuelve las unidades a la tienda.
     */
    public int deleteProducto(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_DELETE = "DELETE FROM carro WHERE nombre = ?";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_DELETE);
            stmt.setString(1, nombre);
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente.", "Succed", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(TiendaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    /**
     *
     *
     *
     * @return @throws java.sql.SQLException
     */
    public ArrayList<Producto> refreshArrayProductoCarro() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        sql_SELECT = "SELECT nombre,precio,numUnidades,tipo FROM carro";
        //Borramos arrayList
        productos.clear();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Producto productoaux = new Producto(rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("numUnidades"), rs.getString("tipo"));
                productos.add(productoaux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiendaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return productos;
    }
}
