package controllers;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import play.cache.Cache;
import models.Pedido;
import models.Item;
import models.Mesa;
import models.Operador;
import models.Pedido;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Pedidos extends Controller{
	
	public static void form() {
		List<Item> itens= Item.findAll();
		List<Item> carrinho = Cache.get(session.getId(), List.class);
		
		List<Mesa> mesas= Mesa.findAll();
		render(itens,carrinho,mesas);
	}
	
	public static void add(Long id) {
		Item i = Item.findById(id);
		if(i.id == null) {
			flash.error("É necessário selecionar uma opção");
			//JOptionPane.showMessageDialog(null, "É necessário selecionar uma opção", null, JOptionPane.ERROR_MESSAGE);
			form();
		}
		
		List<Item> carrinho = Cache.get(session.getId(), List.class);
	 	if (carrinho == null) {
	 		carrinho = new ArrayList<Item>();
	 	}
	 	
	 	Item item = Item.findById(id);
		carrinho.add(item);
		Cache.set(session.getId(), carrinho);
		form();
	}
	
	public static void salvar(Pedido p) {
		List<Item> carrinho = Cache.get(session.getId(), List.class);
		if (carrinho == null) {
			form();
		}
		
		for (Item item : carrinho) {
			p.total += item.preco;
		}
		
		p.itens = carrinho;
		p.save();
		Cache.clear();
		listar();
		
	}
	
	public static void editar(Long id) {
		Pedido p = Pedido.findById(id);
		renderTemplate("Pedidos/form.html", p);
    }
	
	public static void listar() {
		List<Pedido>pedidos=Pedido.findAll();
		render(pedidos);
	}
	
	public static void remover(Long id) {
		Pedido p = Pedido.findById(id);
		p.delete();
		listar();
	}
	
	public static void detalhar(Long id) {
		Pedido pedido = Pedido.findById(id);	
		render(pedido);
	}
	
	public static void cancelar(Long id) {
		Pedido p = Pedido.findById(id);
		p.cancelado = true;
		p.save();
		Pedidos.form();
		
	}
	
	

}
