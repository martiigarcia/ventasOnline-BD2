package modelos;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> productos ;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public void setProductos(Producto producto) {
        this.productos.add(
                new Producto(producto.getCodigo(),
                        producto.getDescripcion(),producto.getCategoria(),
                        producto.getPrecio(),new Marca(producto.getMarca().getNombre())));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double montoTotal(){
        //double suma=0;
        double sum = productos.stream().mapToDouble(Producto::getPrecio).sum();
        return sum;
    }

    public void vaciar(){
        productos.clear();
    }


   /* public double getSum() {
        double sum = 0;
        for (Producto i: this.productos) {
            sum += i.getPrecio();
        }
        return sum;
    }*/

}
