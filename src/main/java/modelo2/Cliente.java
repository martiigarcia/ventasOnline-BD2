package modelo2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String apellido;
    private long dni;
    private String email;
    private List<Tarjeta> tarjetas;


    public Cliente(String nombre, String apellido, long dni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.tarjetas = new ArrayList<Tarjeta>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void agregarTarjeta(Tarjeta tarjeta){
        this.tarjetas.add(tarjeta);
    }


}
