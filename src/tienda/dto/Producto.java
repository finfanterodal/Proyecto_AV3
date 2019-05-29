package tienda.dto;

/**
 *
 * @author finfanterodal
 */
public class Producto {
    //Atributos

    private String nome;
    private double precio;
    private int numUnidades;
    private String tipo;

    public Producto(String nome, double precio, int numUnidades,
            String tipo) {
        this.nome = nome;
        this.precio = precio;
        this.numUnidades = numUnidades;
        this.tipo = tipo;
    }

    public Producto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumUnid() {
        return numUnidades;
    }

    public void setNumUnid(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + ", Precio:" + precio + ", Tipo:" + tipo + ", Número de unidades:" + numUnidades;
    }
}
