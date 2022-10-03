package fr.capflix.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import fr.capflix.quiz.model.Pergunta;
import fr.capflix.quiz.repository.PerguntaRepository;

@Service
public class PerguntaService {

	@Autowired
	private PerguntaRepository perguntaRepository;

	public List<Pergunta> findAll() {

		return perguntaRepository.findAll();
	}

	public Pergunta findById(@PathVariable Long id) {

		return findAll().stream().filter(pergunta -> pergunta.getPerguntaId().equals(id)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Pergunta não encontrada"));
	}

	public Pergunta save(Pergunta pergunta) {
		pergunta.setPerguntaId(null);
		return perguntaRepository.save(pergunta);
	}

	public void delete(Long id) {

		perguntaRepository.delete(findById(id));

	}

	public void replace(Pergunta pergunta) {

		perguntaRepository.save(pergunta);

	}

}
