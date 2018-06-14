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
@Table(name = "bibliografia")
public class Bibliografia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idBibliografia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idBibliografia;

	@JoinColumn(name = "plano_ensino", referencedColumnName = "idPlanoEnsino")
	private Integer idPlanoEnsino;

	@Column(name = "titulo_livro")
	private String titulo_livro;

	@Column(name = "escritor_livro")
	private String escritor_livro;

	@Column(name = "edicao_livro")
	private String edicao_livro;

	@Column(name = "editora_livro")
	private String editora_livro;

	@Column(name = "ano_lancamento_livro")
	private Integer ano_lancamento_livro;

	public Integer getIdBibliografia() {
		return idBibliografia;
	}

	public void setIdBibliografia(Integer idBibliografia) {
		this.idBibliografia = idBibliografia;
	}

	public Integer getIdPlanoEnsino() {
		return idPlanoEnsino;
	}

	public void setIdPlanoEnsino(Integer idPlanoEnsino) {
		this.idPlanoEnsino = idPlanoEnsino;
	}

	public String getTitulo_livro() {
		return titulo_livro;
	}

	public void setTitulo_livro(String titulo_livro) {
		this.titulo_livro = titulo_livro;
	}

	public String getEscritor_livro() {
		return escritor_livro;
	}

	public void setEscritor_livro(String escritor_livro) {
		this.escritor_livro = escritor_livro;
	}

	public String getEdicao_livro() {
		return edicao_livro;
	}

	public void setEdicao_livro(String edicao_livro) {
		this.edicao_livro = edicao_livro;
	}

	public String getEditora_livro() {
		return editora_livro;
	}

	public void setEditora_livro(String editora_livro) {
		this.editora_livro = editora_livro;
	}

	public Integer getAno_lancamento_livro() {
		return ano_lancamento_livro;
	}

	public void setAno_lancamento_livro(Integer ano_lancamento_livro) {
		this.ano_lancamento_livro = ano_lancamento_livro;
	}

}
