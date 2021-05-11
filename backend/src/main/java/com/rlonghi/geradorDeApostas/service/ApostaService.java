package com.rlonghi.geradorDeApostas.service;

import com.rlonghi.geradorDeApostas.domain.Aposta;
import com.rlonghi.geradorDeApostas.domain.Apostador;

public interface ApostaService {

    void salvar(Aposta aposta);

    void deletar(Long id);

    Aposta novaAposta(Apostador apostador);
}
