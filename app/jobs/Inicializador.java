package jobs;

import models.Operador;
import models.Item;
import models.Mesa;
import models.Pedido;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Mesa.count() == 0) {
			Mesa m1 = new Mesa();
			m1.numero = "1";
			m1.save();

			Mesa m2 = new Mesa();
			m2.numero = "2";
			m2.save();

			Mesa m3 = new Mesa();
			m3.numero = "3";
			m3.save();

			Mesa m4 = new Mesa();
			m4.numero = "4";
			m4.save();

			Mesa m5 = new Mesa();
			m5.numero = "5";
			m5.save();

			Mesa m6 = new Mesa();
			m6.numero = "6";
			m6.save();

			Mesa m7 = new Mesa();
			m7.numero = "7";
			m7.save();

			Mesa m8 = new Mesa();
			m8.numero = "8";
			m8.save();

			Mesa m9 = new Mesa();
			m9.numero = "9";
			m9.save();

			Mesa m10 = new Mesa();
			m10.numero = "10";
			m10.save();

			Mesa m11= new Mesa();
			m11.numero = "11";
			m11.save();

			Mesa m12 = new Mesa();
			m12.numero = "12";
			m12.save();

		}
		
		if(Item.count() == 0) {
			Item i1 = new Item();
			i1.nome = "Brigadeiro";
			i1.preco =2.0;
			i1.save();
			
			Item i2 = new Item();
			i2.nome = "Quidim";
			i2.preco = 3.0;
			i2.save();
			
			Item i3 = new Item();
			i3.nome = "Beijinho";
			i3.preco = 2.0;
			i3.save();
			
			Item i4 = new Item();
			i4.nome = "Mousse";
			i4.preco = 3.0;
			i4.save();
			
			Item i5 = new Item();
			i5.nome = "Brownie";
			i5.preco = 4.0;
			i5.save();
			
			Item i6 = new Item();
			i6.nome = "Pudim de leite";
			i6.preco = 3.0;
			i6.save();
			
			Item i7 = new Item();
			i7.nome = "Macaron";
			i7.preco = 3.0;
			i7.save();
			
			Item i8 = new Item();
			i8.nome = "Torta de abacaxi";
			i8.preco = 5.0;
			i8.save();
			
			Item i9 = new Item();
			i9.nome = "Pudim de café";
			i9.preco = 5.0;
			i9.save();
			
			Item i10 = new Item();
			i10.nome = "Banana split";
			i10.preco = 10.0;
			i10.save();
			
			Item i11 = new Item();
			i11.nome = "Milk-shake";
			i11.preco = 15.0;
			i11.save();
			
		}
		
		if(Operador.count() == 0) {
			Operador c1 = new Operador();
			c1.nomecli = "lace";
			c1.cpf = "123";
			c1.numcel = "123";
			c1.email = "lace@gmail.com";
			c1.senha = "123456";
			
			c1.save();
		}
	}

}
