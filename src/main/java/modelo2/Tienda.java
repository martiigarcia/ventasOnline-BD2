package modelo2;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    //se hacen dos listas para mantener el registro historico de cada tipo de promociones
    private List<MarcaPromocion> marcaPromociones;

    private List<TarjetaPromocion> tarjetaPromociones;

    private List<Venta> ventaList;

    public Tienda() {
        this.ventaList = new ArrayList<>();
        this.marcaPromociones = new ArrayList<>();
        this.tarjetaPromociones = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        this.ventaList.add(venta);
    }

    //para actulizar las promociones
    public void setMarcaPromocion(MarcaPromocion marcaPromocion) {
        if (marcaPromociones.isEmpty()) {
            this.marcaPromociones.add(marcaPromocion);
        } else {
            this.marcaPromociones.get(marcaPromociones.size() - 1).setEstado();
            this.marcaPromociones.add(marcaPromocion);
        }
    }

    public void setTarjetaPromocion(TarjetaPromocion tarjetaPromocion) {
        if (this.tarjetaPromociones.isEmpty()) {
            this.tarjetaPromociones.add(tarjetaPromocion);
        } else {
            this.tarjetaPromociones.get(tarjetaPromociones.size() - 1).setEstado();
            this.tarjetaPromociones.add(tarjetaPromocion);
        }
    }


    //retornar la promocion de marca vigente
    public MarcaPromocion MarcaPromocion() {
        return this.marcaPromociones.get(marcaPromociones.size() - 1);
    }

    //retornar la promocion de tarjeta vigente
    public TarjetaPromocion TarjetaPromocion() {
        return this.tarjetaPromociones.get(tarjetaPromociones.size() - 1);
    }

    public List<MarcaPromocion> promocionList() {
        return marcaPromociones;
    }

}
