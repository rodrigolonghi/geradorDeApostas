package rlonghi.geradorDeApostas.service;

import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;

public interface ApostaService {

    void salvar(Aposta aposta);

    void deletar(Long id);

    Aposta novaAposta(Apostador apostador);
}
