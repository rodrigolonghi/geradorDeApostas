package com.rlonghi.geradorDeApostas.service;

import java.util.List;

import com.rlonghi.geradorDeApostas.domain.Aposta;
import com.rlonghi.geradorDeApostas.domain.Apostador;

public interface ApostadorService {

    void salvar(Apostador apostador);

    void atualizar(String email, Apostador apostador);

    void deletar(Long id);

    Apostador buscarPorEmail(String email);

    List<Apostador> buscarTodos();

    List<Aposta> buscarApostas(Apostador apostador);
}
