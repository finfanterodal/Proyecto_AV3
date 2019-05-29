package tienda.jdbc;

import java.sql.*;
import javax.swing.JOptionPane;
import tienda.dto.Producto;

/**
 *
 * @author finfanterodal
 */
public class CarroDaoJDBC {
    
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
    public int insertProducto(Producto producto, int unidadesCatalogo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_INSERT = "INSERT INTO carro(nombre,precio,numUnidades,tipo) VALUES(?,?,?,?)";
        sql_UPDATE = "UPDATE tienda SET numUnidades = ? WHERE nombre = "+ producto.getNome();
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_INSERT);
            stmt.setString(1, producto.getNome());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getNumUnid());
            stmt.setString(4, producto.getTipo());
            stmt.executeUpdate();
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registros insertados: " + rows, "Succed", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Ejecutado correctamente.", "Succed", JOptionPane.INFORMATION_MESSAGE);
            stmt = conn.prepareStatement(sql_UPDATE);
            stmt.setInt(1, unidadesCatalogo - producto.getNumUnid());
            stmt.executeUpdate();
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
    public int updateProducto(Producto libro) throws SQLException {

    }

    /**
     * Elimina este producto de la base de datos, de la tabla en cuestión.
     * Elimina el producto del carro y devuelve las unidades a la tienda.
     */
    public int deleteProducto(Producto libro) throws SQLException {

    }

}
