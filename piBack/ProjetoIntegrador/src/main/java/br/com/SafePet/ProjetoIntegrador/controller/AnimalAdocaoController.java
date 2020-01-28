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

import br.com.SafePet.ProjetoIntegrador.bd.BDAnimalAdocao;
import br.com.SafePet.ProjetoIntegrador.model.AnimalAdocao;

@RestController
@CrossOrigin("*")
public class AnimalAdocaoController {
	private BDAnimalAdocao bd = new BDAnimalAdocao();
	
@PostMapping("/adocao/novo")
public ResponseEntity<AnimalAdocao> novoAnimal(@RequestBody AnimalAdocao aa) {
	bd.gravar(aa);
	return ResponseEntity.ok(aa);
}

@GetMapping("/adocao/{id}")
public ResponseEntity<AnimalAdocao> getAnimal(@PathVariable int id) {
	AnimalAdocao ani = bd.buscar(id);
	if (ani != null) {
		return ResponseEntity.ok(ani);
	}
	else {
		return ResponseEntity.notFound().build();
	}
}

@GetMapping("/adocao/todos")
public ResponseEntity<ArrayList<AnimalAdocao>> getTodos() {
	return ResponseEntity.ok(bd.buscarTodos());
}

@PutMapping("/adocao")
public ResponseEntity<String> alteraAdocao(@RequestBody AnimalAdocao aa) {
	bd.atualizar(aa);
	return ResponseEntity.ok("Sucesso");
}

@DeleteMapping("/adocao/{id}")
public ResponseEntity<String> removeAdocao(@PathVariable int id) {
	if (bd.apagar(id)) {
		return ResponseEntity.ok("Deleted");
	}
	else {
		return ResponseEntity.notFound().build();
	}
}


}
