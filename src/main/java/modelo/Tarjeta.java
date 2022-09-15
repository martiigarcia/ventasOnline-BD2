package modelo;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

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
    public Tarjeta(long id, int numero, TipoTarjeta tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.id = id;
    }

    public TipoTarjeta tipoTarjeta(){
        return tipo;
    }

   /* public int getNumero() {
        return numero;
    }*/
   public Map<String, Object> toMap() {
       var map = new HashMap<String, Object>(
               Map.of("id", id, "numero", numero, "tipo", tipo));

       return map;
   }


    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero=" + numero +
                ", tipo=" + tipo.nombre() +
                '}';
    }
}
