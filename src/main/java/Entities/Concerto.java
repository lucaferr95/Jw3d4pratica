package Entities;

import Enumeration.Genere;
import Enumeration.tipoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity

public class Concerto extends Evento{
    private boolean inStreaming;
    private Genere genere;


    public Concerto(){}
    public Concerto(String titolo, LocalDate dataEvento, String descrizione, int maxInvitati, tipoEvento tipoEvento, boolean inStreaming, Genere genere) {
        super(titolo, dataEvento, descrizione, maxInvitati, tipoEvento);
        this.inStreaming = inStreaming;
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "inStreaming=" + inStreaming +
                ", genere=" + genere +
                '}' + super.toString();
    }
}
