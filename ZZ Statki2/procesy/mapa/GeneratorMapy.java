package mapa;

import javax.swing.*;

import okna.PasekDoOkenek;
import poleGry.TabelaGracza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratorMapy implements ActionListener {
	private JButton[][] buttons;
	private TabelaGracza tabela = new TabelaGracza();
	private int statkiDocelowe = 0;
	private int statekNaMapie = 0;
	private int dlugoscStatku = 0;
	private int poziomStatku = 0;
	Statki statki;
	private int wyslany = 9999;
	private boolean poczatekStatku = true;
	// boolean hasBlueEyes = false;

// lidzba graczy 1 = 1 testy
	// lidzba graczy 2 = 2
	// lidzba graczy 3 = vs pc
	public GeneratorMapy(int lidzbaGraczy, Statki statki) {

		PasekDoOkenek mainMenuBar = new PasekDoOkenek();
		JMenuBar menuBar = mainMenuBar.getJMenuBar();

		JFrame frame = new JFrame("Twoje okrety");
		frame.setJMenuBar(menuBar);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10));
		buttons = new JButton[11][11];

		for (int i = 1; i < buttons.length; i++) {
			for (int j = 1; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBackground(Color.cyan);
				panel.add(buttons[i][j]);
			}
		}
		this.statki = statki;
		statekNaMapie = statki.getLotniskowiec();
		dlugoscStatku = statki.getLotniskowiecDlugosc();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	public void drukStatku(int row, int col, int wyslany, JButton source) {
		if (tabela.getPole(row, col) == 65) {
			int pentla = dlugoscStatku;
			while (pentla != 0) {
				
				source.setBackground(Color.black);
				tabela.ustawPole(wyslany, row, col);
				buttons[row][col].setBackground(Color.black);
				row--;
				pentla--;
				System.out.println("pentl");
			}
			//source.setBackground(Color.black);
			//tabela.ustawPole(wyslany, row, col);
			tabela.czyscGracza(buttons);
			poczatekStatku = true;
		}
	}

	public void dopasowanieStatku(int row, int col, int wyslany, JButton source) {
		System.out.println(row + " i " + col);

		// do zmiany

		dlugoscStatku = 2;/////////////// wdddw

		// do zmiany

		if (tabela.getPole(row, col) == 1) {
			if (dlugoscStatku == 2) {
				if (dlugoscStatku + row < 12 && tabela.getPole(dlugoscStatku + row - 1, col) == 1) {

					source.setBackground(Color.red);
					buttons[dlugoscStatku + row - 1][col].setBackground(Color.blue);
					poczatekStatku = false;
					tabela.ustawPole(4, row, col);
					tabela.ustawPole(65, dlugoscStatku + row - 1, col);
					tabela.print();
					// statkiDocelowe++;

				}
				
				if (row - dlugoscStatku + 1 > 0 && tabela.getPole(row - dlugoscStatku + 1, col) == 1) {

					source.setBackground(Color.red);
					buttons[row - dlugoscStatku + 1][col].setBackground(Color.blue);
					poczatekStatku = false;
					tabela.ustawPole(4, row, col);
					tabela.ustawPole(45, row - dlugoscStatku + 1, col);
					tabela.print();
					// statkiDocelowe++;

				}
				if (dlugoscStatku + col < 12 && tabela.getPole(row, dlugoscStatku + col - 1) == 1) {

					source.setBackground(Color.red);
					buttons[row][dlugoscStatku + col - 1].setBackground(Color.blue);
					poczatekStatku = false;
					tabela.ustawPole(4, row, col);
					tabela.ustawPole(56, row, dlugoscStatku + col - 1);
					tabela.print();
					// statkiDocelowe++;

				}

				if (col - dlugoscStatku + 1 > 0 && tabela.getPole(row, col - dlugoscStatku + 1) == 1) {

					source.setBackground(Color.red);
					buttons[row][col - dlugoscStatku + 1].setBackground(Color.blue);
					poczatekStatku = false;
					// tabela.ustawPole(55, row, col);
					tabela.ustawPole(54, row, col - dlugoscStatku + 1);
					tabela.print();
					// statkiDocelowe++;

				}

			} else if (dlugoscStatku == 3) {
			} else if (dlugoscStatku == 4) {
			} else if (dlugoscStatku == 5) {
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		int row = -1;
		int col = -1;

		// Szukamy klikniętego przycisku w tablicy przycisków
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (source == buttons[i][j]) {
					row = i;
					col = j;
					
					break;
				}
			}
		}
		if (poczatekStatku) {
			if (poziomStatku == 0) {

				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
					statkiDocelowe = 0;
					statekNaMapie = statki.getNiszczyciel();
					dlugoscStatku = statki.getNiszczycielDlugosc();
				} else {
					wyslany = 10;

					dopasowanieStatku(row, col, wyslany, source);

					if (statkiDocelowe == statekNaMapie) {
						poziomStatku++;
						statkiDocelowe = 0;
						statekNaMapie = statki.getNiszczyciel();

						dlugoscStatku = statki.getNiszczycielDlugosc();

						dlugoscStatku = statki.getNiszczyciel();

					}
				}
			} else if (poziomStatku == 1) {

				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
					statkiDocelowe = 0;
					statekNaMapie = statki.getKrarzownik();
					dlugoscStatku = statki.getKrarzownikDlugosc();
				} else {
					wyslany = 11;
					dopasowanieStatku(row, col, wyslany, source);

					if (statkiDocelowe == statekNaMapie) {
						poziomStatku++;
						statkiDocelowe = 0;
						statekNaMapie = statki.getKrarzownik();

						dlugoscStatku = statki.getKrarzownikDlugosc();

						dlugoscStatku = statki.getKrarzownik();

					}
				}
			} else if (poziomStatku == 2) {
				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
					statkiDocelowe = 0;
					statekNaMapie = statki.getKuter();

					dlugoscStatku = statki.getKuterDlugosc();

					dlugoscStatku = statki.getNiszczyciel();

				} else {
					wyslany = 12;

					dopasowanieStatku(row, col, wyslany, source);

					if (statkiDocelowe == statekNaMapie) {
						poziomStatku++;
						statkiDocelowe = 0;
						statekNaMapie = statki.getKuter();

						dlugoscStatku = statki.getKuterDlugosc();

						dlugoscStatku = statki.getKuter();

					}
				}
			} else if (poziomStatku == 3) {

				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
				} else {
					int wyslany = 13;
					dopasowanieStatku(row, col, wyslany, source);

					if (statkiDocelowe == statekNaMapie) {
						poziomStatku++;
					}
				}
			} else {
				System.out.println("poziomStatku else konies wstawiania statków");
			}
		} else {
			drukStatku(row, col, wyslany, source);
		}
	}
}
