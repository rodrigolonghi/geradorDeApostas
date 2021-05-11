package com.rlonghi.geradorDeApostas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rlonghi.geradorDeApostas.dao.ApostadorDao;
import com.rlonghi.geradorDeApostas.domain.Aposta;
import com.rlonghi.geradorDeApostas.domain.Apostador;
import com.rlonghi.geradorDeApostas.exception.ApostadorRepeditoException;

@Service
@Transactional
public class ApostadorServiceImpl implements ApostadorService {

    @Autowired
    private ApostadorDao dao;

    @Override
    public void salvar(Apostador apostador) {
        if (dao.buscarPorEmail(apostador.getEmail()) != null) {
            throw new ApostadorRepeditoException("E-mail repetido.");
        }
        dao.salvar(apostador);
    }

    @Override
    public void atualizar(String email, Apostador apostador) {
        if (dao.buscarPorEmail(email) != null) {
            throw new ApostadorRepeditoException("E-mail repetido.");
        }
        apostador.setEmail(email);
        dao.atualizar(apostador);
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
