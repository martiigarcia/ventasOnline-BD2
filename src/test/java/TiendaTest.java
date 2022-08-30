
import modelo2.Categoria;
import modelo2.Cliente;
import modelo2.Marca;
import modelo2.Producto;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test ;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {



    @Test
   public void crearCliente(){
        Cliente cliente = new Cliente("Martina", "Garcia", "56784252", "marti@gmai.com");
    }
    @Test
    public void crearProducto(){
        Marca marca = new Marca("Frutiloqui");
        Categoria categoria = new Categoria("frutas");
        Producto producto = new Producto(1, "manzana", categoria, 34, marca);
    }

    @Test
    public void descuentoDeProducto(){

    }

    @Test
    public void descuentoDeCompra(){

    }

    @Test
    public void descuentoDeProductosYCompra(){

    }

    @Test
    public void descuentosCaducados(){

    }

    @Test
    public void registrarVenta(){

    }

    @Test
    public void registrarDescuentoNuevo(){

    }




}