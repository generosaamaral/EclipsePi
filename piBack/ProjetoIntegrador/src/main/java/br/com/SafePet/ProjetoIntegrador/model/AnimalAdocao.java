package br.com.SafePet.ProjetoIntegrador.model;

public class AnimalAdocao {
	private int id;
	private String nome;
	private char porte;
	private String tipo;
	private String raca;
	private boolean vacinacao;
	private String foto;
	private String localizacao;
	private String detalhes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getPorte() {
		return porte;
	}

	public void setPorte(char porte) {
		this.porte = porte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public boolean isVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(boolean vacinacao) {
		this.vacinacao = vacinacao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}
