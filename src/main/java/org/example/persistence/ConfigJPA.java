package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConfigJPA {

    private static final EntityManagerFactory emf;

    // Inicializamos el EntityManagerFactory una sola vez (singleton)
    static {
        emf = Persistence.createEntityManagerFactory("miUnidad");
    }

    // Metodo para obtener un EntityManager nuevo
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Metodo para cerrar el EntityManagerFactory cuando la aplicación termina
    public static void cerrar() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
