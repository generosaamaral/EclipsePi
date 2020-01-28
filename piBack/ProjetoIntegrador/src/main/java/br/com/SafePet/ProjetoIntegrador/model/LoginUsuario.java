package br.com.SafePet.ProjetoIntegrador.model;

public class LoginUsuario {
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String toString() {
		return "{\"email\":\""+email+"\", \"senha\":\""+senha+"\"}";
	}
}
