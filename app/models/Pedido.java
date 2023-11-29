package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.cache.Cache;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Pedido extends Model{

	@Required
	public String pagamento;
	public Boolean cancelado;
	public double total = 0;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;
	
	public Pedido() {
		data = new Date();
		cancelado = false;
	}
	
	@Override
	public String toString() {
		return id + " / " + data;
	}
	
	@ManyToOne
	public Mesa mesa;
	
	@ManyToMany
	public List<Item> itens;
	
	
	//public static Double total() {
		//List<Item> itens = Item.findAll();

	//	double acumulador = 0;
		//for (int i = 0; i < itens.size(); i++) {
		//acumulador += itens.get(i).preco;
		//}
		//return acumulador;
		//}


}
