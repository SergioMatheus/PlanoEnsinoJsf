package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idDisciplina")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idDisciplina;
	
	@Column(name = "nome_disciplina")
	private String nome_disciplina;
	
	@Column(name = "nome_coordenador")
	private String nome_coordenador;
	
	@Column(name = "carga_horaria")
	private String carga_horaria;

	public String getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(String idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	public String getNome_coordenador() {
		return nome_coordenador;
	}

	public void setNome_coordenador(String nome_coordenador) {
		this.nome_coordenador = nome_coordenador;
	}

	public String getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
	
}
