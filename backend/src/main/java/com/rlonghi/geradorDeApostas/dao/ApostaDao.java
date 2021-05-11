package com.rlonghi.geradorDeApostas.dao;

import com.rlonghi.geradorDeApostas.domain.Aposta;

public interface ApostaDao {

    void salvar(Aposta aposta);

    void deletar(Long id);
}
