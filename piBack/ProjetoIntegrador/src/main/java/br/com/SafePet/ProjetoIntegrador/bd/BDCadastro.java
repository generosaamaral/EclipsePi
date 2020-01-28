package br.com.SafePet.ProjetoIntegrador.bd;

import java.util.ArrayList;

import br.com.SafePet.ProjetoIntegrador.model.CadastroUsuario;

public class BDCadastro {
	private ArrayList<CadastroUsuario> lista;

	public BDCadastro() {
		lista = new ArrayList<CadastroUsuario>();

	}

	public void gravar(CadastroUsuario cad) {
		this.lista.add(cad);

	}

	public CadastroUsuario buscar(int id) {
		CadastroUsuario cad = null;
		for (CadastroUsuario usu : lista) {
			if (usu.getId() == id) {
				cad = usu;
				break;
			}
		}
		return cad;
	}

	public void atualizar(CadastroUsuario cad) {
		int posicao = -1;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == cad.getId()) {
				posicao = i;
				break;
			}
		}
		if (posicao >= 0) {
			lista.set(posicao, cad);
		}
	}

	public boolean apagar(int id) {
		int posicao = -1;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				posicao = i;
				break;
			}
		}
		if (posicao >= 0) {
			lista.remove(posicao);
			return true;
		}
		return false;
	}

	public ArrayList<CadastroUsuario> buscarTodos() {
		return lista;
	}
}
