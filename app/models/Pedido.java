package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Pedido extends Model{

	public String pagamento;
	public Boolean cancelado;
	
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
	
	//public Double total() {
		//double acumulador = 0;
		//for (int i = 0; i < itens.size(); i++) {
		//	Item[i].p
		//}
	//}


}
