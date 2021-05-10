package rlonghi.geradorDeApostas.dao;

import org.springframework.stereotype.Repository;
import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Repository
public class ApostaDaoImpl implements ApostaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Aposta aposta) {
        em.persist(aposta);
    }

    @Override
    public void deletar(Long id) {
        em.remove(em.getReference(Aposta.class, id));
    }
}
