package modelos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String apellido;
    private long dni;
    private String email;
    private List<Tarjeta> tarjetas;

    private Carrito carrito;


    public Cliente(String nombre, String apellido, long dni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.tarjetas = new ArrayList<Tarjeta>();
        this.carrito = new Carrito();
    }

    public void setCarrito(Producto producto) {
        this.carrito.setProductos(producto);
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void addTarjetas(Tarjeta tarjeta) {
        this.tarjetas.add(tarjeta);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void vaciarCarrito(){
        carrito.vaciar();
    }
}
