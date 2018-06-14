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
import model.Disciplina;
import model.PlanoDeEnsino;

@ManagedBean(name = "mbDisciplina")
@ViewScoped
public class DisciplinaBean {

	/*
	 * Este é o objeto que vamos usar para manipular inserções, edições e
	 * deleções na nossa base.
	 */
	private Disciplina disciplina;

	/*
	 * Mostra uma lista de funcionários carregadas do banco
	 */
	private List<Disciplina> disciplinas;
	FacesMessage msg;
	String nome_disciplina;
	String nome_coordenador;
	String carga_horaria;
	private GenericDAO disciplinaDAO;

	public DisciplinaBean() throws Exception {

		carregaRecursos();

	}

	/*
	 * Ao clicar no botão novo na nossa View, acionamos essa Action criando um
	 * novo objeto em memória.
	 */
	public void novo(ActionEvent event) {
		disciplina = new Disciplina();
	}

	/*
	 * Salvamos o funcionario criado em memória, mas antes verificamos se ele já
	 * tem um ID ou não, pois se tiver um ID sabemos que não é uma inserção e
	 * sim uma atualização de registro.
	 */
	public void salvar(ActionEvent event) {
		try {
			if (disciplina.getIdDisciplina() == null) {
				if (disciplina == null) {
					disciplina = new Disciplina();
				}

				disciplina.setCarga_horaria(carga_horaria);
				disciplina.setNome_coordenador(nome_coordenador);
				disciplina.setNome_disciplina(nome_disciplina);

				disciplinas.add(disciplina);

				disciplinaDAO.saveOrUpdate(disciplina);

				msg = new FacesMessage("Plano de Ensino Adicionado com Sucesso");
			}
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao inserir plano de ensino " + e);
		}
	}

	public void carregaRecursos() throws Exception {

		try {
			if (disciplinaDAO == null)
				disciplinaDAO = new GenericDAO();

			disciplinas = disciplinaDAO.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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
