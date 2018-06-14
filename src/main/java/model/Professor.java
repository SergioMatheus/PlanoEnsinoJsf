package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "nome_professor")
	private String nome_professor;
	
	@Id
	@Column(name = "idProfessor")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProfessor;
	
	@Column(name = "senha")
	private String senha;

	public String getNome_professor() {
		return nome_professor;
	}

	public void setNome_professor(String nome_professor) {
		this.nome_professor = nome_professor;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	  
	

	
}
