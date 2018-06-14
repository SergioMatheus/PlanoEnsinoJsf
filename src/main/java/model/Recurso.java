package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recurso")
public class Recurso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "tipo_recurso")
	private String tipo_recurso;

	@Column(name = "descricao_recurso")
	private String descricao_recurso;
	
	@Id
	@Column(name = "idRecurso")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRecurso;

	public Integer getIdRecurso() {
		return idRecurso;
	}

	public String getTipo_recurso() {
		return tipo_recurso;
	}

	public void setTipo_recurso(String tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
	}

	public String getDescricao_recurso() {
		return descricao_recurso;
	}

	public void setDescricao_recurso(String descricao_recurso) {
		this.descricao_recurso = descricao_recurso;
	}

}
