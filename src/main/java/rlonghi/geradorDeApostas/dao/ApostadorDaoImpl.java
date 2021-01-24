package rlonghi.geradorDeApostas.dao;

import org.springframework.stereotype.Repository;
import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
        em.remove(em.getReference(Aposta.class, id));
    }

    @Override
    public Apostador buscarPorEmail(String email) {
        return em.find(Apostador.class, email);
    }

    @Override
    public List<Apostador> buscarTodos() {
        return em
                .createQuery("select a from Apostador a", Apostador.class)
                .getResultList();
    }
}
