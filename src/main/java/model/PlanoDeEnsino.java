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
@Table(name = "plano_ensino")
public class PlanoDeEnsino implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPlanoEnsino")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPlanoEnsino;
	
	@Column(name = "objetivo")
	private String objetivo;
	
	@Column(name = "metodologia")
	private String metodologia;
	
	@Column(name = "status_plano")
	private Boolean status_plano;
	
	@Column(name = "tipo_avaliacao")
	private String tipo_avaliacao;
	
	@Column(name = "nome_professor")
	private String nome_professor;
	
	@Column(name = "curso")
	private String curso;

	@JoinColumn(name = "disciplina", referencedColumnName = "idDisciplina")
	private Integer idDisciplina;
	
	@JoinColumn(name = "conteudo", referencedColumnName = "idConteudo")
	private Integer idConteudo;
	
	@JoinColumn(name = "bibliografia", referencedColumnName = "idBibliografia")
	private Integer idBibliografia;

	public Integer getIdPlanoEnsino() {
		return idPlanoEnsino;
	}

	public void setIdPlanoEnsino(Integer idPlanoEnsino) {
		this.idPlanoEnsino = idPlanoEnsino;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getTipo_Avaliacao() {
		return tipo_avaliacao;
	}

	public void setTipo_Avaliacao(String tipo_avaliacao) {
		this.tipo_avaliacao = tipo_avaliacao;
	}
	public Boolean getStatus_plano() {
		return status_plano;
	}

	public void setStatus_plano(Boolean status_plano) {
		this.status_plano = status_plano;
	}

	public String getNome_professor() {
		return nome_professor;
	}

	public void setNome_professor(String nome_professor) {
		this.nome_professor = nome_professor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public Integer getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Integer idConteudo) {
		this.idConteudo = idConteudo;
	}

	public Integer getIdBibliografia() {
		return idBibliografia;
	}

	public void setIdBibliografia(Integer idBibliografia) {
		this.idBibliografia = idBibliografia;
	}

}
