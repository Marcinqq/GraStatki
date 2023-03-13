package graPvP;

import okna.PlanszaGracza;
import poleGry.TabelaGracza;

public class mechanikaGryPVP {
	private PlanszaGracza planszaGracza;
	private PlanszaGracza planszaGracza2;
	private TabelaGracza tabelaGracza1;
	private TabelaGracza tabelaGracza2;
	boolean graczDrugi;

	public mechanikaGryPVP(TabelaGracza tabelaGracza1, TabelaGracza tabelaGracza2) {
		this.tabelaGracza1=tabelaGracza1;
		this.tabelaGracza2=tabelaGracza2;
		graczDrugi= false;
		planszaGracza = new PlanszaGracza(tabelaGracza1, this , graczDrugi);
		planszaGracza.setVisible(true);
		planszaGracza.setTitle("Okno gracza1");
		graczDrugi = true;
		planszaGracza2 = new PlanszaGracza(tabelaGracza2, this,graczDrugi);
		
		
		
		planszaGracza2.setVisible(true);// false powinno byc zmienione na testy
		
		
		
		
		planszaGracza2.setTitle("Okno gracza2");
	}
	
	public void sprawdzPolePrzeciwnika(int row, int col, boolean graczDrugi) {
		this.graczDrugi= graczDrugi;
		
		if(graczDrugi) {
			planszaGracza2.ustawPoleNaAtak(row, col,tabelaGracza1.getPole(row, col) );
			planszaGracza.ustawPoleNaEfektAtaku(row, col, tabelaGracza1.getPole(row, col));
		}else {
			planszaGracza.ustawPoleNaAtak(row, col, tabelaGracza2.getPole(row, col));
			planszaGracza2.ustawPoleNaEfektAtaku(row, col, tabelaGracza2.getPole(row, col));
		}
		
	}

}
