package modelo2;

import java.time.LocalDate;

public class TarjetaPromocion extends Promocion<TipoTarjeta>{

    private TipoTarjeta tarjeta;

    public TarjetaPromocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, TipoTarjeta tarjeta) {
        super(estado, fechaInicio, fechaFin, tarjeta);
        this.tarjeta = tarjeta;
    }

    @Override
    public double getDescuento() {
        return 0.08;
    }

    public TipoTarjeta tarjeta(){
        return tarjeta;
    }

    @Override
    public String toString() {
        return "TarjetaPromocion{ "+ tarjeta +" }";
    }
}
