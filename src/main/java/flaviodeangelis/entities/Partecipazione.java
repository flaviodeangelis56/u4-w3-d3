package flaviodeangelis.entities;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    long id;
    String nomePersona;
    String nomeEvento;
    @Enumerated(EnumType.STRING)
    StatoPartecipazione stato;
    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    Evento evento;
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    Persona persona;

    public Partecipazione() {
    }

    public Partecipazione(String nomePersona, String nomeEvento, StatoPartecipazione stato, Evento evento, Persona persona) {
        this.nomePersona = nomePersona;
        this.nomeEvento = nomeEvento;
        this.stato = stato;
        this.evento = evento;
        this.persona = persona;
    }

    public long getId() {
        return id;
    }

    public String getPersona() {
        return nomePersona;
    }

    public void setPersona(String persona) {
        this.nomePersona = nomePersona;
    }

    public String getEvento() {
        return nomeEvento;
    }

    public void setEvento(String evento) {
        this.nomeEvento = nomeEvento;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", nomePersona='" + nomePersona + '\'' +
                ", nomeEvento='" + nomeEvento + '\'' +
                ", stato=" + stato +
                ", evento=" + evento +
                ", persona=" + persona +
                '}';
    }
}
