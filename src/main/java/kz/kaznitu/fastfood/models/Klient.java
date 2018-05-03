package kz.kaznitu.fastfood.models;

import javax.persistence.*;

@Entity
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long klientId;


    @ManyToOne
    private Server server;

    public Klient() {
    }

    public Klient(Server server) {
        this.server = server;
    }

    public Long getKlientId() {
        return klientId;
    }

    public void setKlientId(Long klientId) {
        this.klientId = klientId;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
