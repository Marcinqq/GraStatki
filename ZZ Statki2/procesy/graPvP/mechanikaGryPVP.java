package graPvP;

import okna.PlanszaGracza;
import poleGry.TabelaGracza;

public class mechanikaGryPVP {
	public PlanszaGracza planszaGracza;
	public PlanszaGracza planszaGracza2;

	public mechanikaGryPVP(TabelaGracza tabelaGracza1, TabelaGracza tabelaGracza2) {
		planszaGracza = new PlanszaGracza(tabelaGracza1, this);
		planszaGracza.setVisible(true);
		planszaGracza.setTitle("Okno gracza");
		planszaGracza2 = new PlanszaGracza(tabelaGracza2, this);
		planszaGracza2.setVisible(false);
		planszaGracza2.setTitle("Okno gracza2");
	}

}
