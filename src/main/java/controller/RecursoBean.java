package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import dao.GenericDAO;
import dao.PlanoDeEnsinoDAO;
import model.Bibliografia;
import model.Conteudo;
import model.PlanoDeEnsino;
import model.Recurso;

@ManagedBean(name = "mbRecurso")
@ViewScoped
public class RecursoBean {

	/*
	 * Este é o objeto que vamos usar para manipular inserções, edições e
	 * deleções na nossa base.
	 */
	private Recurso recurso;

	/*
	 * Mostra uma lista de funcionários carregadas do banco
	 */
	private List<Recurso> recursos;
	FacesMessage msg;
	String tipo_recurso;
	String descricao_recurso;
	private GenericDAO recursoDAO;

	public RecursoBean() throws Exception {

		carregaRecursos();

	}

	/*
	 * Ao clicar no botão novo na nossa View, acionamos essa Action criando um
	 * novo objeto em memória.
	 */
	public void novo(ActionEvent event) {
		recurso = new Recurso();
	}

	/*
	 * Salvamos o funcionario criado em memória, mas antes verificamos se ele já
	 * tem um ID ou não, pois se tiver um ID sabemos que não é uma inserção e
	 * sim uma atualização de registro.
	 */
	public void salvar(ActionEvent event) {
		try {
			if (recurso.getIdRecurso() == null) {
				if (recurso == null) {
					recurso = new Recurso();
				}

				recurso.setTipo_recurso(tipo_recurso);
				recurso.setDescricao_recurso(descricao_recurso);

				recursos.add(recurso);

				recursoDAO.saveOrUpdate(recurso);

				msg = new FacesMessage("Plano de Ensino Adicionado com Sucesso");
			}
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao inserir plano de ensino " + e);
		}
	}

	public void carregaRecursos() throws Exception {

		try {
			if (recursoDAO == null)
				recursoDAO = new GenericDAO();

			recursos = recursoDAO.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
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
