package fr.capflix.quiz.dto;

import fr.capflix.quiz.model.Pergunta;
import lombok.Data;

import java.util.List;

@Data
public class ProvaDTO {


    private Long provaId;
    private String assunto;
    private List<Pergunta> perguntas;

}
