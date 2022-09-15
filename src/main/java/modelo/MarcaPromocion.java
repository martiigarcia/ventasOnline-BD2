package modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Embeddable
public class MarcaPromocion extends Promocion<Marca> {

    @OneToOne
    private Marca marca;

    public MarcaPromocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, Marca marca) throws RuntimeException{
        super(estado, fechaInicio, fechaFin, marca);
        this.marca = marca;
    }

    public MarcaPromocion() {

    }


    @Override
    public double descuento() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(this.fechaFin()) || hoy.isBefore(this.fechaInicio())) {
            return 0;
        }
        return 0.05;
    }

    public Marca marca() {
        return marca;
    }


   /* @Override
    public String toString() {
        return "MarcaPromocion{ " + marca +" }";
    }*/
}
