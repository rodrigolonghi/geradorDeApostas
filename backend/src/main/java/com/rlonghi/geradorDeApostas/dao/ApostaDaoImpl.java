package com.rlonghi.geradorDeApostas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rlonghi.geradorDeApostas.domain.Aposta;

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
