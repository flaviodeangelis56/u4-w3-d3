package flaviodeangelis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    long id;
    private String nome;
    private String città;
    @OneToMany(mappedBy = "location")
    private List<Evento> evento;

    public Location() {
    }

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                ", evento=" + evento +
                '}';
    }
}
