package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.entities.Cliente;

import java.util.List;

public class ClienteJPA {
    private EntityManager em;

    public ClienteJPA() {
        em = ConfigJPA.getEntityManager();
    }

    public void crearCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public List<Cliente> listarClientes() {
        Query query = em.createQuery("SELECT c FROM Cliente c");
        return (List<Cliente>) query.getResultList();
    }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    public void actualizarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public void eliminarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

    public List<Cliente> buscarPorCiudad(String ciudad) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.ciudad = :ciudad");
        query.setParameter("ciudad", ciudad);
        return (List<Cliente>) query.getResultList();
    }

    public void guardarCliente(Cliente cliente) {
    }
}
