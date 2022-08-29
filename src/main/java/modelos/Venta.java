package modelos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Venta {

    private Date fecha;
    private double montoTotal;
    private Carrito carrito;

    private enum estadoVenta{
            COMPLETA, PENDIENTE, CANCELADA;
    }

    public Venta(LocalDate fecha, Carrito carrito) {
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.carrito = carrito;

    }

    public LocalDate getFecha() {
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


    public Carrito getCarrito() {
        return carrito;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void setMontoTotal(Promocion promocion) {
        this.montoTotal = promocion.calcularMontoCarrito(carrito);
    }

    public double getMontoTotal(){return montoTotal;}

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "fecha=" + fecha +
                ", montoTotal=" + montoTotal +
                ", productos del carrito= [" + carrito.getProductos() +
                "]}";
    }
}
