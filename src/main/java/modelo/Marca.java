package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Marca {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;

    public Marca (String nombre){
        this.nombre = nombre;
    }

    public Marca() {

    }


    @Override
    public String toString() {
        return "Marca:" + nombre + "id: "+ id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(nombre, marca.nombre);
    }

}