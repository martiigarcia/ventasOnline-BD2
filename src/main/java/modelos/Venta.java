package modelos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Venta {

    private Date fecha;
    private double montoTotal;
    private List<Producto> carrito;
    private EstadoVenta estado;

    private Cliente cliente;

    public Venta(LocalDate fecha, Carrito carrito, Cliente cliente) {
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.carrito = new ArrayList<>(carrito.getProductos());
        this.estado = EstadoVenta.PENDIENTE;
        this.cliente = cliente;

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


   /* public Carrito getCarrito() {
        return carrito;
    }*/

    public void setFecha(LocalDate fecha) {
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void setMontoTotal(Promocion promocion) {
        this.montoTotal = promocion.calcularMontoCarrito(new Carrito(carrito));
    }

    public double getMontoTotal(){return montoTotal;}

    /*public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }*/
    public void pagar(Tarjeta tarjeta){
        // hacer validacion del servicio
        // if (tiene saldo y esta activa)
        this.ventaCompleta();
        this.cliente.vaciarCarrito();
        System.out.println("Venta realizada con exito");
    }

    @Override
    public String toString() {
        return "Venta{" +
                "fecha=" + fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                ", montoTotal=" + montoTotal +
                ", estado=" + estado +
                ", productos del carrito= [" + carrito +
                "]}";
    }
}
