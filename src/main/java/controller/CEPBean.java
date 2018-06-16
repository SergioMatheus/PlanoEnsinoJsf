package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import model.Endereco;
import servico.ServicoEndereco;

@ManagedBean (name = "CEPBean")
@ViewScoped
public class CEPBean implements Serializable {

	private static final long serialVersionUID = 3922777046261225128L;

//	private List<Endereco> listagem = new ArrayList<Endereco>();
	private Endereco endereco;
	private String cep;
	
	private ServicoEndereco servico = new ServicoEndereco();
	

	public Endereco carregarEndereco(){
		
		setEndereco(new Endereco());
		Client c = Client.create();
		WebResource wr = c.resource("http://viacep.com.br/ws/" + this.getCep() + "/json/");
		System.out.println("CHAMOU O URI...");
		this.endereco = servico.buscarEnderecoPor(wr.get(String.class));
		String JSON = wr.get(String.class);
		System.out.println(JSON);
		return getEndereco();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	


}
