package br.com.SafePet.ProjetoIntegrador.security;

import javax.xml.bind.DatatypeConverter;

import br.com.SafePet.ProjetoIntegrador.model.LoginUsuario;

public class Autenticador {
	private static final String PREFIXO = "SaFePeT|";

	public static String generateToken(LoginUsuario usuario) {
		String str = PREFIXO + usuario.toString();
		String token = DatatypeConverter.printHexBinary(str.getBytes());
		return token;
	}
	public static boolean isValid (String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String novaString = new String (vetor);
		if(novaString.startsWith(PREFIXO)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
