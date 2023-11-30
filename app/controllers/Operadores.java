package controllers;

import java.util.List;

import models.Operador;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Operadores extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void salvar(@Valid Operador o) {
		
		if(validation.hasErrors()) {
			params.flash();
			validation.keep();
			form();
		}
		o.save();
		listar(null);
	}
	
	public static void editar(Long id) {
		Operador o = Operador.findById(id);
		flash.put("o.nomecli", o.nomecli);
		flash.put("o.cpf", o.cpf);
		flash.put("o.email", o.email);
		flash.put("o.senha", o.senha);
		flash.put("o.numcel", o.numcel);
		renderTemplate("Operadores/form.html", o);
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
	
	
	
	

	

	
	

}