package fr.capflix.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.capflix.quiz.model.Prova;
import fr.capflix.quiz.repository.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository provaRepository;

	public List<Prova> encontrarPorAssunto(String assunto) {
		return provaRepository.encontrarPorAssunto(assunto);
	}

	public Prova save(Prova pergunta) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Prova prova) {
		// TODO Auto-generated method stub
		
	}


}
