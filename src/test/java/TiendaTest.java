
import modelo2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    @Test
    public void registrarVenta() {
            // aca registrar venta en la tienda

        Tienda tienda = new Tienda();

        /*
        *

        tienda.setTarjetaPromocion(
                new TarjetaPromocion(true,
                        LocalDate.of(2022, 8, 29), LocalDate.of(2022, 8, 30),
                        TipoTarjeta.MP));

        tienda.setMarcaPromocion(
                new MarcaPromocion(true,
                        LocalDate.of(2022, 8, 30), LocalDate.of(2022, 9, 2),
                        marca1));

        *
        * */

    }

    @Test
    public void registrarPromocionNueva() {
            // aca registrar promocion en la tienda (probar con ambos tipos)
            // con fechas invalidas
    }


}