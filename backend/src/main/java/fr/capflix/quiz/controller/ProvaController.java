package fr.capflix.quiz.controller;

import fr.capflix.quiz.dto.ProvaDTO;
import fr.capflix.quiz.model.Prova;
import fr.capflix.quiz.service.ProvaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/provas")
@Api(value = "API Rest Provas")
@CrossOrigin(origins = "*")
public class ProvaController {

    @Autowired
    private ProvaService provaService;

    @GetMapping
    @ApiOperation(value = "Retorna lista de provas")
    public ResponseEntity<List<Prova>> getProvas() {
        return ResponseEntity.ok(provaService.findAll());
    }

    @GetMapping(value = "/{assunto}")
    @ApiOperation(value = "Retorna lista de provas por ASSUNTO")
    public ResponseEntity<List<ProvaDTO>> getProvasByAssunto(@PathVariable("assunto") String assunto) {
        List<ProvaDTO> provas = provaService.getProvasByAssunto(assunto);

        return provas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(provas);

    }

    @ApiOperation(value = "Cria uma prova")
    @PostMapping
    public ResponseEntity<Prova> post(@RequestBody ProvaDTO prova) {



        try {;
            URI location = getUri(provaService.insert(prova).getProvaId());
            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
        // return new ResponseEntity<>(provaService.save(prova), HttpStatus.CREATED);

    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @ApiOperation(value = "Deleta prova")
    @DeleteMapping("/provas")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        provaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Atualiza prova")
    @PutMapping("/provas")
    public Prova atualizarPersonagem(@RequestBody ProvaDTO prova) {
        return provaService.save(prova);
    }

}
