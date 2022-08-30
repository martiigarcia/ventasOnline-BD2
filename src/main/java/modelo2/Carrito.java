package modelo2;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> productos;

    //private Cliente cliente;


    public Carrito() {
        this.productos = new ArrayList<>();
        //    this.cliente = cliente;
    }

    public void agregarProductoAlCarrito(Producto producto) {
        this.productos.add(
                new Producto(producto.getCodigo(),
                        producto.getDescripcion(), producto.getCategoria(),
                        producto.getPrecio(), producto.getMarca()));
    }

    public List<Producto> listaProductos() {
        return this.productos;
    }

    public double calcularMontoCarrito(MarcaPromocion marcaPromocion, TarjetaPromocion tarjetaPromocion, Tarjeta tarjeta) {

        double precio = 0;
        for (Producto producto : this.productos) {
            if (producto.getMarca().equals(marcaPromocion.marca())) {
                precio = precio + (producto.getPrecio() - (producto.getPrecio() * marcaPromocion.getDescuento()));
            } else {
                precio += producto.getPrecio();
            }
        }
        if (tarjeta.tipoTarjeta().equals(tarjetaPromocion.tarjeta())) {
            precio = precio - (precio * tarjetaPromocion.getDescuento());
        }

        return precio;

    }

    public Venta pagar() {
        return new Venta();
    }

}
