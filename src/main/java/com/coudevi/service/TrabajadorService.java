package com.coudevi.service;

import com.coudevi.model.Trabajador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TrabajadorService {
    private final EntityManagerFactory emf;

    public TrabajadorService() {
        this.emf = Persistence.createEntityManagerFactory("oneToOnePU");
    }

    public void crearTrabajador(Trabajador trabajador) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(trabajador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Trabajador> obtenerTrabajadores() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Trabajador t LEFT JOIN FETCH t.contrato", Trabajador.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void  cerrar() {
        emf.close();
    }

}
