package fr.capflix.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import fr.capflix.quiz.repository.PerguntaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/perguntas")
@Api(value = "API Rest Perguntas")
@CrossOrigin(origins = "*")
public class PerguntaController {
	
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@GetMapping
	@ApiOperation(value = "Retorna lista de perguntas")
	public List<Pergunta> findAll(){
		return perguntaRepository.findAll();
	}
	
	@ApiOperation(value = "Retorna perguntas por ID")
	@GetMapping(value="/{id}")
	public Optional<Pergunta> findById(@PathVariable("id") Long perguntaId) {
		return perguntaRepository.findById(perguntaId);
	}
	
	@ApiOperation(value = "Cria uma pergunta")
	@PostMapping
	public Pergunta adicionar(@RequestBody Pergunta pergunta) {

		return perguntaRepository.save(pergunta);

	}

	@ApiOperation(value = "Deleta pergunta")
	@DeleteMapping
	public void deletarPersonagem(@RequestBody Pergunta personagem) {
		perguntaRepository.delete(personagem);
	}

	@ApiOperation(value = "Atualiza personagem")
	@PutMapping("/perguntas")
	public Pergunta atualizarPersonagem(@RequestBody Pergunta personagem) {
		return perguntaRepository.save(personagem);
	}
	
	

}
