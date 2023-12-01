package controllers;

import models.Operador;
import play.mvc.Controller;
import play.mvc.With;


public class Logins extends Controller{
	
	public static void login() {
		render();
	}
	
public static void logar(String email, String senha) {
		
		Operador operador = Operador.find("email = ?1 and senha = ?2", email, senha).first();
		
	if (operador!= null) {
		session.put("usuarioLogado", operador.nomecli);
		flash.success("Login realizado com sucesso!");
		Operadores.listar("");
	}
	
	flash.error("Credenciais inválidas");
	login();
}
	
	public static void logout() {
		session.clear();
		flash.success("Você saiu do sistema");
		login();
	}
	
		

}
