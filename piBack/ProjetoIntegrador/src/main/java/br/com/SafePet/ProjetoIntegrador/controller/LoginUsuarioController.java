package br.com.SafePet.ProjetoIntegrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.SafePet.ProjetoIntegrador.model.LoginUsuario;
import br.com.SafePet.ProjetoIntegrador.security.Autenticador;
import br.com.SafePet.ProjetoIntegrador.security.Token;

@RestController
@CrossOrigin("*")
public class LoginUsuarioController {
	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody LoginUsuario usuario){
		if(usuario.getEmail().contentEquals("safePet@sp.com")&&usuario.getSenha().contentEquals("123456789@")) {
			usuario.setEmail("safePet@sp.com");
			String tk = Autenticador.generateToken(usuario);
			Token token = new Token();
			token.setStrToken(tk);
			return ResponseEntity.ok(token);
		}
		else {
			return ResponseEntity.status(403).build();
		}
	}
	

}
