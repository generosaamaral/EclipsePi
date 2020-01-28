package br.com.SafePet.ProjetoIntegrador.bd;

import java.util.ArrayList;

import br.com.SafePet.ProjetoIntegrador.model.MeuAnimal;

public class BDMeuAnimal {
	private ArrayList<MeuAnimal> lista ;
	public BDMeuAnimal () {
		lista = new ArrayList<MeuAnimal>();
		
	}
	public void gravar(MeuAnimal ma) {
		this.lista.add(ma);
		
	}
	public MeuAnimal buscar (int id) {
		MeuAnimal ma = null;
		for(MeuAnimal meu:lista) {
			if(meu.getId()==id) {
				ma= meu;
				break;
			}
			
		}
		return ma;
	}
	public void atualizar(MeuAnimal ma) {
		int posicao = -1;
		for(int i = 0; i<lista.size();i++) {
			if(lista.get(i).getId()==ma.getId()) {
				posicao= i;
				break;
			}
		}
		if(posicao>=0) {
			lista.set(posicao, ma);
			
		}
	}
	public boolean apagar (int id) {
		int posicao = -1;
		for (int i =0;i<lista.size();i++) {
			if(lista.get(i).getId()==id) {
				posicao = i;
				break;
			}
		}
		if(posicao>=0) {
			lista.remove(posicao);
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<MeuAnimal>buscarTodos(){
		return lista;
	}
}
