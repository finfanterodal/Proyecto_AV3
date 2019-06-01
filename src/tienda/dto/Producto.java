package tienda.dto;

/**
 *
 * @author finfanterodal
 */
public class Producto {
    /*
    *Atributos.
     */
    private String nome;
    private double precio;
    private int numUnidades;
    private String tipo;

    /*
    *Constructor con parámetros.
     */

    /**
     *
     * @param nome
     * @param precio
     * @param numUnidades
     * @param tipo
     */

    public Producto(String nome, double precio, int numUnidades,
            String tipo) {
        this.nome = nome;
        this.precio = precio;
        this.numUnidades = numUnidades;
        this.tipo = tipo;
    }

    /*
    *Constructor vacío.
     */

    /**
     *
     */

    public Producto() {
    }

    /*
    *Acceso a atributos.
     */

    /**
     *
     * @return
     */

    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public int getNumUnid() {
        return numUnidades;
    }

    /**
     *
     * @param numUnidades
     */
    public void setNumUnid(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + ", Precio:" + precio + ", Tipo:" + tipo + ", Número de unidades:" + numUnidades;
    }
}
