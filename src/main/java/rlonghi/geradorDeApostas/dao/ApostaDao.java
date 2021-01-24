package rlonghi.geradorDeApostas.dao;

import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;

public interface ApostaDao {

    void salvar(Aposta aposta);

    void deletar(Long id);
}
