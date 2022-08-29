package modelos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class promoDeProducto extends Promocion<Marca> {


    private Marca marca;

    public promoDeProducto(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, Marca marca) {
        super(estado, fechaInicio, fechaFin, marca);
        this.marca = marca;
    }

    @Override
    public double getDescuento() {
        return 0.05;
    }


    void setMarca(Marca marca) {
        this.marca = marca;
    }


    public Marca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Promocion De Marca: " +
                "marca=" + marca.getNombre() +
                ". " + super.toString();
    }

    @Override
    public double calcularMontoCarrito(Carrito carrito) {

        double precio = 0;
        for (Producto producto : carrito.getProductos()) {
            if (producto.getMarca().equals(marca)) {
                precio = precio + (producto.getPrecio() - (producto.getPrecio() * getDescuento()));
            } else {
                precio += producto.getPrecio();
            }

        }
        return precio;
    }
}