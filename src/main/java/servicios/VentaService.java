package servicios;

import api.VentaServicio;
import modelo.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class VentaService implements VentaServicio {
    @Override
    public void realizarVenta(Long idCliente, List<Long> productosLong, Long idTarjeta) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Producto> productosX = new ArrayList<>();
        try {
            tx.begin();


            // validaciones:
            // - debe ser un cliente existente
            // - la lista de productos no debe estar vacía
            // - La tarjeta debe pertenecer al cliente

            Carrito carrito = new Carrito();
            Cliente cliente = em.find(Cliente.class, idCliente);
            if (cliente == null)
                throw new RuntimeException("El cliente no esta registrado.");
            Tarjeta tarjeta = em.find(Tarjeta.class, idTarjeta);
            if (tarjeta == null)
                throw new RuntimeException("La tarjeta no existe");
            if (!cliente.tarjetaPropia(tarjeta))
                throw new RuntimeException("La tarjeta solicitada no pertenece al cliente");

            for (Long producto : productosLong) {
                Producto producto1 = em.find(Producto.class, producto);
                if (producto1 == null)
                    throw new RuntimeException("El producto no esta registrado.");
                productosX.add(producto1);
            }
            if (productosX.isEmpty())
                throw new RuntimeException("La lista de productos es vacia.");
            for (Producto producto : productosX) {
                carrito.agregarProductoAlCarrito(producto);
            }

            Tienda tienda = em.find(Tienda.class, 13);
            Venta venta = carrito.pagar(cliente, tienda.MarcaPromocionVigente(), tienda.TarjetaPromocionVigente(), tarjeta);
            tienda.agregarVenta(venta);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException(e);

        } finally {
            if (em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }

    @Override
    public float calcularMonto(List<Long> productosLong, Long idTarjeta) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Producto> productosX = new ArrayList<>();
        float montoFinal = 0;
        Cliente cliente;
        try {

            tx.begin();

            //Devuelve el monto total aplicando los descuentos al día de la fecha
            // validar que no llegue una lista vacía y la tarjeta exista
            Carrito carrito = new Carrito();

            Tarjeta tarjeta = em.find(Tarjeta.class, idTarjeta);
            if (tarjeta == null)
                throw new RuntimeException("La tarjeta no existe");

            for (Long producto : productosLong) {
                Producto producto1 = em.find(Producto.class, producto);
                if (producto1 == null)
                    throw new RuntimeException("El producto no esta registrado.");
                productosX.add(producto1);
            }
            if (productosX.isEmpty())
                throw new RuntimeException("La lista de productos es vacia.");
            for (Producto producto : productosX) {
                carrito.agregarProductoAlCarrito(producto);
            }

            Tienda tienda = em.find(Tienda.class, 13);
            montoFinal = (float) carrito.calcularMontoCarrito(tienda.MarcaPromocionVigente(), tienda.TarjetaPromocionVigente(), tarjeta);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException(e);

        } finally {
            if (em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
        return montoFinal;
    }

    @Override
    public List<Venta> ventas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Venta> ventas = new ArrayList<>();
        try {
            tx.begin();

            TypedQuery<Venta> qv = em.createQuery("select v from Venta v", Venta.class);
            ventas = qv.getResultList();
            if (ventas.isEmpty())
                throw new RuntimeException("No hay ventas registradas.");

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException(e);

        } finally {
            if (em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
        return ventas;
    }
}

