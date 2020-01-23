package br.com.SafePet.ProjetoIntegrador.bd;

import java.util.ArrayList;

import br.com.SafePet.ProjetoIntegrador.model.Postagem;

public class BDPostagem {
 private ArrayList <Postagem> lista;

 	public BDPostagem() {
 		lista = new ArrayList<Postagem>();
 	}
 	public void gravar(Postagem p) {
 		this.lista.add(p);
 	}
 	public Postagem buscar(int id) {
 		Postagem p = null;
 		for (Postagem post: lista) {
 			if (post.getId()== id) {
 				p = post;
 				break;
 			}
 			
 		}
 		return p;
 	}
 	public void atualizar (Postagem p) {
 		int posicao = -1;
 		for (int i = 0; i<lista.size();i++) {
 			if (lista.get(i).getId()== p.getId()) {
 				posicao = i;
 				break;
 			}
 		}
 		if(posicao>=0) {
 			lista.set(posicao, p);
 		}
 	}
 	public boolean apagar (int id) {
 		int posicao = -1;
 		for(int i = 0; i<lista.size();i++) {
 			if(lista.get(i).getId()==id) {
 				posicao=i;
 				break;
 			}
 		}
 		if(posicao>=0) {
 			lista.remove(posicao);
 			return true;
 		}
 		return false;
 	}
 	public ArrayList<Postagem> buscarTodos(){
 		return lista;
 	}
}
