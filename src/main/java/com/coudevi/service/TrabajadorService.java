package com.coudevi.service;

import com.coudevi.model.Trabajador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TrabajadorService {
    // declaramos una fábrica de EntityManager para gestionar la persistencia
    private final EntityManagerFactory emf;

    // constructor para inicializar la factoria con la unidiad de persistencia
    public TrabajadorService() {
        this.emf = Persistence.createEntityManagerFactory("oneToOnePU");
    }

    public void crearTrabajador(Trabajador trabajador) {
        // EntityManager para interactuar con la base de datos
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(trabajador); // Guarda el objeto trabajador en la base de datos
            em.getTransaction().commit(); // Confirma los cambios en la base de datos
        } catch (Exception ex) {
            // Si hay un error, se revierte la transacción
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    public List<Trabajador> obtenerTrabajadores() {
        EntityManager em = emf.createEntityManager();
        try {
            // Se ejecuta una consulta JPQL para obtener todos los trabajadores con sus contratos
            return em.createQuery("SELECT t FROM Trabajador t LEFT JOIN FETCH t.contrato", Trabajador.class)
                    .getResultList();
        } finally {
            em.close(); // Se cierra el EntityManager
        }
    }

    public void  cerrar() {
        emf.close();
    }

}
