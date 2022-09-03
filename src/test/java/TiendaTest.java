
import modelo2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    private Tienda tienda;
    private Cliente cliente;
    private Tarjeta tarjeta;
    private Carrito carrito;
    private Marca marcaAcme, marcaEco, marcaFrutiloqui;
    private Categoria categoria, categoria2;
    private Producto producto1, producto2, producto3, producto4;



    @BeforeEach
    public void before() {

        tienda = new Tienda();
        carrito = new Carrito();

        cliente = new Cliente("Martina", "Garcia", "12345678", "marti@gmail.com");
        tarjeta = new Tarjeta(1111, TipoTarjeta.MP);

        marcaAcme = new Marca("Acme");
        marcaEco = new Marca("Eco");
        marcaFrutiloqui = new Marca("Frutiloqui");

        categoria = new Categoria("Cosmetico");
        categoria2 = new Categoria("Fruta");

        producto1 = new Producto(1, 100, "Labial", categoria, marcaAcme);
        producto2 = new Producto(2, 34, "Manzana", categoria2, marcaEco);
        producto3 = new Producto(3, 6, "Pera", categoria2, marcaFrutiloqui);
        producto4 = new Producto(4, 100, "Rimel", categoria, marcaAcme);

        carrito.agregarProductoAlCarrito(producto1);
        carrito.agregarProductoAlCarrito(producto2);
        carrito.agregarProductoAlCarrito(producto3);
        carrito.agregarProductoAlCarrito(producto4);

    }

    @Test
    public void registrarVenta() {
        // aca registrar venta en la tienda

        assertEquals(Venta.class, carrito.pagar(cliente,
                new MarcaPromocion(true,
                LocalDate.of(2022,9,2), LocalDate.of(2022,9,5), marcaAcme),
                new TarjetaPromocion(true,
                        LocalDate.of(2022,9,2), LocalDate.of(2022,9,5), TipoTarjeta.MP),
                tarjeta).getClass());

    }

    //REGISTRO DE PROMOCION CON FECHAS VALIDAS

    @Test
    public void registrarPromocionMarcaNueva() {
        // aca registrar promocion en la tienda (probar con ambos tipos)

        tienda.setMarcaPromocion(new MarcaPromocion(true,
                LocalDate.of(2022,9,2), LocalDate.of(2022,9,5), marcaAcme));

        assertEquals( 1, tienda.marcaPromocionList().size());

    }

    @Test
    public void registrarPromocionTarjetaNueva(){
        tienda.setTarjetaPromocion(new TarjetaPromocion(true,
                LocalDate.of(2022,9,2), LocalDate.of(2022,9,5), TipoTarjeta.MP));

        assertEquals( 1, tienda.tarjetaPromocionList().size());
    }


    //REGISTRO DE PROMOCION INVALIDAS
    @Test
    public void registrarPromocionMarcaNuevaConFechaInvalida() {
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setMarcaPromocion(new MarcaPromocion(true,
                LocalDate.of(2022,8,30), LocalDate.of(2022,9,1), marcaAcme)));

    }

    @Test
    public void registrarPromocionTarjetaNuevaConFechaInvalida(){
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setTarjetaPromocion(new TarjetaPromocion(true,
                LocalDate.of(2022,8,30), LocalDate.of(2022,9,1), TipoTarjeta.MP)));

    }

    @Test
    public void registrarPromocionMarcaNuevaVacia() {
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setMarcaPromocion(null));

    }

    @Test
    public void registrarPromocionTarjetaNuevaVacia(){
        //  intentar registrar promocion con una fecha de finalizacion previo al dia de hoy

        assertThrows(RuntimeException.class, () -> tienda.setTarjetaPromocion(null));

    }



}