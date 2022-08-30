package modelo2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Martina", "Garcia", 567842, "marti@gmai.com");
        Cliente cliente2 = new Cliente("Emilia", "Mernes", 658953, "emi@gmail.com");

        Tarjeta tarjeta1 = new Tarjeta(1, TipoTarjeta.MP);
        Tarjeta tarjeta2 = new Tarjeta(2, TipoTarjeta.UALA);
        Tarjeta tarjeta3 = new Tarjeta(3, TipoTarjeta.MP);

        cliente1.agregarTarjeta(tarjeta1);
        cliente1.agregarTarjeta(tarjeta2);
        cliente2.agregarTarjeta(tarjeta3);

        Marca marca1 = new Marca("Eco");
        Marca marca2 = new Marca("Frutiloqui");
        Categoria categoria1 = new Categoria("frutas");
        Producto producto1 = new Producto(1, "manzana", categoria1, 34, marca1);
        Producto producto2 = new Producto(1, "pera", categoria1, 6, marca2);

        Carrito carrito1 = new Carrito();
        Carrito carrito2 = new Carrito();

        carrito1.agregarProductoAlCarrito(producto1);
        carrito1.agregarProductoAlCarrito(producto2);
        carrito2.agregarProductoAlCarrito(producto2);


        Tienda tienda = new Tienda();

        tienda.setTarjetaPromocion(
                new TarjetaPromocion(true,
                        LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 30),
                        TipoTarjeta.MP));
        tienda.setMarcaPromocion(
                new MarcaPromocion(true,
                        LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 30),
                        marca1));


        Scanner lectura = new Scanner(System.in);

        System.out.println("----------Seleccionar tarjeta: ----------");

        int indice = 0;
        for (Tarjeta tarjeta : cliente1.getTarjetas()) {
            System.out.println(indice + "- Numero de tarjeta: " + tarjeta.getNumero() + " . Tipo tarjeta: " + tarjeta.tipoTarjeta());
            indice++;
        }
        System.out.println("Elegir tarjeta: ");
        int opcion = lectura.nextInt();
        System.out.println("Opcion elegida: " + opcion + " - Numero de tarjeta: " + cliente1.getTarjetas().get(opcion).getNumero());

        double precio = carrito1.calcularMontoCarrito(tienda.MarcaPromocion(), tienda.TarjetaPromocion(), cliente1.getTarjetas().get(opcion));
        System.out.println("Precio calculado con promociones de marca y tarjeta: " + precio);

        tienda.agregarVenta(carrito1.pagar(cliente1, cliente1.getTarjetas().get(opcion)));

        //probar agregar promocion a las listas de promociones
    }
}
