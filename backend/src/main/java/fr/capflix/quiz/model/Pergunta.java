package fr.capflix.quiz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.capflix.quiz.enums.DificuldadePergunta;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "perguntas")
public class Pergunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long perguntaId;
	
	@ManyToOne
	private Prova prova;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	private String alternativa1; // Posteriormente fazer um array de alternativas

	@Column(nullable = false)
	private String alternativa2;

	@Column(nullable = false)
	private String alternativa3;

	@Column(nullable = false)
	private String alternativa4;

	@Column(nullable = false)
	private DificuldadePergunta dificuldade;

}
