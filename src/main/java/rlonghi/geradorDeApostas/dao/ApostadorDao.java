package rlonghi.geradorDeApostas.dao;

import rlonghi.geradorDeApostas.domain.Apostador;

import java.util.List;

public interface ApostadorDao {

    void salvar(Apostador apostador);

    void atualizar(Apostador apostador);

    void deletar(Long id);

    Apostador buscarPorEmail(String email);

    List<Apostador> buscarTodos();
}
