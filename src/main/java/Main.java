package Entities;

import java.time.LocalDate;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        EventoDAO dao = new EventoDAO();
        Random random = new Random();


        Eventi ev1 = new Eventi(new Random().nextInt(1, 10000), "MyFuneral", LocalDate.of(2028, 8, 22), "Ultimo saluto a Luca F", 13, tipoEvento.PRIVATO);
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Marco"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Pier"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Ioan"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Madda"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "BarNara"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Jaslin"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Silvia"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Anna"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Salvatore"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Dario"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Vincenzo"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Stefano"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "TopoGigio"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "Paperino"));
        ev1.aggiungiInvitato(new Persona(random.nextInt(1, 10000), "OrFisso"));

        System.out.println("Evento creato:\n" + ev1);
        ev1.rimuoviInvitatoPerNome("BarNara");
        System.out.println("Evento aggiornato:\n" + ev1);
        try{
        dao.creaevento(ev1);
    }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }}