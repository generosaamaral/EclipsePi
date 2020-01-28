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

import br.com.SafePet.ProjetoIntegrador.bd.BDCadastro;
import br.com.SafePet.ProjetoIntegrador.model.CadastroUsuario;

@RestController
@CrossOrigin("*")
public class CadastroUsuarioController {

	private BDCadastro bd = new BDCadastro();

	@PostMapping("/cadastro/novo")
	public ResponseEntity<CadastroUsuario> novoCadastro(@RequestBody CadastroUsuario cadastro) {
		bd.gravar(cadastro);
		return ResponseEntity.ok(cadastro);
	}

	@GetMapping("/cadastro/{id}")
	public ResponseEntity<CadastroUsuario> getCadastro(@PathVariable int id) {
		CadastroUsuario cad = bd.buscar(id);
		if (cad != null) {
			return ResponseEntity.ok(cad);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/cadastro/todos")
	public ResponseEntity<ArrayList<CadastroUsuario>> getTodos() {
		return ResponseEntity.ok(bd.buscarTodos());
	}

	@PutMapping("/cadastro")
	public ResponseEntity<String> alteraCadastro(@RequestBody CadastroUsuario cadastro) {
		bd.atualizar(cadastro);
		return ResponseEntity.ok("Sucesso");
	}

	@DeleteMapping("/cadastro/{id}")
	public ResponseEntity<String> removeCadastro(@PathVariable int id) {
		if (bd.apagar(id)) {
			return ResponseEntity.ok("deleted");

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
