package modelo2;

import modelos.Promocion;

public class Venta {

    private Cliente cliente;
    private EstadoVenta estadoVenta;
    private Tarjeta tarjeta;


    public Venta(Cliente cliente, Tarjeta tarjeta, EstadoVenta estadoVenta) {
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.estadoVenta = estadoVenta;
    }
}
