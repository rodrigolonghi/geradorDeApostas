package rlonghi.geradorDeApostas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tbl_aposta")
public class Aposta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String jogo;

    @Column(nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant momento;

    @ManyToOne
    @JoinColumn(name = "id_apostador")
    @JsonIgnore
    private Apostador apostador;

    public Aposta(){
    }

    public Aposta(Long id, String jogo, Instant momento, Apostador apostador) {
        this.id = id;
        this.jogo = jogo;
        this.momento = momento;
        this.apostador = apostador;
    }

    public Long getId() {
        return id;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Apostador getApostador() {
        return apostador;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aposta)) return false;
        Aposta aposta = (Aposta) o;
        return getId().equals(aposta.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
