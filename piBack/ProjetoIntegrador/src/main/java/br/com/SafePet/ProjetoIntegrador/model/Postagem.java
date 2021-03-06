package br.com.SafePet.ProjetoIntegrador.model;

public class Postagem {
	private int id;
	private String titulo;
	private String conteudo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String toString() {//esse método vai ser chamado quando percisarmos mostrar/usar o json
		//por isso retornamos um tipo String.
		return "\"id\":"+id+"\"titulo\":" + titulo + "\"conteudo\":" + conteudo;
		//no retorno montamos uma String em formato JSON.
	}
}
