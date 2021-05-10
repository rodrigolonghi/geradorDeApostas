package rlonghi.geradorDeApostas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlonghi.geradorDeApostas.dao.ApostaDao;
import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ApostaServiceImpl implements ApostaService {

    @Autowired
    private ApostaDao dao;

    @Override
    public void salvar(Aposta aposta) {
        dao.salvar(aposta);
    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }

    @Override
    public Aposta novaAposta(Apostador apostador) {
        boolean apostaRepetida = true;
        Random gerador = new Random();
        List<Integer> aux = new ArrayList<>();
        String jogo = "";

        while (apostaRepetida) {
            for (int i = 0; i < 6; i++) {
                Integer n = gerador.nextInt(60) + 1;
                while (aux.contains(n)) {
                    n = gerador.nextInt(60) + 1;
                }
                aux.add(n);
            }
            Collections.sort(aux);

            for (int i = 0; i < 6; i++) {
                jogo += aux.get(i).toString() + " ";
            }
            jogo = jogo.trim();

            if(!apostador.getApostas().isEmpty()) {
                for (Aposta a : apostador.getApostas()) {
                    if (a.getJogo().equals(jogo)) {
                        apostaRepetida = true;
                        break;
                    } else {
                        apostaRepetida = false;
                    }
                }
            }else{
                apostaRepetida = false;
            }
        }
        Aposta aposta = new Aposta(null, jogo, Instant.now(), apostador);
        dao.salvar(aposta);
        return aposta;
    }
}
