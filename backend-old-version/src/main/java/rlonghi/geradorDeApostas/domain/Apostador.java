package rlonghi.geradorDeApostas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_apostador")
public class Apostador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "apostador", fetch = FetchType.EAGER)
    List<Aposta> apostas = new ArrayList<>();

    public Apostador() {
    }

    public Apostador(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apostador)) return false;
        Apostador apostador = (Apostador) o;
        return getId().equals(apostador.getId()) && getEmail().equals(apostador.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }
}
