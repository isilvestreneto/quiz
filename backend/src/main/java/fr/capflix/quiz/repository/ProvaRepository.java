package fr.capflix.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.capflix.quiz.model.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Long> {
	
	//@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	@Query(value = "SELECT * FROM PROVAS WHERE ASSUNTO = :assunto", nativeQuery = true)
	Iterable<Prova> findByAssunto(@Param("assunto") String assunto);

}