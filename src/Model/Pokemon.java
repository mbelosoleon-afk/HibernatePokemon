package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    String nome;

    @Column(name = "nacemento")
    Date nacemento;

    @OneToOne
    @JoinColumn(name = "pokedexentry")
    Pokedex pokedexentry;

    @ManyToOne
    @JoinColumn(name = "adestrador")
    Adestrador adestrador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    public Pokedex getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(Pokedex pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pokemon() {
    }

    public Pokemon(String nome, Date nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }
}
