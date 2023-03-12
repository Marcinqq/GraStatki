package graPvP;

import okna.PlanszaGracza;
import poleGry.TabelaGracza;

public class mechanikaGryPVP {
	private PlanszaGracza planszaGracza;
	private PlanszaGracza planszaGracza2;
	private TabelaGracza tabelaGracza1;
	private TabelaGracza tabelaGracza2;

	public mechanikaGryPVP(TabelaGracza tabelaGracza1, TabelaGracza tabelaGracza2) {
		this.tabelaGracza1=tabelaGracza1;
		this.tabelaGracza2=tabelaGracza2;
		boolean graczDrugi= false;
		planszaGracza = new PlanszaGracza(tabelaGracza1, this , graczDrugi);
		planszaGracza.setVisible(true);
		planszaGracza.setTitle("Okno gracza1");
		graczDrugi = true;
		planszaGracza2 = new PlanszaGracza(tabelaGracza2, this,graczDrugi);
		
		
		
		planszaGracza2.setVisible(true);// false powinno byc zmienione na testy
		
		
		
		
		planszaGracza2.setTitle("Okno gracza2");
	}
	
	public void sprawdzPolePrzeciwnika() {
		
	}

}
