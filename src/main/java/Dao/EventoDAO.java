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

    public void creaevento(Eventi evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        System.out.println("Evento creato: " + evento);
    }

    //Metodo getbyid

    public Eventi getById(int id) {
        return em.find(Eventi.class, id);
    }

    //metodo remove

    public void remove(Eventi eventi) {
        //se non trova uno studente ritornerà null
        Eventi ev= getById(eventi.getId());

        if(ev!=null) {
            em.getTransaction().begin();
            em.remove(ev);
            em.getTransaction().commit();
    }
}}