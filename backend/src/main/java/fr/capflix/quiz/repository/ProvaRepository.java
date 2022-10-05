package fr.capflix.quiz.repository;

import fr.capflix.quiz.dto.ProvaDTO;
import fr.capflix.quiz.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    //@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    @Query(value = "SELECT * FROM PROVAS WHERE ASSUNTO = :assunto", nativeQuery = true)
    List<ProvaDTO> findByAssunto(@Param("assunto") String assunto);


}