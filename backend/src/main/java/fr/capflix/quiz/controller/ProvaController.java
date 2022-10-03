package fr.capflix.quiz.controller;

import java.util.List;

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

import fr.capflix.quiz.model.Prova;
import fr.capflix.quiz.service.ProvaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("provas")
@Api(value = "API Rest Provas")
@CrossOrigin(origins = "*")
public class ProvaController {

	@Autowired
	private ProvaService provaService;

	@GetMapping(value="/{assunto}")
	@ApiOperation(value = "Retorna lista de provas por ID")
	public List<Prova> encontrarPorAssunto(@PathVariable String assunto) {
		return provaService.encontrarPorAssunto(assunto);
	}

	@ApiOperation(value = "Cria uma prova")
	@PostMapping
	public Prova adicionar(@RequestBody Prova pergunta) {

		return provaService.save(pergunta);

	}

	@ApiOperation(value = "Deleta pergunta")
	@DeleteMapping("/provas")
	public void deletarPersonagem(@RequestBody Prova prova) {
		provaService.delete(prova);
	}

	@ApiOperation(value = "Atualiza personagem")
	@PutMapping("/provas")
	public Prova atualizarPersonagem(@RequestBody Prova prova) {
		return provaService.save(prova);
	}

}
