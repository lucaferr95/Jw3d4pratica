import Dao.EventoDAO;
import Dao.LocationDAO;
import Dao.PartecipazioneDAO;
import Dao.PersonaDAO;
import Entities.*;
import Enumeration.Sesso;
import Enumeration.Stato;
import Enumeration.tipoEvento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        EventoDAO eventoDAO = new EventoDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        Random random = new Random();

        Location location = new Location(random.nextInt(1000, 9999), "Cimitero Monumentale", "Milano");
        locationDAO.aggLocation(location);

        Evento evento = new Evento(
                random.nextInt(1000, 9999),
                "MyFuneral",
                LocalDate.of(2028, 8, 22),
                "Ultimo saluto a Luca",
                13,
                tipoEvento.PRIVATO
        );
        evento.setLocation(location);
        eventoDAO.creaEvento(evento);

        List<String> nomiInvitati = List.of(
                "Marco", "Pier", "Ioan", "Madda", "BarNara", "Jaslin", "Silvia",
                "Anna", "Salvatore", "Dario", "Vincenzo", "Stefano", "TopoGigio"
        );

        for (String nome : nomiInvitati) {
            Persona persona = new Persona(
                    random.nextInt(1000, 9999),
                    nome,
                    "Cognome",
                    nome.toLowerCase() + "@email.com",
                    LocalDate.of(1990, 1, 1),
                    Sesso.M,
                    new ArrayList<>()
            );

            personaDAO.aggPersona(persona);

            Partecipazione partecipazione = new Partecipazione(
                    random.nextInt(1000, 9999),
                    persona,
                    evento,
                    Stato.CONFERMATA
            );

            partecipazioneDAO.aggPartecipazione(partecipazione);
        }

        System.out.println("Evento 'MyFuneral' e invitati salvati con successo.");
    }
}
