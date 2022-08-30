package modelo2;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private MarcaPromocion marcaPromocion;

    private TarjetaPromocion tarjetaPromocion;

    private List<Venta> ventaList;

    public Tienda() {
        this.ventaList = new ArrayList<>();
    }

    public void agregarVentaRelizada(Venta venta) {
        this.ventaList.add(venta);
    }

    //para actulizar las promociones
    public void setMarcaPromocion(MarcaPromocion marcaPromocion) {
        this.marcaPromocion = marcaPromocion;
    }

    public void setTarjetaPromocion(TarjetaPromocion tarjetaPromocion) {
        this.tarjetaPromocion = tarjetaPromocion;
    }

    public MarcaPromocion MarcaPromocion() {
        return marcaPromocion;
    }

    public TarjetaPromocion TarjetaPromocion() {
        return tarjetaPromocion;
    }

    public List<Promocion> promociones() {
        List<Promocion> promocions = new ArrayList<>();
        promocions.add(this.marcaPromocion);
        promocions.add(this.tarjetaPromocion);
        return promocions;
    }

}
