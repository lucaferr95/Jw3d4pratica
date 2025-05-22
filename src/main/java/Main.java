import Dao.EventoDAO;
import Dao.LocationDAO;
import Dao.PartecipazioneDAO;
import Dao.PersonaDAO;
import Entities.*;
import Enumeration.Genere;
import Enumeration.Sesso;
import Entities.Concerto;
import Enumeration.tipoEvento;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
        LocationDAO locationDAO = new LocationDAO();
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

        Location SanSiro = new Location("San Siro", "Milano");
        locationDAO.aggLocation(SanSiro);

        Concerto concerto= new Concerto("Marco Mengoni", LocalDate.of(2025, 6, 30),
                "Concerto Marco", 100000, tipoEvento.PUBBLICO, true, Genere.POP   );
        eventoDAO.creaEvento(concerto);

        Concerto concerto2= new Concerto("Adele", LocalDate.of(2025, 6, 30),
                "Concerto Adele", 300000, tipoEvento.PUBBLICO, true, Genere.POP   );
        eventoDAO.creaEvento(concerto);


        PartitaDiCalcio champions= new PartitaDiCalcio("Inter vs PSG", LocalDate.of(2025, 5, 30) ,
                "COMPLIMENTI ALL'INTER PER LA COPPA", 10000, tipoEvento.PUBBLICO, "Inter",
                "PSG", "Inter", 6, 1);
        eventoDAO.creaEvento(champions);

        Set<Persona> atleti = new HashSet<>();
        atleti.add(marco);
        atleti.add(pier);
        atleti.add(ioan);


        GaraDiAtletica gara = new GaraDiAtletica(
                "Corsa a chi cade prima malato",
                LocalDate.of(2025, 5, 5),
                "Gara a chi perde prima la salute col backend",
                40,
                tipoEvento.PUBBLICO,
                atleti,
                ioan
        );
        eventoDAO.creaEvento(gara);

        System.out.println("\nConcerti in streaming:");
        eventoDAO.getConcertiInStreaming(true).forEach(System.out::println);

        System.out.println("\nConcerti POP:");
        eventoDAO.getConcertiPerGenere(Genere.POP).forEach(System.out::println);



    }
}
