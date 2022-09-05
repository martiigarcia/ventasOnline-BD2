package servicios;

import api.ClienteServicio;
import modelo.Cliente;
import modelo.Tarjeta;
import modelo.TipoTarjeta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClienteService implements ClienteServicio {

    private String consultaCrear = "SELECT c FROM Cliente c WHERE c.dni = '";
    private String consultaBuscarId = "SELECT c FROM Cliente c WHERE c.id =";

    @Override
    public void crearCliente(String nombre, String apellido, String dni, String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cliente> clientes;
        try {
            tx.begin();

            // hay que validar que el dni no este registrado ya

            TypedQuery<Cliente> q = em.createQuery(consultaCrear + dni + "'", Cliente.class);
            clientes = q.getResultList();
            if (!clientes.isEmpty())
                throw new RuntimeException("El cliente ya se encuentra registrado");

            Cliente cliente = new Cliente(nombre, apellido, dni, email);
            em.persist(cliente);

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
    public void modificarCliente(Long idCliente, String nombre, String apellido, String dni, String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cliente> clientes;
        try {
            tx.begin();

            // hay que validar que el dni no este registrado ya

            TypedQuery<Cliente> q = em.createQuery(consultaBuscarId + idCliente, Cliente.class);
            clientes = q.getResultList();


            if (clientes.isEmpty())
                throw new RuntimeException("El cliente no esta registrado");

            Cliente cliente = em.getReference(Cliente.class, idCliente);
            cliente.setNombre(nombre);
            cliente.setDni(dni);
            cliente.setApellido(apellido);
            cliente.setEmail(email);

            em.persist(cliente);

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
    public void agregarTarjeta(Long idCliente, String numero, String marca) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cliente> clientes;
        try {
            tx.begin();

            // hay que validar que el dni no este registrado ya

            TypedQuery<Cliente> q = em.createQuery(consultaBuscarId + idCliente, Cliente.class);
            clientes = q.getResultList();


            if (clientes.isEmpty())
                throw new RuntimeException("El cliente no esta registrado");

            Cliente cliente = em.getReference(Cliente.class, idCliente);
            cliente.agregarTarjeta(new Tarjeta(Integer.parseInt(numero), TipoTarjeta.valueOf(marca.toUpperCase())));


            em.persist(cliente);

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
    public List listarTarjetas(Long idCliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cliente> clientes = new ArrayList<>();
        List<Tarjeta> tarjetas = new ArrayList<>();
        try {
            tx.begin();

            TypedQuery<Cliente> q = em.createQuery(consultaBuscarId + idCliente, Cliente.class);
            clientes = q.getResultList();


            if (clientes.isEmpty())
                throw new RuntimeException("El cliente no esta registrado");

            Cliente cliente = em.getReference(Cliente.class, idCliente);
            tarjetas = cliente.getTarjetas();


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
        return tarjetas;
    }
}
