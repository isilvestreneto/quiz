package fr.capflix.quiz.dto;

import org.modelmapper.ModelMapper;

import fr.capflix.quiz.model.Prova;
import lombok.Data;

@Data
public class ProvaDTO {

	private Long provaId;
	private String assunto;

	public static ProvaDTO criar(Prova prova) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(prova, ProvaDTO.class);
	}

}
