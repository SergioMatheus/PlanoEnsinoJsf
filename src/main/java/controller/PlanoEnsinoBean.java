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

@ManagedBean(name = "mbPlanoEnsino")
@ViewScoped
public class PlanoEnsinoBean {

	/*
	 * Este é o objeto que vamos usar para manipular inserções, edições e
	 * deleções na nossa base.
	 */
	private PlanoDeEnsino planodeEnsino;

	/*
	 * Mostra uma lista de funcionários carregadas do banco
	 */
	private List<PlanoDeEnsino> planosdeEnsinos;
	Conteudo conteudo;
	FacesMessage msg;
	String curso;
	String metodologia;
	String objetivo;
	Boolean status_plano;
	String tipo_avaliacao;
	String nome_professor;
	private GenericDAO planoEnsinoDAO;

	/*
	 * É importante colocar suas inicializações no post construct e não no
	 * construtor da classe, isso porque se você estiver realizando injeção de
	 * dependência (no Spring, por exemplo) todas as dependências podem não
	 * estar carregadas na construção da sua classe, então no post construct
	 * você garante que tudo já foi carregado e agora você pode usá-los.
	 */

	public PlanoEnsinoBean() throws Exception {
		
		carregaRecursos();

	}

	/*
	 * Ao clicar no botão novo na nossa View, acionamos essa Action criando um
	 * novo objeto em memória.
	 */
	public void novo(ActionEvent event) {
		planodeEnsino = new PlanoDeEnsino();
	}

	/*
	 * Salvamos o funcionario criado em memória, mas antes verificamos se ele já
	 * tem um ID ou não, pois se tiver um ID sabemos que não é uma inserção e
	 * sim uma atualização de registro.
	 */
	public void salvar(ActionEvent event) {
		try {
			if (planodeEnsino.getIdPlanoEnsino() == null) {
				if (planodeEnsino == null) {
					planodeEnsino = new PlanoDeEnsino();
				}

				planodeEnsino.setCurso(curso);
				planodeEnsino.setMetodologia(metodologia);
				planodeEnsino.setObjetivo(objetivo);
				planodeEnsino.setStatus_plano(status_plano);
				planodeEnsino.setTipo_Avaliacao(tipo_avaliacao);
				planodeEnsino.setNome_professor(nome_professor);

				planosdeEnsinos.add(planodeEnsino);

				planoEnsinoDAO.saveOrUpdate(planodeEnsino);

				msg = new FacesMessage("Plano de Ensino Adicionado com Sucesso");
			}
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao inserir plano de ensino " + e);
		}
	}

	/*
	 * Deletamos o planodeensino
	 */
	public void deletar() {
		try {
			planoEnsinoDAO.delete(planodeEnsino);
			msg = new FacesMessage("Plano de Ensino Deletado com Sucesso");
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao deletar Plano de Ensino " + e);
		}
	}
	
	public void carregaRecursos() throws Exception {

		try {
			if(planoEnsinoDAO == null)
				planoEnsinoDAO = new GenericDAO();

			
			planosdeEnsinos = planoEnsinoDAO.findAll();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public PlanoDeEnsino getPlanodeEnsino() {
		return planodeEnsino;
	}

	public void setPlanodeEnsino(PlanoDeEnsino planodeEnsino) {
		this.planodeEnsino = planodeEnsino;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Boolean getStatus_plano() {
		return status_plano;
	}

	public void setStatus_plano(Boolean status_plano) {
		this.status_plano = status_plano;
	}

	public String getTipo_avaliacao() {
		return tipo_avaliacao;
	}

	public void setTipo_avaliacao(String tipo_avaliacao) {
		this.tipo_avaliacao = tipo_avaliacao;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public String getNome_professor() {
		return nome_professor;
	}

	public void setNome_professor(String nome_professor) {
		this.nome_professor = nome_professor;
	}

	public List<PlanoDeEnsino> getPlanosdeEnsinos() {
		return planosdeEnsinos;
	}
}
