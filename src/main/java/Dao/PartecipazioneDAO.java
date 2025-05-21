package Dao;

import Entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres");
        em = emf.createEntityManager();
    }

    public void aggPartecipazione(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
        System.out.println("Partecipazione aggiunta: " + partecipazione);
    }

    public Partecipazione getById(int id) {
        return em.find(Partecipazione.class, id);
    }

    public void remove(Partecipazione partecipazione) {
        Partecipazione part = getById(partecipazione.getId());
        if (part != null) {
            em.getTransaction().begin();
            em.remove(part);
            em.getTransaction().commit();
            System.out.println("Partecipazione rimossa: " + part);
        }
    }
}
