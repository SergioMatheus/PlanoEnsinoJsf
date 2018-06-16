package model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Endereco {

@SerializedName("cep")
@Expose
private String cep;
@SerializedName("logradouro")
@Expose
private String logradouro;
@SerializedName("complemento")
@Expose
private String complemento;
@SerializedName("bairro")
@Expose
private String bairro;
@SerializedName("localidade")
@Expose
private String localidade;
@SerializedName("uf")
@Expose
private String uf;
@SerializedName("unidade")
@Expose
private String unidade;
@SerializedName("ibge")
@Expose
private String ibge;
@SerializedName("gia")
@Expose
private String gia;

private String numero;

public String getCep() {
return cep;
}

public void setCep(String cep) {
this.cep = cep;
}

public String getLogradouro() {
return logradouro;
}

public void setLogradouro(String logradouro) {
this.logradouro = logradouro;
}

public String getComplemento() {
return complemento;
}

public void setComplemento(String complemento) {
this.complemento = complemento;
}

public String getBairro() {
return bairro;
}

public void setBairro(String bairro) {
this.bairro = bairro;
}

public String getLocalidade() {
return localidade;
}

public void setLocalidade(String localidade) {
this.localidade = localidade;
}

public String getUf() {
return uf;
}

public void setUf(String uf) {
this.uf = uf;
}

public String getUnidade() {
return unidade;
}

public void setUnidade(String unidade) {
this.unidade = unidade;
}

public String getIbge() {
return ibge;
}

public void setIbge(String ibge) {
this.ibge = ibge;
}

public String getGia() {
return gia;
}

public void setGia(String gia) {
this.gia = gia;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("cep", cep).append("logradouro", logradouro).append("complemento", complemento).append("bairro", bairro).append("localidade", localidade).append("uf", uf).append("unidade", unidade).append("ibge", ibge).append("gia", gia).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(gia).append(bairro).append(complemento).append(cep).append(ibge).append(uf).append(localidade).append(logradouro).append(unidade).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof Endereco) == false) {
return false;
}
Endereco rhs = ((Endereco) other);
return new EqualsBuilder().append(gia, rhs.gia).append(bairro, rhs.bairro).append(complemento, rhs.complemento).append(cep, rhs.cep).append(ibge, rhs.ibge).append(uf, rhs.uf).append(localidade, rhs.localidade).append(logradouro, rhs.logradouro).append(unidade, rhs.unidade).isEquals();
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

}