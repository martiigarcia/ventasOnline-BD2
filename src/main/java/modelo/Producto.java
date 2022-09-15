package modelo;

import javax.jdo.annotations.Unique;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Producto {
    @Id
    @GeneratedValue
    private long id;

    //  @Unique
    private String codigo;
    private String descripcion;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Categoria categoria;
    private double precio;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Marca marca;

    protected Producto() {

    }

    public Producto(String codigo, double precio, String descripcion, Categoria categoria, Marca marca) throws RuntimeException {

        if (esDatoVacio(codigo))
            throw new RuntimeException("El codigo debe ser valido");
        this.codigo = codigo;

        if (descripcion == null || descripcion.isEmpty())
            throw new RuntimeException("La descripcion debe ser valido");
        this.descripcion = descripcion;

        if (esDatoVacio(String.valueOf(precio)))
            throw new RuntimeException("El precio debe ser valido");
        this.precio = precio;

        if (esDatoNulo(categoria))
            throw new RuntimeException("La categoria debe ser valido");
        this.categoria = categoria;

        if (esDatoNulo(marca))
            throw new RuntimeException("La marca debe ser valido");
        this.marca = marca;
    }

    public Producto(long id, String codigo, double precio, String descripcion, Categoria categoria, Marca marca) throws RuntimeException{
        this(codigo, precio, descripcion, categoria, marca);
        this.id = id;
    }

    private boolean esDatoVacio(String dato) {
        return dato.equals("");
    }

    private boolean esDatoNulo(Object dato) {
        return dato == null;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String codigo() {
        return codigo;
    }

    public String descripcion() {
        return descripcion;
    }

    public Marca marca() {
        return marca;
    }

    public Categoria categoria() {
        return categoria;
    }

    public double precio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id: "+id+
                ", codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", " + categoria +
                ", precio=" + precio +
                ", " + marca +
                '}';
    }

    public Map<String, Object> toMap() {
        var map = new HashMap<String, Object>(
                Map.of("id", id, "codigo", codigo, "precio", precio, "descripcion", descripcion,
                        "categoria", categoria, "marca", marca));

        return map;
    }
}