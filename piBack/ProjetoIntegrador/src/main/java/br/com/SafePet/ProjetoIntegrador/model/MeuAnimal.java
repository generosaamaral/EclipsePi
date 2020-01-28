package br.com.SafePet.ProjetoIntegrador.model;

public class MeuAnimal {
	private int id;
	private String nome;
	private String raca;
	private String tipo;
	private boolean vacinacao;
	private String dataNasc;
	private String detalhes;
	private char porte;
	private String foto;

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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(boolean vacinacao) {
		this.vacinacao = vacinacao;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public char getPorte() {
		return porte;
	}

	public void setPorte(char porte) {
		this.porte = porte;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
