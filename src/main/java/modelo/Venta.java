package modelo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venta {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Cliente cliente;
    @Enumerated(EnumType.ORDINAL)
    private EstadoVenta estadoVenta;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Tarjeta tarjeta;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<ProductoVendido> productosVendidos;

    private double montoAbonado;


    public Venta(Cliente cliente, Tarjeta tarjeta, EstadoVenta estadoVenta, List<Producto> productosVendidos, double montoAbonado) {
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.estadoVenta = estadoVenta;
        this.productosVendidos = new ArrayList<>();
        this.agregarProductos(productosVendidos);
        this.montoAbonado = montoAbonado;
    }

    protected Venta() {

    }

    private void agregarProductos(List<Producto> productos) {
        productos.forEach(producto ->
                this.productosVendidos.add(
                        new ProductoVendido(producto.codigo(), producto.precio()
                              )));

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
