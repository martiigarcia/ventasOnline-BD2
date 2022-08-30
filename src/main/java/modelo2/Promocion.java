package modelo2;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class Promocion<P> {

    private boolean estado;
    private Date fechaInicio;
    private Date fechaFin;
    private P tipo;

    public Promocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, P tipo) {
        this.estado = estado;
        if (this.fechaValida(fechaInicio, fechaFin)) {
            this.fechaInicio = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
            this.fechaFin = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } else {
            throw new RuntimeException("Las fechas de la promocion no son validas." + fechaInicio + "|||||" + fechaFin);
        }
        this.tipo = tipo;
    }

    public void setEstado() {
        this.estado = !this.estado;
    }

    public boolean fechaValida(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate hoy = LocalDate.now();
        return (fechaInicio.isBefore(hoy) && fechaFin.isAfter(hoy) && fechaInicio.isBefore(fechaFin));
    }


    public abstract double getDescuento() ;

    @Override
    public String toString() {
        return "Datos" + " {" +
                "estado=" + estado +
                ", fechaInicio=" + fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                ", fechaFin=" + fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                '}';
    }


}


