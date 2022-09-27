package fr.capflix.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.capflix.quiz.model.Pergunta;
import fr.capflix.quiz.repository.PerguntaRepository;

@Service
public class PerguntaService {

	@Autowired
	private PerguntaRepository perguntaRepository;

	public List<Pergunta> findAll() {
		
		return perguntaRepository.findAll();
	}

	public Pergunta findById(Long perguntaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
