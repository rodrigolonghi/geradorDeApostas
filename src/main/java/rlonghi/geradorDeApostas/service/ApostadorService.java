package rlonghi.geradorDeApostas.service;

import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;

import java.util.List;

public interface ApostadorService {

    void salvar(Apostador apostador);

    void atualizar(String email, Apostador apostador);

    void deletar(Long id);

    Apostador buscarPorEmail(String email);

    List<Apostador> buscarTodos();

    List<Aposta> buscarApostas(Apostador apostador);
}
