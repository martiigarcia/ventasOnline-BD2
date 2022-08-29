package modelos;

public class Producto {

    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private double precio;
    private Marca marca;

    public Producto(int codigo, String descripcion, Categoria categoria, double precio, Marca marca) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.marca = marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Marca getMarca() {
        return marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + categoria.getNombre() +
                ", precio=" + precio +
                ", marca=" + marca +
                '}';
    }
}