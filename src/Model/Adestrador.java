package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adestrador")
public class Adestrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nacemento")
    private Date nacemento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Adestrador(){

    }

    public Adestrador(String nome, Date nacemento){
        this.nome = nome;
        this.nacemento = nacemento;
    }

    public Adestrador(int id, String nome, Date nacemento){
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
    }
}