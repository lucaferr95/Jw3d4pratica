package Entities;

import Entities.Persona;
import Enumeration.tipoEvento;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

import java.time.LocalDate;

@Entity
public class Eventi {
    @Id
    private int id;
    private String titolo;
    private LocalDate dataEvento;
    private String descrizione;

    @Column(length = 13)
    private int maxInvitati;

    @Enumerated (EnumType.STRING)
    tipoEvento tipoEvento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Persona> personaList = new ArrayList<>();

    public Eventi() {}

    public Eventi(int maxInvitati) {

        this.maxInvitati = maxInvitati;
    }

    public Eventi(int id, String titolo, LocalDate dataEvento, String descrizione, int maxInvitati, tipoEvento tipoEvento) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.maxInvitati = maxInvitati;
        this.tipoEvento = tipoEvento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getMaxInvitati() {
        return maxInvitati;
    }

    public void setMaxInvitati(int maxInvitati) {
        this.maxInvitati = maxInvitati;
    }

    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public void aggiungiInvitato(Invitato invitato) {
        if (invitati.size() < maxInvitati) {
            invitati.add(invitato);
        } else {
            System.out.println("Raggiunto il numero massimo di invitati.");
        }
    }
    public void rimuoviInvitatoPerNome(String nome) {
        boolean rimosso = invitati.removeIf(i -> i.getNome().equalsIgnoreCase(nome));
        if (rimosso) {
            System.out.println(nome + " rimosso");
        } else {
            System.out.println(nome + " non trovato nella lista degli invitati.");
        }
    }




    @Override
    public String toString() {
        return "Eventi{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", maxInvitati=" + maxInvitati +
                ", tipoEvento=" + tipoEvento +
                ", invitati=" + invitati +
                '}';
    }

    public List<Persona> getInvitati() {
        return invitati;
    }

    public void setInvitati(List<Persona> invitati) {
    }
}

