package poleGry;

import java.awt.Color;

import javax.swing.JButton;

public class TabelaGracza {

	private int[][] pole = new int[12][12];

	// 1 pole puste
	// 2 pudło
	// 3 trariony
	// 4 cengtrum klikniecia w generatorze
	// 10 lotniskowiec
	// 11 niszczyciel
	// 12 krarzownik
	// 13 kuter
	public TabelaGracza() {
		czyscTabela();
	}

	public void czyscTabela() {
		for (int i = 0; i < pole.length; i++) {
			for (int j = 0; j < pole[i].length; j++) {
				pole[i][j] = 1;
			}
		}
	}

	public void czyscGracza(JButton[][] buttons) {
		for (int i = 0; i < pole.length; i++) {
			for (int j = 0; j < pole[i].length; j++) {
				if (pole[i][j] == 45 || pole[i][j] == 65 || pole[i][j] == 54 || pole[i][j] == 56 || pole[i][j] == 4) {
					pole[i][j] = 1;
					buttons[i][j].setBackground(Color.cyan);
				}

			}
		}

	}

	

	public void ustawPole(int wgrywanie, int i, int j) {

		pole[i][j] = wgrywanie;
		;
	}

	public void klikAtak(int[][] pole) {

	}

	public int getPole(int i, int j) {

		if (i > 10 || j > 10 || i < 1 || j < 1) {

			return 11;
		}

		return pole[i][j];
	}
	
	public boolean czek() {
		
		for (int i = 0; i < pole.length; i++) {
			for (int j = 0; j < pole[i].length; j++) {
				if( 10==pole[i][j]||11==pole[i][j]||12==pole[i][j]||13==pole[i][j]) {
					return false;
				}	
			}
		}
		return true;
	}

	public void print() {
		System.out.println();
		System.out.println();
		for (int i = 0; i < pole.length; i++) {
			for (int j = 0; j < pole[i].length; j++) {
				System.out.print(pole[i][j] + " ");
			}
			System.out.println();
		}
	}

}
