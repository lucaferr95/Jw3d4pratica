package Dao;

import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres");
        em = emf.createEntityManager();
    }

    //Metodo per aggiungere uno studente

    public void aggPersona (Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        System.out.println("Persona aggiunta " + persona);
    }

    //Metodo getbyid

    public Persona getById(int id) {
        return em.find(Persona.class, id);
    }

    //metodo remove

    public void remove(Persona persona) {
        //se non trova uno studente ritornerà null
        Persona p= getById(persona.getId());

        if(p!=null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
    }
}
