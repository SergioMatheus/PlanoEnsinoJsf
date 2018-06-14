package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conteudo")
public class Conteudo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idConteudo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idConteudo;

	@Column(name = "titulo_conteudo")
	private String titulo_conteudo;

	@Column(name = "descricao_conteudo")
	private String descricao_conteudo;

	@JoinColumn(name = "disciplina", referencedColumnName = "idDisciplina")
	private Integer idDisciplina;

	public Integer getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Integer idConteudo) {
		this.idConteudo = idConteudo;
	}

	public String getTitulo_conteudo() {
		return titulo_conteudo;
	}

	public void setTitulo_conteudo(String titulo_conteudo) {
		this.titulo_conteudo = titulo_conteudo;
	}

	public String getDescricao_conteudo() {
		return descricao_conteudo;
	}

	public void setDescricao_conteudo(String descricao_conteudo) {
		this.descricao_conteudo = descricao_conteudo;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

}
