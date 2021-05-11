package com.rlonghi.geradorDeApostas.dao;

import java.util.List;

import com.rlonghi.geradorDeApostas.domain.Apostador;

public interface ApostadorDao {

    void salvar(Apostador apostador);

    void atualizar(Apostador apostador);

    void deletar(Long id);

    Apostador buscarPorEmail(String email);

    List<Apostador> buscarTodos();
}
