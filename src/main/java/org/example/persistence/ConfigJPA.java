package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConfigJPA {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("miUnidad");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void cerrar() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
