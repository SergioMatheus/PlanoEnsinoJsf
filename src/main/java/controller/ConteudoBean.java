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
import model.Conteudo;
import model.PlanoDeEnsino;

@ManagedBean(name = "mbConteudo")
@ViewScoped
public class ConteudoBean {

	/*
	 * Este é o objeto que vamos usar para manipular inserções, edições e
	 * deleções na nossa base.
	 */
	private Conteudo conteudo;

	/*
	 * Mostra uma lista de funcionários carregadas do banco
	 */
	private List<Conteudo> conteudos;
	FacesMessage msg;
	String titulo_conteudo;
	String descricao_conteudo;
	private GenericDAO conteudoDAO;

	/*
	 * É importante colocar suas inicializações no post construct e não no
	 * construtor da classe, isso porque se você estiver realizando injeção de
	 * dependência (no Spring, por exemplo) todas as dependências podem não
	 * estar carregadas na construção da sua classe, então no post construct
	 * você garante que tudo já foi carregado e agora você pode usá-los.
	 */
	public ConteudoBean() throws Exception {

		carregaRecursos();

	}

	/*
	 * Ao clicar no botão novo na nossa View, acionamos essa Action criando um
	 * novo objeto em memória.
	 */
	public void novo(ActionEvent event) {
		conteudo = new Conteudo();
	}

	/*
	 * Salvamos o funcionario criado em memória, mas antes verificamos se ele já
	 * tem um ID ou não, pois se tiver um ID sabemos que não é uma inserção e
	 * sim uma atualização de registro.
	 */
	public void salvar(ActionEvent event) {
		try {
			if (conteudo.getIdConteudo() == null) {
				if (conteudo == null) {
					conteudo = new Conteudo();
				}

				conteudo.setTitulo_conteudo(titulo_conteudo);
				conteudo.setDescricao_conteudo(descricao_conteudo);

				conteudos.add(conteudo);

				conteudoDAO.saveOrUpdate(conteudo);

				msg = new FacesMessage("Plano de Ensino Adicionado com Sucesso");
			}
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao inserir plano de ensino " + e);
		}
	}

	public void carregaRecursos() throws Exception {

		try {
			if (conteudoDAO == null)
				conteudoDAO = new GenericDAO();

			conteudos = conteudoDAO.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
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

}
