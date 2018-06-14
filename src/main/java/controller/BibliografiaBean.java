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

@ManagedBean(name = "mbBibliografia")
@ViewScoped
public class BibliografiaBean {

	/*
	 * Este é o objeto que vamos usar para manipular inserções, edições e
	 * deleções na nossa base.
	 */
	private Bibliografia bibliografia;

	/*
	 * Mostra uma lista de funcionários carregadas do banco
	 */
	private List<Bibliografia> bibliografias;
	FacesMessage msg;
	String titulo_livro;
	String escritor_livro;
	String edicao_livro;
	String editora_livro;
	Integer ano_lancamento_livro;
	private GenericDAO bibliografiaDAO;

	public BibliografiaBean() throws Exception {

		carregaRecursos();

	}

	/*
	 * Ao clicar no botão novo na nossa View, acionamos essa Action criando um
	 * novo objeto em memória.
	 */
	public void novo(ActionEvent event) {
		bibliografia = new Bibliografia();
	}

	/*
	 * Salvamos o funcionario criado em memória, mas antes verificamos se ele já
	 * tem um ID ou não, pois se tiver um ID sabemos que não é uma inserção e
	 * sim uma atualização de registro.
	 */
	public void salvar(ActionEvent event) {
		try {
			if (bibliografia.getIdBibliografia() == null) {
				if (bibliografia == null) {
					bibliografia = new Bibliografia();
				}

				bibliografia.setTitulo_livro(titulo_livro);
				bibliografia.setEscritor_livro(escritor_livro);
				bibliografia.setEditora_livro(editora_livro);
				bibliografia.setEdicao_livro(edicao_livro);
				bibliografia.setAno_lancamento_livro(ano_lancamento_livro);

				bibliografias.add(bibliografia);

				bibliografiaDAO.saveOrUpdate(bibliografia);

				msg = new FacesMessage("Plano de Ensino Adicionado com Sucesso");
			}
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao inserir plano de ensino " + e);
		}
	}

	public void carregaRecursos() throws Exception {

		try {
			if (bibliografiaDAO == null)
				bibliografiaDAO = new GenericDAO();

			bibliografias = bibliografiaDAO.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Bibliografia getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(Bibliografia bibliografia) {
		this.bibliografia = bibliografia;
	}

	public List<Bibliografia> getBibliografias() {
		return bibliografias;
	}

	public void setBibliografias(List<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
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
