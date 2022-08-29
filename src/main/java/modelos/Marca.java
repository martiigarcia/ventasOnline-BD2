package modelos;

import java.util.Objects;

public class Marca {
    private String nombre;

    public Marca (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(nombre, marca.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}