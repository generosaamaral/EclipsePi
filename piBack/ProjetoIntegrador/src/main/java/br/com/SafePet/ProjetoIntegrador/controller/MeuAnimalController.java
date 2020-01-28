package br.com.SafePet.ProjetoIntegrador.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.SafePet.ProjetoIntegrador.bd.BDMeuAnimal;
import br.com.SafePet.ProjetoIntegrador.model.MeuAnimal;

@RestController
@CrossOrigin("*")
public class MeuAnimalController {

private BDMeuAnimal bd = new BDMeuAnimal();

@PostMapping("/animal/novo")
public ResponseEntity<MeuAnimal> novoAnimal(@RequestBody MeuAnimal animal ) {
	bd.gravar(animal);
	return ResponseEntity.ok(animal);
}

@GetMapping("/animal/{id}")
public ResponseEntity<MeuAnimal> getAnimal(@PathVariable int id) {
	MeuAnimal meu = bd.buscar(id);
if (meu !=null) {
	return ResponseEntity.ok(meu);
}
else {
	return ResponseEntity.notFound().build();
}
}

@GetMapping("/animal/todos")
public ResponseEntity<ArrayList<MeuAnimal>> getTodos(){
	return ResponseEntity.ok(bd.buscarTodos());
}

@PutMapping("/animal")
public ResponseEntity<String> alteraAnimal(@RequestBody MeuAnimal animal){
	bd.atualizar(animal);
	return ResponseEntity.ok("Sucesso");
}

@DeleteMapping("/animal/{id}")
public ResponseEntity<String> removeAnimal(@PathVariable int id) {
	if (bd.apagar(id) ) {
		return ResponseEntity.ok("Deleted");
	}
	else {
		return ResponseEntity.notFound().build();
}
}

}