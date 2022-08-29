package modelos;

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
}
