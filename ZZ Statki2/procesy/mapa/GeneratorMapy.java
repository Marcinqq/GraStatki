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

// lidzba graczy 1 = 1 testy
	// lidzba graczy 2 = 2
	// lidzba graczy 3 = vs pc
	public GeneratorMapy(int lidzbaGraczy, Statki statki) {
//		setSize(500, 500);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BorderLayout());
//		setTitle("Okno gracza");

		PasekDoOkenek mainMenuBar = new PasekDoOkenek();
		JMenuBar menuBar = mainMenuBar.getJMenuBar();

		// tworzenie panelu z guzikami powyżej pol
		JFrame frame = new JFrame("Twoje okrety");
		frame.setJMenuBar(menuBar);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10));
		buttons = new JButton[11][11];

		for (int i = 1; i < buttons.length; i++) {
			for (int j = 1; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].addActionListener(this);
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
		if (poziomStatku == 0) {

			System.out.println("poziomStatku =0");
			if (statkiDocelowe == statekNaMapie) {
				poziomStatku++;
				statkiDocelowe = 0;
				statekNaMapie = statki.getNiszczyciel();
			} else {
				int wyslany = 10;
				tabela.ustawPole(wyslany, row, col);// wysyłanie danych do tabeli.
				tabela.print();
				System.out.println(row + " i " + col);

				source.setBackground(Color.RED);
				System.out.println("Lotniskowiec");
				System.out.println("poziomStatku =0");
				statkiDocelowe++;
				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
					statkiDocelowe = 0;
					statekNaMapie = statki.getNiszczyciel();
					dlugoscStatku = statki.getNiszczyciel();
				}

			}

		} else if (poziomStatku == 1) {
			System.out.println("poziomStatku =1");
			if (statkiDocelowe == statekNaMapie) {
				poziomStatku++;
				statkiDocelowe = 0;
				statekNaMapie = statki.getKrarzownik();

			} else {
				int wyslany = 11;
				tabela.ustawPole(wyslany, row, col);// wysyłanie danych do tabeli.
				tabela.print();
				System.out.println(row + " i " + col);

				source.setBackground(Color.RED);
				System.out.println("Niszczyciel");
				System.out.println("poziomStatku =1");
				statkiDocelowe++;
				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
					statkiDocelowe = 0;
					statekNaMapie = statki.getKrarzownik();
					dlugoscStatku = statki.getKrarzownik();

				}

			}
		} else if (poziomStatku == 2) {
			System.out.println("poziomStatku =2");
			if (statkiDocelowe == statekNaMapie) {
				poziomStatku++;
				statkiDocelowe = 0;
				statekNaMapie = statki.getKuter();
				dlugoscStatku = statki.getNiszczyciel();

			} else {
				int wyslany = 12;
				tabela.ustawPole(wyslany, row, col);// wysyłanie danych do tabeli.
				tabela.print();
				System.out.println(row + " i " + col);

				source.setBackground(Color.RED);
				System.out.println("Krarzownik");
				System.out.println("poziomStatku =2");
				statkiDocelowe++;
				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
					statkiDocelowe = 0;
					statekNaMapie = statki.getKuter();
					dlugoscStatku = statki.getKuter();

				}

			}
		} else if (poziomStatku == 3) {
			System.out.println("poziomStatku =3");
			if (statkiDocelowe == statekNaMapie) {
				poziomStatku++;

			} else {
				int wyslany = 13;
				tabela.ustawPole(wyslany, row, col);// wysyłanie danych do tabeli.
				tabela.print();
				System.out.println(row + " i " + col);

				source.setBackground(Color.RED);
				System.out.println("kuter");
				System.out.println("poziomStatku =3");
				statkiDocelowe++;
				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;

				}

			}
		} else {
			System.out.println("poziomStatku else");
		}

	}
}
