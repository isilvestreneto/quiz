package fr.capflix.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.capflix.quiz.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
	
}
