package fr.capflix.quiz.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import fr.capflix.quiz.dto.ProvaDTO;
import fr.capflix.quiz.model.Prova;
import fr.capflix.quiz.repository.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository provaRepository;

	ModelMapper mapper = new ModelMapper();

	public Iterable<Prova> getProvasByAssunto(String assunto) {

		return provaRepository.findByAssunto(assunto.toLowerCase());
	}

	public Prova save(ProvaDTO prova) {

		prova.getAssunto().toLowerCase();
		Prova teste = mapper.map(prova, Prova.class);

		return provaRepository.save(teste);
	}

	public void delete(Long id) {

		provaRepository.delete(findById(id));
	}

	public Prova findById(@PathVariable Long id) {

		return findAll().stream().filter(pergunta -> pergunta.getProvaId().equals(id)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Pergunta não encontrada"));
	}

	public List<Prova> findAll() {
		return provaRepository.findAll();
	}

}
