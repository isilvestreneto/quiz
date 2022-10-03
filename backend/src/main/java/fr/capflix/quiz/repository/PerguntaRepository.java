package fr.capflix.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.capflix.quiz.model.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
	

	
}
