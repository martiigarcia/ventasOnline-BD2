package modelos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class promoDeCompra extends Promocion<TipoTarjeta> {


    private TipoTarjeta tarjeta;

    public promoDeCompra(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, TipoTarjeta tarjeta) {
        super(estado, fechaInicio, fechaFin, tarjeta);
        this.tarjeta = tarjeta;
    }

    @Override
    public double getDescuento() {
        return 0.08;
    }


    void setTarjeta(TipoTarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public double calcularMontoCarrito(Carrito carrito) {
        double precio = carrito.getProductos().stream().mapToDouble(Producto::getPrecio).sum();
        precio = precio - (precio * this.getDescuento());
        return precio;
    }


    public TipoTarjeta getTarjeta() {
        return tarjeta;
    }

    @Override
    public String toString() {
        return "Promocion De Compra: " +
                "tarjeta=" + tarjeta +
                ". " + super.toString();
    }
}