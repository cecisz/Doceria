package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Item;
import play.cache.Cache;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Itens extends Controller {
	public static void removeritem(Long id) {
		List<Item> carrinho = Cache.get(session.getId(), List.class);
	 	if (carrinho == null) {
	 		Pedidos.form();
	 	}

		for (int i = 0; i < carrinho.size(); i++) {
			Item p = carrinho.get(i);

			if (p.getId() == id) {
				carrinho.remove(p);
				break;

			}

		}
		
		Cache.set(session.getId(), carrinho);
    	Pedidos.form();

	}
}
