package Entities;

import Enumeration.tipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_evento", discriminatorType = DiscriminatorType.STRING)

@Entity
public abstract class Evento {

    @Id
    @GeneratedValue
    private int id;

    private String titolo;
    private LocalDate dataEvento;
    private String descrizione;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(length = 13)
    private int maxInvitati;

    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Partecipazione> partecipazioneList = new ArrayList<>();

    public Evento() {}

    public Evento(String titolo, LocalDate dataEvento, String descrizione, int maxInvitati, tipoEvento tipoEvento) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.maxInvitati = maxInvitati;
        this.tipoEvento = tipoEvento;
    }

    // Getter e Setter

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazioneList() {
        return partecipazioneList;
    }

    public void setPartecipazioneList(List<Partecipazione> partecipazioneList) {
        this.partecipazioneList = partecipazioneList;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", maxInvitati=" + maxInvitati +
                ", tipoEvento=" + tipoEvento +
                ", location=" + location +
                ", partecipazioni=" + partecipazioneList +
                '}';
    }
}
