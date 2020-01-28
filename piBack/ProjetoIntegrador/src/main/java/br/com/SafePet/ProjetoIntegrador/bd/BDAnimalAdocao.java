package br.com.SafePet.ProjetoIntegrador.bd;

import java.util.ArrayList;

import br.com.SafePet.ProjetoIntegrador.model.AnimalAdocao;

public class BDAnimalAdocao {
	private ArrayList<AnimalAdocao> lista;

	public BDAnimalAdocao() {
		lista = new ArrayList<AnimalAdocao>();

	}

	public void gravar(AnimalAdocao aa) {
		this.lista.add(aa);
	}

	public AnimalAdocao buscar(int id) {
		AnimalAdocao aa = null;
		for (AnimalAdocao ani : lista) {
			if (ani.getId() == id) {
				aa = ani;
				break;
			}
		}
		return aa;
	}
	public void atualizar (AnimalAdocao aa) {
		int posicao = -1;
		for(int i =0;i<lista.size();i++) {
			if(lista.get(i).getId()==aa.getId()) {
				posicao = i;
				break;
			}
		}
		if (posicao>=0) {
			lista.set(posicao, aa);
		}
	}
	
	public boolean apagar(int id) {
		int posicao = -1;
		for(int i=0; i<lista.size(); i++) {
			if (lista.get(i).getId()==id) {
				posicao = i;
				break;
			}
		}
		if (posicao>=0) {
			lista.remove(posicao);
			return true;
		}
		return false;
	}
	
	public ArrayList<AnimalAdocao> buscarTodos() {
		return lista;
	}
}
