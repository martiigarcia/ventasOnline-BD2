
import modelo2.Categoria;
import modelo2.Cliente;
import modelo2.Marca;
import modelo2.Producto;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test ;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoTest {


    @Test
    public void descuentoDeProducto(){
        // Calcular el monto total del carrito con un descuento vigente para los productos marca Acme.
    }

    @Test
    public void descuentoDeCompra(){
        // Calcular el monto total del carrito con un descuento vigente del tipo de Medio de pago.
    }

    @Test
    public void descuentoDeProductosYCompra(){
        // Calcular el monto total del carrito con dos descuentos vigentes,
        // sobre productos marca Comarca y para tarjeta de crédito MemeCard.
    }

    @Test
    public void descuentosCaducados(){
        // Calcular el monto total del carrito seleccionado sin descuentos vigentes, pero con descuentos que ya caducaron.
    }

    @Test
    public void pagarYRegistrarVenta(){
        // aca registrar la venta desde el pagar del carrito
    }






}