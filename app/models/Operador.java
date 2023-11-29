package models;

import javax.persistence.Entity;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Operador extends Model {
	
	@Required
	public String nomecli;
	@Required
	public String cpf;
	@Required
	public String email;
	@Required
	@MinSize(6)
	public String senha;
	@Required
	public String numcel;

}
