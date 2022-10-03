package fr.capflix.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.capflix.quiz.model.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Long> {
	
	@Query(value = "SELECT * FROM PROVAS WHERE ASSUNTO LIKE 'TECNOLOGIA'", nativeQuery = true)
	List<Prova> encontrarPorAssunto(String assunto);

}