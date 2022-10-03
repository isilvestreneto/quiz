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

import fr.capflix.quiz.model.Pergunta;
import fr.capflix.quiz.service.PerguntaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("perguntas")
@Api(value = "API Rest Perguntas")
@CrossOrigin(origins = "*")
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;

	@GetMapping
	@ApiOperation(value = "Retorna lista de perguntas")
	public ResponseEntity<List<Pergunta>> list() {
		return ResponseEntity.ok(perguntaService.findAll());
	}

	@ApiOperation(value = "Retorna pergunta por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Pergunta> findById(@PathVariable Long id) {

		return ResponseEntity.ok(perguntaService.findById(id));

	}

	@ApiOperation(value = "Cria uma pergunta")
	@PostMapping
	public ResponseEntity<Pergunta> save(@RequestBody Pergunta pergunta) {

		return new ResponseEntity<>(perguntaService.save(pergunta), HttpStatus.CREATED);

	}

	@ApiOperation(value = "Deleta pergunta")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		perguntaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Atualiza pergunta")
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody Pergunta pergunta) {

		perguntaService.replace(pergunta);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
