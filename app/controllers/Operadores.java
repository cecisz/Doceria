package controllers;

import java.util.List;

import models.Operador;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Operadores extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void salvar(Operador o) {
		o.save();
		listar(null);
	}
	
	public static void listar(String pesquisa) {
		List<Operador> operadores= null;
		if(pesquisa == null || pesquisa.isEmpty()){
			operadores=Operador.findAll();
			}else {
				operadores = Operador.find("lower(nomecli) like ?1 or lower(email) like ?1", 
						"%" + pesquisa.toLowerCase() + "%").fetch();		
				}
		render(operadores, pesquisa);
	}
	
	public static void remover(Long id) {
		Operador o = Operador.findById(id);
		o.delete();
		listar(null);
	}
	
	public static void editar(Long id) {
		Operador o = Operador.findById(id);
		renderTemplate("Operadores/form.html", o);
    }
	

	

	
	

}