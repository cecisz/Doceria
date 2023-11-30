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
		
			if(operador == null) {
					flash.error("E-mail ou senha incorreto");
					login();
			}else {
				session.put("usuarioLogado", operador.email);
				flash.success("Login realizado com sucesso!");
				Operadores.listar("");
			}
	}
	
	public static void logout() {
		session.clear();
		flash.success("Você saiu do sistema");
		login();
	}
	
		

}
