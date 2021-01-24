package rlonghi.geradorDeApostas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlonghi.geradorDeApostas.dao.ApostadorDao;
import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApostadorServiceImpl implements ApostadorService {

    @Autowired
    private ApostadorDao dao;

    @Override
    public void salvar(Apostador apostador) {
        Apostador a = dao.buscarPorEmail(apostador.getEmail());
        if (a == null) {
            dao.salvar(apostador);
        }
    }

    @Override
    public void atualizar(String email, Apostador apostador) {
        if (dao.buscarPorEmail(email) == null) {
            apostador.setEmail(email);
            dao.atualizar(apostador);
        }
    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }

    @Override
    public Apostador buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
    }

    @Override
    public List<Apostador> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public List<Aposta> buscarApostas(Apostador apostador) {
        return dao.buscarPorEmail(apostador.getEmail()).getApostas();
    }

}
