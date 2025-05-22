package Dao;

import Entities.Concerto;
import Entities.Evento;
import Entities.PartitaDiCalcio;
import Entities.Persona;
import Enumeration.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;


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
        Evento ev = getById(evento.getId());

        if (ev != null) {
            em.getTransaction().begin();
            em.remove(ev);
            em.getTransaction().commit();
        }
    }
        public List<Concerto> getConcertiInStreaming ( boolean inStreaming){
            TypedQuery<Concerto> query = em.createQuery("select c from Concerto c where c.inStreaming=:inStreaming", Concerto.class);
            query.setParameter("inStreaming", inStreaming);
            //query.getResultList per eseguire ed estrarre dal risultato la lista delle persone
            return query.getResultList();
        }
        public List<Concerto> getConcertiPerGenere (Genere genere){
            TypedQuery<Concerto> query = em.createQuery("select c from Concerto c where c.genere=:genere", Concerto.class);
            query.setParameter("genere", genere);
            //query.getResultList per eseguire ed estrarre dal risultato la lista delle persone
            return query.getResultList();
        }
    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.vinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.vinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }

}

