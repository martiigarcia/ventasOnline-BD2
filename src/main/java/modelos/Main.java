package modelos;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("martina", "garcia", 567842, "marti@gmai.com");
        Cliente cliente2 = new Cliente("emilia", "mernes", 658953, "emi@gmail.com");

        Tarjeta tarjeta1 = new Tarjeta(1, TipoTarjeta.MP);
        Tarjeta tarjeta2 = new Tarjeta(2, TipoTarjeta.MP);
        Tarjeta tarjeta3 = new Tarjeta(3, TipoTarjeta.UALA);

        cliente1.addTarjetas(tarjeta1);
        cliente1.addTarjetas(tarjeta2);
        cliente2.addTarjetas(tarjeta3);

        System.out.println("----------TARJETAS DE CLIENTES----------");
        System.out.println(cliente1.getNombre() + ":");
        cliente1.getTarjetas().forEach((p) -> {
            System.out.println(p.getNumero());
        });
        System.out.println(cliente2.getNombre() + ":");
        cliente2.getTarjetas().forEach((p) -> {
            System.out.println(p.getNumero());
        });
        System.out.println("----------PRODUCTOS----------");

        Marca marca1 = new Marca("Eco");
        Marca marca2 = new Marca("Frutiloqui");
        Categoria categoria1 = new Categoria("frutas");
        Producto producto1 = new Producto(1, "manzana", categoria1, 34, marca1);
        Producto producto2 = new Producto(1, "pera", categoria1, 6, marca2);

        cliente1.setCarrito(producto1);
        cliente1.setCarrito(producto2);
        cliente2.setCarrito(producto2);

        System.out.println(cliente1.getNombre() + ":");
        cliente1.getCarrito().getProductos().forEach((producto -> {
            System.out.println("- " + producto.getDescripcion() + ": " + producto.getPrecio());
        }));
        System.out.println(cliente2.getNombre() + ":");
        cliente2.getCarrito().getProductos().forEach((producto -> {
            System.out.println("- " + producto.getDescripcion() + ": " + producto.getPrecio());
        }));

        System.out.println("********* cambio en pera **********");
        producto2.setPrecio(4);
        cliente2.setCarrito(producto2);

        System.out.println("----------SUMA DE PRECIOS X CLIENTE----------");
        System.out.println(cliente1.getNombre() + " PRECIO (sin promo): " + cliente1.getCarrito().montoTotal());
        System.out.println(cliente2.getNombre() + " PRECIO (con promo): " + cliente2.getCarrito().montoTotal());

        //   Promocion<Promocion> promocion = new promoDeCompra();
        //  cliente1.getCarrito().montoTotal(promocion);


        System.out.println("----------Tienda: ----------");
        Tienda tienda = new Tienda();


        tienda.setPromocion(new promoDeCompra(true, LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 30), TipoTarjeta.MP));
        System.out.println(tienda.getPromocion());

        tienda.setPromocion(new promoDeProducto(true, LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 30), marca1));
        System.out.println(tienda.getPromocion());



        Scanner lectura = new Scanner(System.in);

        System.out.println("----------Seleccionar tarjeta: ----------");

        int indice = 0;
        for (Tarjeta tarjeta: cliente1.getTarjetas()) {
            System.out.println(indice+"- Numero de tarjeta: " + tarjeta.getNumero());
            indice++;
        }
        System.out.println("Elegir tarjeta: ");
        int opcion = lectura.nextInt();
        System.out.println("Opcion elegida: "+opcion+" - Numero de tarjeta: "+cliente1.getTarjetas().get(opcion).getNumero());

        Venta venta1 = new Venta(LocalDate.now(), cliente1.getCarrito(), cliente1);
        tienda.setVentaList(venta1);
        venta1.pagar(cliente1.getTarjetas().get(opcion));





















        /*System.out.println("----------Precio venta1: ----------");

        venta1.setMontoTotal(new promoDeCompra
                (true, LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 30), TipoTarjeta.MP));
        // System.out.println(venta1.getMontoTotal());
        venta1.setMontoTotal(new promoDeProducto(
                true, LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 30), marca1));
        //   System.out.println(venta1.getMontoTotal());

        venta1.setMontoTotal(tienda.getPromocion().get(0));
        System.out.println(venta1.getMontoTotal());

        venta1.pagar();
        System.out.println(cliente1.getCarrito());
        System.out.println(venta1);




        // ver validaciones de fechas de promociones
        // hacer una venta con una promocion
        // guardar las ventas en la tienda
        // calcular monto de cada venta
        // ver como se accede a cada parte (si calculo el precio desde la tienda o desde la venta o desde donde, como le paso promociones tmb)
        // ver como se paga, como se selecciona una tarjeta y/o promocion, como funciona el servicio de la tarjeta

*/
    }
}
