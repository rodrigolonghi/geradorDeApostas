package rlonghi.geradorDeApostas.resource.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rlonghi.geradorDeApostas.domain.Aposta;
import rlonghi.geradorDeApostas.domain.Apostador;
import rlonghi.geradorDeApostas.service.ApostaService;
import rlonghi.geradorDeApostas.service.ApostadorService;

import java.net.URI;
import java.util.List;

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
    public Aposta novaAposta(@PathVariable String email){
        Apostador apostador = apostadorService.buscarPorEmail(email);
        return apostaService.novaAposta(apostador);
    }

    @PatchMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Apostador atualizarEmail(@PathVariable String email, @RequestBody Apostador apostador){
        apostadorService.atualizar(apostador.getEmail(), apostadorService.buscarPorEmail(email));
        return apostadorService.buscarPorEmail(apostador.getEmail());
    }

    @DeleteMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String email){
        apostadorService.deletar(apostadorService.buscarPorEmail(email).getId());
    }
}
