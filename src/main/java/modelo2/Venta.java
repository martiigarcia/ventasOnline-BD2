package modelo2;


import java.util.ArrayList;
import java.util.List;

public class Venta {

    private Cliente cliente;
    private EstadoVenta estadoVenta;
    private Tarjeta tarjeta;

    private List<Producto> productosVendidos;

    private double montoAbonado;


    public Venta(Cliente cliente, Tarjeta tarjeta, EstadoVenta estadoVenta, List<Producto> productosVendidos, double montoAbonado) {
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.estadoVenta = estadoVenta;
        this.productosVendidos = new ArrayList<>();
        this.agregarProductos(productosVendidos);
        this.montoAbonado = montoAbonado;
    }

    private void agregarProductos(List<Producto> productos) {
        productos.forEach(producto ->
                this.productosVendidos.add(
                        new Producto(producto.getCodigo(), producto.getPrecio(),
                                producto.getDescripcion(), producto.getCategoria(),
                                 producto.getMarca())));

    }

    @Override
    public String toString() {
        return "Venta{" +
                "cliente=" + cliente +
                ", estadoVenta=" + estadoVenta +
                ", tarjeta=" + tarjeta +
                ", productosVendidos=" + productosVendidos +
                ", montoAbonado=" + montoAbonado +
                '}';
    }
}
