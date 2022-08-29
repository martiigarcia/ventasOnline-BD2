package modelos;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private List<Promocion> promocionList;
    private List<Venta> ventaList;

    public Tienda(){
        this.promocionList = new ArrayList<>();
        this.ventaList = new ArrayList<>();
    }

    public void setVentaList(Venta venta) {
        this.ventaList.add(venta);
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setPromocion(Promocion promocion) {
        this.promocionList.add(promocion);
    }

    public List<Promocion> getPromocion() {
        return promocionList;
    }


    @Override
    public String toString() {
        return "Tienda{ \n" +
                "\nPromociones de la tienda= " + promocionList +
                "\nVentas registradas= [" + ventaList +
                "]}";
    }
}
