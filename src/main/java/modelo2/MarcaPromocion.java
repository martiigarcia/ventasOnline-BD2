package modelo2;

import java.time.LocalDate;

public class MarcaPromocion extends Promocion<Marca> {

    private Marca marca;

    public MarcaPromocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, Marca marca) {
        super(estado, fechaInicio, fechaFin, marca);
        this.marca = marca;
    }

    @Override
    public double getDescuento() {
        return 0.05;
    }
    public Marca marca(){
        return marca;
    }

    @Override
    public String toString() {
        return "MarcaPromocion{ " + marca +" }";
    }
}
