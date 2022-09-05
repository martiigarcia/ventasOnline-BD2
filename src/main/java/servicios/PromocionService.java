package servicios;

import api.PromocionServicio;
import modelo.*;

import javax.persistence.*;
import java.time.LocalDate;

public class PromocionService implements PromocionServicio {
    @Override
    public void crearDescuentoSobreTotal(String marcaTarjeta, LocalDate fechaDesde, LocalDate fechaHasta, float porcentaje) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            // validar que las fechas no se superpongan

            Tienda tienda = em.find(Tienda.class, 13);
            tienda.setTarjetaPromocion(new TarjetaPromocion(true,
                    fechaDesde, fechaHasta, TipoTarjeta.valueOf((marcaTarjeta).toUpperCase())));
            System.out.println(tienda);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {
            if (em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }

    @Override
    public void crearDescuento(String marcaProducto, LocalDate fechaDesde, LocalDate fechaHasta, float porcentaje) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Marca marca;
        try {
            tx.begin();
            // validar que las fechas no se superpongan

            TypedQuery<Marca> qm = em.createQuery("select m from Marca m where m.nombre=:nombre", Marca.class);
            qm.setParameter("nombre", marcaProducto);
            marca = qm.getSingleResult();
            if (marca == null)
                throw new RuntimeException("La marca ingresada no existe.");

            Tienda tienda = em.find(Tienda.class, 13);
            tienda.setMarcaPromocion(new MarcaPromocion(true, fechaDesde, fechaHasta, marca));
            System.out.println(tienda);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {
            if (em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }

    }

    public void crearTienda() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Tienda tienda = new Tienda();
            em.persist(tienda);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {
            if (em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }
}
