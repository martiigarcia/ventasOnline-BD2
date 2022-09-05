package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class TarjetaPromocion extends Promocion<TipoTarjeta>{
    @Id
    @GeneratedValue
    private long id;
    private TipoTarjeta tarjeta;

    public TarjetaPromocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, TipoTarjeta tarjeta) {
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
