package com.rlonghi.geradorDeApostas.resource.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rlonghi.geradorDeApostas.domain.Aposta;
import com.rlonghi.geradorDeApostas.domain.Apostador;
import com.rlonghi.geradorDeApostas.exception.NaoExisteDaoException;
import com.rlonghi.geradorDeApostas.service.ApostaService;
import com.rlonghi.geradorDeApostas.service.ApostadorService;

@RestController
@RequestMapping(value = "/apostadores")
public class ApostadorRestController {

    @Autowired
    private ApostadorService apostadorService;

    @Autowired
    private ApostaService apostaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Apostador> listarTodos() {
        return apostadorService.buscarTodos();
    }

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public List<Aposta> listarUnico(@PathVariable String email) {
        if (apostadorService.buscarPorEmail(email) == null) {
            throw new NaoExisteDaoException("Apostador não encontrado");
        }
        return apostadorService.buscarApostas(apostadorService.buscarPorEmail(email));
    }

    @PostMapping
    public ResponseEntity<Void> criarApostador(@RequestBody Apostador apostador) {
        apostadorService.salvar(apostador);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(apostador.getEmail())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping(value = "/{email}/nova-aposta")
    @ResponseStatus(HttpStatus.OK)
    public Aposta novaAposta(@PathVariable String email) {
        Apostador apostador = apostadorService.buscarPorEmail(email);
        if (apostador == null) {
            throw new NaoExisteDaoException("Apostador não encontrado");
        }
        return apostaService.novaAposta(apostador);
    }

    @PatchMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Apostador atualizarEmail(@PathVariable String email, @RequestBody Apostador apostador) {
        Apostador a = apostadorService.buscarPorEmail(email);
        if (a == null) {
            throw new NaoExisteDaoException("Apostador não encontrado");
        }
        apostadorService.atualizar(apostador.getEmail(), apostadorService.buscarPorEmail(email));
        return apostadorService.buscarPorEmail(apostador.getEmail());
    }

    @DeleteMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String email) {
        Apostador apostador = apostadorService.buscarPorEmail(email);
        if (apostador == null) {
            throw new NaoExisteDaoException("Apostador não encontrado");
        }
        apostadorService.deletar(apostador.getId());
    }
}
