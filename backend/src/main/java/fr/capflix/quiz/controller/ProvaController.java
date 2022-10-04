package fr.capflix.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.capflix.quiz.dto.ProvaDTO;
import fr.capflix.quiz.model.Prova;
import fr.capflix.quiz.service.ProvaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	public ResponseEntity<Prova> getProvasByAssunto(@PathVariable("assunto") String assunto) {
		return new ResponseEntity<>(provaService.getProvasByAssunto(assunto), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Cria uma prova")
	@PostMapping
	public ResponseEntity<Prova> post(@RequestBody ProvaDTO prova) {

		return new ResponseEntity<>(provaService.save(prova), HttpStatus.CREATED);

	}

	@ApiOperation(value = "Deleta prova")
	@DeleteMapping("/provas")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		provaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Atualiza prova")
	@PutMapping("/provas")
	public Prova atualizarPersonagem(@RequestBody Prova prova) {
		return provaService.save(prova);
	}

}
