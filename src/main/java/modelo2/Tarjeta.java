package modelo2;

public class Tarjeta {

    private int numero;
    private TipoTarjeta tipo;


    public Tarjeta(int numero, TipoTarjeta tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public TipoTarjeta tipoTarjeta(){
        return tipo;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero=" + numero +
                ", tipo=" + tipo +
                '}';
    }
}
