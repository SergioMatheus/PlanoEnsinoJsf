package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.UrlData;

@ManagedBean(name = "userData")
@SessionScoped
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;
	public UrlData data;

	public UrlData getData() {
		return data;
	}

	public void setData(UrlData data) {
		this.data = data;
	}
}