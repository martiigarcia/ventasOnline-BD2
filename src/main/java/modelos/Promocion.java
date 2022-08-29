package modelos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class Promocion<P> {

    private boolean estado;
    private Date fechaInicio;
    private Date fechaFin;
    private P tipo;

    @Override
    public String toString() {
        return "Datos" + " {" +
                "estado=" + estado +
                ", fechaInicio=" + fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                ", fechaFin=" + fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                '}';
    }

    public Promocion(boolean estado, LocalDate fechaInicio, LocalDate fechaFin, P tipo) {
        this.estado = estado;
        if (this.fechaValida(fechaInicio, fechaFin)) {
            this.fechaInicio = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
            this.fechaFin = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        this.tipo = tipo;
    }

    public boolean fechaValida(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDate hoy = LocalDate.now();
        return (fechaInicio.isBefore(hoy) && fechaFin.isAfter(hoy) && fechaInicio.isBefore(fechaFin));
    }

    public abstract double calcularMontoCarrito(Carrito carrito);

    public double getDescuento() {
        return 0;
    }

    //setters y getters: verificar cual queda

    public P getTipo() {
        return tipo;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getFechaFin() {
        return fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }



}
/*

LocalDate inicio = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
LocalDate fin = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

* */