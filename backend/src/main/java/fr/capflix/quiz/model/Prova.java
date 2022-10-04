package fr.capflix.quiz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "provas")
public class Prova implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long provaId;

	@Column(nullable = false)
	private String assunto; // Posteriormente modificar pra enum

	@JsonIgnore
	@OneToMany
	@JoinTable(name="PROVA_PERGUNTA", joinColumns = @JoinColumn(name="prova_id"), inverseJoinColumns = @JoinColumn(name="pergunta_id"))
	@Column(nullable = false)
	private List<Pergunta> perguntas;

}
