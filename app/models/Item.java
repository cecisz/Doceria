package models;

import java.util.List;

import javax.persistence.Entity;

import play.cache.Cache;
import play.db.jpa.Model;

@Entity
public class Item extends Model {
	
	public String nome;
	public Double preco;
	
	@Override
	public String toString() {
		return nome;
	}



}
