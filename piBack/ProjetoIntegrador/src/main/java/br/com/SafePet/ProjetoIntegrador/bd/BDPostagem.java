package br.com.SafePet.ProjetoIntegrador.bd;//Importação automatica que ocorre quando
//criamos o pacote

import java.util.ArrayList;//Importação do ArrayList que criamos 

import br.com.SafePet.ProjetoIntegrador.model.Postagem;//Importação da classe Postagem
//(objeto de negocio)

public class BDPostagem {
 private ArrayList <Postagem> lista;//Criação de uma "Variavel" que do tipo vetor sem tamanho
 // definido do tipo "Postagem" e com o nome "lista"

 	public BDPostagem() {
 		lista = new ArrayList<Postagem>();//Inicializando o vetor lista
 	}
 	//Create-Criar
 	public void gravar(Postagem p) {//Método de criar uma postagem que tem "p" do tipo postagem como
 		//paramentro para que o usuario escolha o conteudo da postagem
 		this.lista.add(p);//A variavel "lista" adiciona o conteudo de "p" no métodos criado
 	}
 	//Read-Ler
 	public Postagem buscar(int id) {//Método que retorna o conteudo da postagem e ele encontra 
 		//essa postagem pelo id informado
 		Postagem p = null;
 		for (Postagem post: lista) {//Aqui o for vai percorrer toda o vetor "lista"
 			if (post.getId()== id) {//Se o id que o usuario digitou para procurar for igual ao 
 				//que o post encontrou na lista a variavel "p" recebe o conteudo da postagem  
 				p = post;
 				break;//E o "break" serve para sair o If  
 			}
 			
 		}
 		return p;// retorna o conteudo da postagem 
 	}
 	//Update-Atualizar
 	public void atualizar (Postagem p) {//Esse método atualiza o conteudo de postagens já feitas
 		int posicao = -1;//posicao começa com -1 para que não encontre um id com esse número antes
 		//do if
 		for (int i = 0; i<lista.size();i++) {//O for vai percorrer o vetor "lista"
 			if (lista.get(i).getId()== p.getId()) {//o if vai verificar a posicao do conteudo 
 				//que esta sendo alterado
 				posicao = i;//aqui a "posicao" recebe o id da posicao que  esta sendo alterado
 				break;//E o "break" serve para sair o If
 			}
 		}
 		if(posicao>=0) {
 			lista.set(posicao, p);//Se o "if" anterior der certo o conteudo anterior vai ser 
 			//substituido pela nova postagem
 		}
 	}//Delete-Apagar
 	public boolean apagar (int id) {//Esse método recebe o id da postagem que vai ser apagada
 		int posicao = -1;
 		for(int i = 0; i<lista.size();i++) {
 			if(lista.get(i).getId()==id) {
 				posicao=i;
 				break;
 			}//Segue o mesmo raciocínio do atualizar, porém no lugar de atualizar ele remove o 
 			//conteúdo da postagem se o id desejado for encontrado
 		}
 		if(posicao>=0) {
 			lista.remove(posicao);
 			return true;
 		}
 		return false;
 	}
 	public ArrayList<Postagem> buscarTodos(){//Retorna o vetor de postagens
 		return lista;
 	}
}
