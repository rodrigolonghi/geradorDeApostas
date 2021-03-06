package com.rlonghi.geradorDeApostas.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_aposta")
public class Aposta implements Serializable {
	private static final long serialVersionUID = 1L;

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
