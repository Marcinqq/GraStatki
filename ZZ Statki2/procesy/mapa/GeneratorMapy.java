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

	public GeneratorMapy() {
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
		int wyslany = 10;
		tabela.ustawPole(wyslany, row, col);
		tabela.print();
		System.out.println(row + " i " + col);

		source.setBackground(Color.RED);
		// Wykonujemy odpowiednią akcję w zależności od pozycji przycisku do testuw
		// ecra..

		if (row == 1 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 1 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 2 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 3 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 4 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 5 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 6 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 7 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 8 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 9 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 1) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 2) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 3) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 4) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 5) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 6) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 7) {
			System.out.println("A1");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 8) {
			System.out.println("A2");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 9) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		} else if (row == 10 && col == 10) {
			System.out.println("A3");
			source.setBackground(Color.RED);
		}
	}
}