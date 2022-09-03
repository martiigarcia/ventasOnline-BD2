import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import modelo2.Cliente;

class ClienteTest {

    //todos los casos de prueba:
    public static Object[] parametros() {
        return new Object[][] {
                { "", "Garcia", "00000000", "mar@gmail.com" },  //sin nombre
                { "Marti", "", "00000000", "mar@gmail.com" },   //sin apellido
                { "Marti", "Garcia", "", "mar@gmail.com" },     //sin dni
                { "Marti", "Garcia", "00000000", "mar@gmail" }, //email invalido
                { "Marti", "Garcia", "00000000", "" },          //sin email
                { "Marti", "Garcia", "000", "mar@gmail.com" },  //dni invalido
        };
    }

    @ParameterizedTest
    @MethodSource("parametros")
    void crearCliente(String nombre, String apellido, String dni, String email) {
        assertThrows(RuntimeException.class, () -> new Cliente(nombre, apellido, dni, email));
    }

}


