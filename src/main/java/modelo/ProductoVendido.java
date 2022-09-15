package modelo;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ProductoVendido {
    @Id
    @GeneratedValue
    private long id;
    private String codigo;
    private double precioPago;

    public ProductoVendido(String codigo, double precio) {
        this.codigo = codigo;
        this.precioPago = precio;
    }

    public ProductoVendido() {

    }

    public double getPrecioPago() {
        return precioPago;
    }

    public void setPrecioPago(double precioPago) {
        this.precioPago = precioPago;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String codigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Producto Vendido{" +
                "codigo=" + codigo +
                ", precio=" + precioPago +
                '}';
    }

}