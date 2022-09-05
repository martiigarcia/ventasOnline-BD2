package modelo;

import javax.persistence.*;

@Entity
public class Tarjeta {

    @Id
    @GeneratedValue
    private long id;
    private int numero;
   // private TipoTarjeta tipo;
    @Enumerated(EnumType.ORDINAL) TipoTarjeta tipo;

    protected Tarjeta(){

    }

    public Tarjeta(int numero, TipoTarjeta tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public TipoTarjeta tipoTarjeta(){
        return tipo;
    }

   /* public int getNumero() {
        return numero;
    }*/



    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero=" + numero +
                ", tipo=" + tipo.nombre() +
                '}';
    }
}
