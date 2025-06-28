package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Cliente;

import java.util.List;

public class ClienteJPA {
    private EntityManager em;

    public ClienteJPA() {
        em = ConfigJPA.getEntityManager();
    }

    public List<Cliente> listarClientes() {
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }

    public void guardarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
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
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.ciudad = :ciudad", Cliente.class);
        query.setParameter("ciudad", ciudad);
        return query.getResultList();
    }
}
