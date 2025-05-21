package Dao;

import Entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EventoDAO {
    private EntityManager em;

    public EventoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres");
        em = emf.createEntityManager();
    }

     //Metodo per aggiungere uno studente

    public void creaEvento(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        System.out.println("Evento creato: " + evento);
    }

    //Metodo getbyid

    public Evento getById(int id) {
        return em.find(Evento.class, id);
    }

    //metodo remove

    public void remove(Evento evento) {
        //se non trova uno studente ritornerà null
        Evento ev= getById(evento.getId());

        if(ev!=null) {
            em.getTransaction().begin();
            em.remove(ev);
            em.getTransaction().commit();
    }
}}