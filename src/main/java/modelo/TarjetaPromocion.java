package modelo;

import javax.persistence.*;
import java.time.LocalDate;
@Embeddable
public class TarjetaPromocion extends Promocion<TipoTarjeta>{

    @Enumerated private TipoTarjeta tarjeta;

    public TarjetaPromocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, TipoTarjeta tarjeta) throws RuntimeException{
        super(estado, fechaInicio, fechaFin, tarjeta);
        this.tarjeta = tarjeta;
    }

    protected TarjetaPromocion() {

    }

    @Override
    public double descuento() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(this.fechaFin()) || hoy.isBefore(this.fechaInicio())){
            return 0;
        }
        return 0.08;
    }


    public TipoTarjeta tarjeta(){
        return tarjeta;
    }

    /*@Override
    public String toString() {
        return "TarjetaPromocion{ "+ tarjeta +" }";
    }*/
}
