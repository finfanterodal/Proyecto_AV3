package tienda.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tienda.dto.Producto;

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
    public TiendaDaoJDBC() {
    }

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
                + " nombre text PRIMARY KEY,\n"
                + " precio real NOT NULL,\n"
                + " numUnidades integer NOT NULL,\n"
                + " tipo text NOT NULL \n"
                + ");";
        String sql2 = "CREATE TABLE IF NOT EXISTS carro (\n"
                + " nombre text PRIMARY KEY,\n"
                + " precio real NOT NULL,\n"
                + " numUnidades integer NOT NULL,\n"
                + " tipo text NOT NULL \n"
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
     * Este método añade un nuevo producto a la tabla existente en la base de
     * datos. Si el nombre de este producto ya existe saltará una excepción y no
     * se podrá introducir.
     */
    public int insertProducto(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_INSERT = "INSERT INTO tienda(nombre,precio,numUnidades,tipo) VALUES(?,?,?,?)";
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
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertado correctamente.", "Succed", JOptionPane.INFORMATION_MESSAGE);
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
     * Este método permite modificar el precio y el número de unidades del
     * producto en la base de datos. Si el número de unidades que le asignamos
     * es 0 se eleiminará.
     *
     * @param producto
     * @return
     */
    public int updateProducto(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_UPDATE = "UPDATE tienda SET precio = ? , "
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
            JOptionPane.showMessageDialog(null, "Modificado correctamente.", "Succed", JOptionPane.INFORMATION_MESSAGE);
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
     * Este método permite eliminar un producto de la base de datos.
     *
     */
    public int deleteProducto(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        sql_DELETE = "DELETE FROM tienda WHERE nombre = ?";
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
     * Añadimos datos de un fichero a la tabla de Generos.
     *
     *
     */
    public void cargarDatosInicialesCatalogo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        Scanner sc = null;
        sql_INSERT = "INSERT INTO tienda(nombre,precio,numUnidades,tipo) VALUES(?,?,?,?)";
        try {
            if (this.userConn != null) {
                conn = this.userConn;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(sql_INSERT);
            File fichero = new File("Catalogo.txt");
            sc = new Scanner(fichero);
            //Libros   
            while (sc.hasNextLine()) {
                Object[] product = sc.nextLine().split(",");
                stmt.setString(1, product[0].toString());
                stmt.setDouble(2, Double.parseDouble(product[1].toString()));
                stmt.setInt(3, Integer.parseInt(product[2].toString()));
                stmt.setString(4, product[3].toString());
                stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Datos cargados correctamente.", "Succed", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }

    }

    /**
     *
     *
     *
     * @return @throws java.sql.SQLException
     */
    public ArrayList<Producto> refreshArrayProductoTienda() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        sql_SELECT = "SELECT nombre,precio,numUnidades,tipo FROM tienda";
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

    public String selectTipo(int opt) {
        String opcion = "";
        switch (opt) {
            case 0:
                opcion = "Ropa";
                break;
            case 1:
                opcion = "Alimento";
                break;
            case 2:
                opcion = "Electronica";
                break;
            case 3:
                opcion = "Higiene";
                break;
            case 4:
                opcion = "Deporte";
                break;
            case 5:
                opcion = "Informática";
                break;
        }
        return opcion;
    }

    public Producto buscarProducto(String nombre) {
        int numUnidades = 0;
        sql_SELECT = "SELECT nombre,precio,numUnidades,tipo FROM tienda WHERE nombre = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto productoaux=null; 
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
            Logger.getLogger(TiendaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.userConn == null) {
                Conexion.close(conn);
            }
        }

        return productoaux;
    }

}
