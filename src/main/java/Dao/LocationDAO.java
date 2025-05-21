package Dao;

import Entities.Location;
import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres");
        em = emf.createEntityManager();
    }

    //Metodo per aggiungere uno studente

    public void aggLocation (Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
        System.out.println("Location aggiunta " + location);
    }

    //Metodo getbyid

    public Location getById(int id) {
        return em.find(Location.class, id);
    }

    //metodo remove

    public void remove(Location location) {
        //se non trova uno studente ritornerà null
        Location loc= getById(location.getId());

        if(loc!=null) {
            em.getTransaction().begin();
            em.remove(loc);
            em.getTransaction().commit();
        }
    }
}
