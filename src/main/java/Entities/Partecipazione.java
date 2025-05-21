package Entities;

import Enumeration.Stato;
import jakarta.persistence.*;

@Entity

public class Partecipazione {
    @Id
    private int id;


    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento ev;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToOne
    @JoinColumn(name= "persona_id")
    private Persona p;

    public Partecipazione(){}
    public Partecipazione(int id, Persona p, Evento ev, Stato stato) {
        this.id = id;
        this.p = p;
        this.ev = ev;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public Evento getEv() {
        return ev;
    }

    public void setEv(Evento ev) {
        this.ev = ev;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", p=" + p +
                ", ev=" + ev +
                ", stato=" + stato +
                '}';
    }
}
