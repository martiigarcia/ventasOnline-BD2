package modelos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Venta {

    private Date fecha;
    private double montoTotal;
    private Carrito carrito;
    private EstadoVenta estado;

    public Venta(LocalDate fecha, Carrito carrito) {
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.carrito = carrito;
        this.estado = EstadoVenta.PENDIENTE;

    }
    public void ventaCompleta(){
        this.estado = EstadoVenta.COMPLETA;
    }
    public void ventaCancelada(){
        this.estado = EstadoVenta.CANCELADA;
    }
    public String getEstado(){
        return estado.toString();
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
    public void pagar(){
        // hacer validacion del servicio
        // if(tiene saldo y esta activa)
        this.ventaCompleta();
        this.carrito.vaciar();
    }

    @Override
    public String toString() {
        return "Venta{" +
                "fecha=" + fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                ", montoTotal=" + montoTotal +
                ", estado=" + estado +
                ", productos del carrito= [" + carrito.getProductos() +
                "]}";
    }
}
