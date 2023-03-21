package graPvP;

import javax.swing.JOptionPane;

import okna.PlanszaGracza;
import poleGry.TabelaGracza;

public class mechanikaGryPVP {
	private PlanszaGracza planszaGracza;
	private PlanszaGracza planszaGracza2;
	private TabelaGracza tabelaGracza1;
	private TabelaGracza tabelaGracza2;
	boolean graczDrugi;

	public mechanikaGryPVP(TabelaGracza tabelaGracza1, TabelaGracza tabelaGracza2) {
		this.tabelaGracza1 = tabelaGracza1;
		this.tabelaGracza2 = tabelaGracza2;
		graczDrugi = false;
		planszaGracza = new PlanszaGracza(tabelaGracza1, this, graczDrugi);
		planszaGracza.setVisible(true);
		planszaGracza.setTitle("Okno gracza1");
		graczDrugi = true;
		planszaGracza2 = new PlanszaGracza(tabelaGracza2, this, graczDrugi);

		planszaGracza2.setVisible(false);

		planszaGracza2.setTitle("Okno gracza2");
	}

	private void sprawdzenieKonca(boolean graczDrugi) {
		if (graczDrugi) {
			if (tabelaGracza1.czek()) {
				JOptionPane.showMessageDialog(null, "gracz1 wygrywa");
			}
		} else {
			if (tabelaGracza2.czek()) {
				JOptionPane.showMessageDialog(null, "gracz2 wygrywa");
			}
		}
	}

	public void sprawdzPolePrzeciwnika(int row, int col, boolean graczDrugi) {
		this.graczDrugi = graczDrugi;

		if (graczDrugi) {

			if (tabelaGracza1.getPole(row, col) == 1) {
				planszaGracza2.ustawPoleNaAtak(row, col, tabelaGracza1.getPole(row, col));
				planszaGracza.ustawPoleNaEfektAtaku(row, col, tabelaGracza1.getPole(row, col));
				tabelaGracza1.ustawPole(2, row, col);
				planszaGracza2.setVisible(false);
				JOptionPane.showMessageDialog(null, "Kolej grcza 1");
				planszaGracza.setVisible(true);
			} else if (tabelaGracza1.getPole(row, col) == 11 || tabelaGracza1.getPole(row, col) == 12
					|| tabelaGracza1.getPole(row, col) == 10 || tabelaGracza1.getPole(row, col) == 13) {
				planszaGracza2.ustawPoleNaAtak(row, col, tabelaGracza1.getPole(row, col));
				planszaGracza.ustawPoleNaEfektAtaku(row, col, tabelaGracza1.getPole(row, col));
				tabelaGracza1.ustawPole(3, row, col);
				sprawdzenieKonca(graczDrugi);
			}

		} else {

			if (tabelaGracza2.getPole(row, col) == 1) {
				planszaGracza.ustawPoleNaAtak(row, col, tabelaGracza2.getPole(row, col));
				planszaGracza2.ustawPoleNaEfektAtaku(row, col, tabelaGracza2.getPole(row, col));
				tabelaGracza2.ustawPole(2, row, col);
				planszaGracza.setVisible(false);
				JOptionPane.showMessageDialog(null, "Kolej grcza 2");
				planszaGracza2.setVisible(true);
			} else if (tabelaGracza2.getPole(row, col) == 11 || tabelaGracza2.getPole(row, col) == 12
					|| tabelaGracza2.getPole(row, col) == 10 || tabelaGracza2.getPole(row, col) == 13) {
				planszaGracza.ustawPoleNaAtak(row, col, tabelaGracza2.getPole(row, col));
				planszaGracza2.ustawPoleNaEfektAtaku(row, col, tabelaGracza2.getPole(row, col));
				tabelaGracza2.ustawPole(3, row, col);
				sprawdzenieKonca(graczDrugi);
			}
		}
	}

}
