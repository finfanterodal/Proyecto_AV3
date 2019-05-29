package tienda.jdbc;

import java.sql.SQLException;
import tienda.dto.Producto;

/**
 *
 * @author finfanterodal
 */
public class CarroDaoJDBC {

    /**
     * Este método añade un nuevo producto a la tabla existente en la base de
     * datos y quita unidades de la tienda. Si el nombre de este producto ya
     * existe saltará una excepción y no se podrá introducir.
     */
    public int insertProducto(Producto libro) throws SQLException {
        
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
