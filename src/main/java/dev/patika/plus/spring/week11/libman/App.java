package dev.patika.plus.spring.week11.libman;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        emf = jakarta.persistence.Persistence.createEntityManagerFactory("lib");

        EntityManager em = null;

        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }
}
