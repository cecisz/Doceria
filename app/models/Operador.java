package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Operador extends Model {
	
	public String nomecli;
	public String cpf;
	public String email;
	public String senha;
	public String numcel;

}
