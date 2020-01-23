package br.com.SafePet.ProjetoIntegrador.controller;//importação do pacote (acontece sozinho).

import java.util.ArrayList;//importação ArrayList.

import org.springframework.http.ResponseEntity;//importação do comando que retorna status de erro
//ou ok(end-poins).
import org.springframework.web.bind.annotation.CrossOrigin;//importação .
import org.springframework.web.bind.annotation.DeleteMapping;//importação .
import org.springframework.web.bind.annotation.GetMapping;//importação .
import org.springframework.web.bind.annotation.PathVariable;//é quando criamos uma variavel que vai
//ser usada dinamicamente(ou seja pode mudar dependendo do que vamos fazer) ex: no getPOstagem a 
//postagem que será buscada vai depender do id que escolhermos 
import org.springframework.web.bind.annotation.PostMapping;//importação .
import org.springframework.web.bind.annotation.PutMapping;//importação .
import org.springframework.web.bind.annotation.RequestBody;//Essa notação serve para quando criamos
//uma variavel que vai receber um conteudo do usuario
import org.springframework.web.bind.annotation.RestController;//importação .

import br.com.SafePet.ProjetoIntegrador.bd.BDPostagem;//importação do banco de dados.
import br.com.SafePet.ProjetoIntegrador.model.Postagem;//importação da classe Postagem.

@RestController//notação que deve ser usada antes da classe controller, essa notação permite que
//possamos controlar resquisiçoes vindas dos usuarios.
@CrossOrigin("*")//permite a integração de front e back
public class postagemController {
	private BDPostagem bd = new BDPostagem();//iniciamos o banco de dados e demos o nome de bd.
	
 @PostMapping("/home")//essa notação inidica que vamos ler algum conteudo do usuario e passamos a 
 //rota entre parenteses
 
 public ResponseEntity<Postagem> novaPostagem(@RequestBody Postagem postagem) {//esse método vai 
	 //criar uma nova postagem vinda do usuario e retorna-la sem erros.
	 
	 bd.gravar(postagem);
	 return ResponseEntity.ok(postagem);
	 
 }
 @GetMapping("/home/{id}")//essa notação indicao que vamos mostrar algum tipo de conteudo ou dado.
 public ResponseEntity<Postagem> getPostagem(@PathVariable int id){//esse método vai mostrar a 
	 //publicação cujo o id nos vamos informar .
	 Postagem post = bd.buscar(id);//aqui ele chama o metodo buscar do banco de dados e armazena 
	 //o resultado na variavel post
	 if(post!= null) {//se a variavel post tiver algum conteudo a retornaremos sem erros. 
		 return ResponseEntity.ok(post);
	 }
	 else {
		 return ResponseEntity.notFound().build();//se nao retornaremos um erro do qual diz que nao 
		 //encontramos o conteudo no id procurado
	 }
 }
 @GetMapping("/home/todos")
 public ResponseEntity<ArrayList<Postagem>>getTodos(){//esse método nos mostra todas as postagem 
	 //ja criadas
	 return ResponseEntity.ok(bd.buscarTodos());//e retorna o status ok 
 }
 @PutMapping("/home")
 public ResponseEntity<String> alterarPostagem(@RequestBody Postagem postagem){
	 bd.atualizar(postagem);//chamamos o método do banco de dados "Atualizar"
	 return ResponseEntity.ok("Sucesso");//e retornamos a palavra "sucesso" *OBS: mesmo que a
	 //postagem não seja alterada a mensagem "sucesso" aparece.
 }
 @DeleteMapping("/home/{id}")
 public ResponseEntity<String> removePostagem(@PathVariable int id){//esse método deleta uma 
	 //postagem ja feita ,apenas indicando o id.
	 if(bd.apagar(id)) {
		 return ResponseEntity.ok("Deleted");//Se o id passado for encontrado e a postagem for 
		 //deletada a mensagem "deleted" aparece
	 }
	 else {
		 return ResponseEntity.notFound().build();//Caso contrario aparece um erro de id nao encontrado
	 }
	 
 }
}
