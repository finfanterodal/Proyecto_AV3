package tienda.jdbc;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tienda.dto.Producto;

/**
 *
 * @author finfanterodal
 */
public class CarroDaoJDBC {

    /**
     * Constructor vacío.
     */
    public CarroDaoJDBC() {
    }

    /**
     * Constructor que recibe un objeto de tipo Conection.
     *
     * @param userConn
     */
    public CarroDaoJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    /*
    *Atributos
     */
    private Connection userConn;
    private String sql_INSERT;
    private String sql_UPDATE;
    private String sql_DELETE;
    private String sql_SELECT;

    /**
     * Este método añade un nuevo producto a la tabla existente en la base de
     * datos.
     *
     * @param producto
     * @param unidadesCatalogo
     * @return rows
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar los datos en el carro.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    /**
     * Este méto actualiza un producto de nuestra tabla.
     *
     * @param producto
     * @return rows
     */
    public int updateProducto(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_UPDATE = "UPDATE carro SET precio = ? , "
                + "numUnidades = ? "
                + "WHERE nombre = ?";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_UPDATE);
            //Libros   
            stmt.setDouble(1, producto.getPrecio());
            stmt.setInt(2, producto.getNumUnid());
            stmt.setString(3, producto.getNome());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos en el carro.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    /**
     * Elimina este producto de la base de datos, de la tabla en cuestión.
     *
     * @param nombre
     * @return rows
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar los datos en el carro.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    /**
     * Este método carga los datos existentes en la base de datos de la tabla
     * en cuestión en un ArrayList y lo devuelve.
     *
     * @return productos
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
            JOptionPane.showMessageDialog(null, "Error al buscar los datos en el carro.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return productos;
    }

    /**
     * Este método busca un producto en la base de datos dado el nombre, y
     * devuelve ese producto.
     *
     * @param nombre
     * @return productoaux
     */
    public Producto buscarProducto(String nombre) {
        int numUnidades = 0;
        sql_SELECT = "SELECT nombre,precio,numUnidades,tipo FROM carro WHERE nombre = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto productoaux = null;
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_SELECT);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            while (rs.next()) {
                productoaux = new Producto(rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("numUnidades"), rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }

        return productoaux;
    }
    
    /**
     *Este método busca el precio y el número de unidades de los productos 
     * del carro, y calcula y devuelve el precio total de la compra
     * 
     * @return
     */
    public double calcularPrecio() {
        double precio = 0;
        sql_SELECT = "SELECT precio,numUnidades FROM carro";
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
                precio = precio + (rs.getDouble("precio") * rs.getInt("numUnidades"));
            }
            return precio;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular el precio.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
        return precio;
    }
    
    
    
    /**
     * Borramos tabla carro.
     *
     */
    public void borrarTablaCarro() {
        Connection conn = null;
        Statement stmt = null;
        String sqlDrop2 = "DELETE FROM carro;\n";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.createStatement();
            //borrar tablas
            stmt.execute(sqlDrop2);
        } catch (SQLException ex) {

        } finally {
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }
    }
}
