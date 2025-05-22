package Entities;

import Enumeration.tipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(
                name = "PartitaDiCalcio.vinteInCasa",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraCasa"
        ),
        @NamedQuery(
                name = "PartitaDiCalcio.vinteInTrasferta",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite"
        )
})
@Entity


@DiscriminatorValue("PartitaDiCalcio")
public class PartitaDiCalcio extends Evento {
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, int maxInvitati, tipoEvento tipoEvento, String squadraCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, maxInvitati, tipoEvento);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraCasa() {
        return numeroGolSquadraCasa;
    }

    public void setNumeroGolSquadraCasa(int numeroGolSquadraCasa) {
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraCasa=" + numeroGolSquadraCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                '}' + super.toString();
    }
}
