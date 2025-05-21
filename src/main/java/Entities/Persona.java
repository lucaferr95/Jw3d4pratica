import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Persona {
    @Id
    private int id;
    private String nome;
    private String cognome;


    private String email;
    private String sesso;
    private List <partecipazioni>;
}