package com.rlonghi.geradorDeApostas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rlonghi.geradorDeApostas.domain.Apostador;

@Repository
public class ApostadorDaoImpl implements ApostadorDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Apostador apostador) {
        em.persist(apostador);
    }

    @Override
    public void atualizar(Apostador apostador) {
        em.merge(apostador);
    }

    @Override
    public void deletar(Long id) {
        em.remove(em.getReference(Apostador.class, id));
    }

    @Override
    public Apostador buscarPorEmail(String email) {
        List<Apostador> apostadorList = buscarTodos();
        for(Apostador a : apostadorList){
            if(a.getEmail().equals(email)){
                return em.find(Apostador.class, a.getId());
            }
        }
        return null;
    }

    @Override
    public List<Apostador> buscarTodos() {
        return em
                .createQuery("select a from Apostador a", Apostador.class)
                .getResultList();
    }
}
