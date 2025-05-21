import Dao.EventoDAO;
import Dao.LocationDAO;
import Dao.PartecipazioneDAO;
import Dao.PersonaDAO;
import Entities.Evento;
import Entities.Location;
import Entities.Partecipazione;
import Entities.Persona;
import Enumeration.Sesso;
import Enumeration.Stato;
import Enumeration.tipoEvento;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
        LocationDAO locationDAO = new LocationDAO();

        Evento funeral = new Evento(
                "MyFuneral",
                LocalDate.of(2028, 8, 22),
                "Ultimo saluto a Luca",
                15,
                tipoEvento.PRIVATO
        );
        eventoDAO.creaEvento(funeral);

        Location cimitero = new Location("Cimitero del Verano", "Roma");
        locationDAO.aggLocation(cimitero);

        funeral.setLocation(cimitero);
        eventoDAO.creaEvento(funeral);

        Persona marco = new Persona("Marco", "Verdi", "marco@email.com", LocalDate.of(1990, 1, 1), Sesso.M);
        Persona pier = new Persona("Pier", "Bianchi", "pier@email.com", LocalDate.of(1989, 5, 20), Sesso.M);
        Persona ioan = new Persona("Ioan", "Rossi", "ioan@email.com", LocalDate.of(1992, 11, 3), Sesso.M);
        Persona silvia = new Persona("Silvia", "Neri", "silvia@email.com", LocalDate.of(1991, 4, 10), Sesso.F);
        Persona jaslin = new Persona("Jaslin", "Kaur", "jaslin@email.com", LocalDate.of(1996, 6, 15), Sesso.F);
        Persona vincenzo = new Persona("Vincenzo", "De Luca", "vincenzo@email.com", LocalDate.of(1980, 3, 8), Sesso.M);
        Persona topoGigio = new Persona("Topo", "Gigio", "gigio@email.com", LocalDate.of(1960, 12, 1), Sesso.M);

        personaDAO.aggPersona(marco);
        personaDAO.aggPersona(pier);
        personaDAO.aggPersona(ioan);
        personaDAO.aggPersona(silvia);
        personaDAO.aggPersona(jaslin);
        personaDAO.aggPersona(vincenzo);
        personaDAO.aggPersona(topoGigio);

        Partecipazione part1 = new Partecipazione(Stato.CONFERMATO);
        part1.setEvento(funeral);
        part1.setPersona(marco);
        partecipazioneDAO.aggPartecipazione(part1);

        Partecipazione part2 = new Partecipazione(Stato.CONFERMATO);
        part2.setEvento(funeral);
        part2.setPersona(pier);
        partecipazioneDAO.aggPartecipazione(part2);

        Partecipazione part3 = new Partecipazione(Stato.CONFERMATO);
        part3.setEvento(funeral);
        part3.setPersona(ioan);
        partecipazioneDAO.aggPartecipazione(part3);

        Partecipazione part4 = new Partecipazione(Stato.CONFERMATO);
        part4.setEvento(funeral);
        part4.setPersona(silvia);
        partecipazioneDAO.aggPartecipazione(part4);

        Partecipazione part5 = new Partecipazione(Stato.DA_CONFERMARE);
        part5.setEvento(funeral);
        part5.setPersona(jaslin);
        partecipazioneDAO.aggPartecipazione(part5);

        Partecipazione part6 = new Partecipazione(Stato.CONFERMATO);
        part6.setEvento(funeral);
        part6.setPersona(vincenzo);
        partecipazioneDAO.aggPartecipazione(part6);

        Partecipazione part7 = new Partecipazione(Stato.CONFERMATO);
        part7.setEvento(funeral);
        part7.setPersona(topoGigio);
        partecipazioneDAO.aggPartecipazione(part7);
    }
}
