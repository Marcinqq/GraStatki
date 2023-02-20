package okna;

import javax.swing.*;

import poleGry.TabelaGracza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanszaGracza extends JFrame implements ActionListener {
	private JButton[][] buttons;
	private TabelaGracza tabela = new TabelaGracza();

	public PlanszaGracza() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Okno gracza");

		PasekDoOkenek mainMenuBar = new PasekDoOkenek();
		JMenuBar menuBar = mainMenuBar.getJMenuBar();
		setJMenuBar(menuBar);

		// tworzenie panelu z guzikami powyżej pol
		JFrame frame = new JFrame("POLA PRZECIWNIKA");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(12, 12));
		buttons = new JButton[12][12];

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		// tworzenie panelu z polami
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 100; i++) {
			JButton button = new JButton("Guzik " + (i + 1));
			button.setPreferredSize(new Dimension(50, 50));
			centerPanel.add(button);
		}
		add(centerPanel, BorderLayout.CENTER);

		// tworzenie panelu z guzikami na dole
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		for (int i = 0; i < 4; i++) {
			JButton button = new JButton("Guzik " + (i + 5));
			button.setPreferredSize(new Dimension(100, 100));
			bottomPanel.add(button);
		}
		add(bottomPanel, BorderLayout.SOUTH);

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
		source.setBackground(Color.BLACK);
		// Wykonujemy odpowiednią akcję w zależności od pozycji przycisku
		/*
		 * if (row == 1 && col == 1) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 1 && col == 2) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 1 && col == 3) { System.out.println("A3"); source.setBackground(Color.RED); }
		 * else if (row == 1 && col == 4) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 1 && col == 5) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 1 && col == 6) { System.out.println("A3"); source.setBackground(Color.RED); }
		 * else if (row == 1 && col == 7) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 1 && col == 8) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 1 && col == 9) { System.out.println("A3"); source.setBackground(Color.RED);
		 * }else if (row == 1 && col == 10) { System.out.println("A3");
		 * source.setBackground(Color.RED); }else if (row == 2 && col == 1) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 2 && col == 2) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 2 && col == 3) { System.out.println("A3");
		 * source.setBackground(Color.RED); } else if (row == 2 && col == 4) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 2 && col == 5) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 2 && col == 6) { System.out.println("A3");
		 * source.setBackground(Color.RED); } else if (row == 2 && col == 7) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 2 && col == 8) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 2 && col == 9) { System.out.println("A3");
		 * source.setBackground(Color.RED); }else if (row == 2 && col == 10) {
		 * System.out.println("A3"); source.setBackground(Color.RED); }else if (row == 3
		 * && col == 1) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 3 && col == 2) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 3 && col == 3) {
		 * System.out.println("A3"); source.setBackground(Color.RED); } else if (row ==
		 * 3 && col == 4) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 3 && col == 5) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 3 && col == 6) {
		 * System.out.println("A3"); source.setBackground(Color.RED); } else if (row ==
		 * 3 && col == 7) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 3 && col == 8) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 3 && col == 9) {
		 * System.out.println("A3"); source.setBackground(Color.RED); }else if (row == 3
		 * && col == 10) { System.out.println("A3"); source.setBackground(Color.RED);
		 * }else if (row == 4 && col == 1) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 4 && col == 2) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 4 && col == 3) { System.out.println("A3"); source.setBackground(Color.RED); }
		 * else if (row == 4 && col == 4) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 4 && col == 5) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 4 && col == 6) { System.out.println("A3"); source.setBackground(Color.RED); }
		 * else if (row == 4 && col == 7) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 4 && col == 8) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 4 && col == 9) { System.out.println("A3"); source.setBackground(Color.RED);
		 * }else if (row == 4 && col == 10) { System.out.println("A3");
		 * source.setBackground(Color.RED); }else if (row == 5 && col == 1) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 5 && col == 2) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 5 && col == 3) { System.out.println("A3");
		 * source.setBackground(Color.RED); } else if (row == 5 && col == 4) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 5 && col == 5) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 5 && col == 6) { System.out.println("A3");
		 * source.setBackground(Color.RED); } else if (row == 5 && col == 7) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 5 && col == 8) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 5 && col == 9) { System.out.println("A3");
		 * source.setBackground(Color.RED); }else if (row == 5 && col == 10) {
		 * System.out.println("A3"); source.setBackground(Color.RED); }else if (row == 6
		 * && col == 1) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 6 && col == 2) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 6 && col == 3) {
		 * System.out.println("A3"); source.setBackground(Color.RED); } else if (row ==
		 * 6 && col == 4) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 6 && col == 5) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 6 && col == 6) {
		 * System.out.println("A3"); source.setBackground(Color.RED); } else if (row ==
		 * 6 && col == 7) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 6 && col == 8) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 6 && col == 9) {
		 * System.out.println("A3"); source.setBackground(Color.RED); }else if (row == 6
		 * && col == 10) { System.out.println("A3"); source.setBackground(Color.RED);
		 * }else if (row == 7 && col == 1) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 7 && col == 2) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 7 && col == 3) { System.out.println("A3"); source.setBackground(Color.RED); }
		 * else if (row == 7 && col == 4) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 7 && col == 5) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 7 && col == 6) { System.out.println("A3"); source.setBackground(Color.RED); }
		 * else if (row == 7 && col == 7) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 7 && col == 8) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 7 && col == 9) { System.out.println("A3"); source.setBackground(Color.RED);
		 * }else if (row == 7 && col == 10) { System.out.println("A3");
		 * source.setBackground(Color.RED); }else if (row == 8 && col == 1) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 8 && col == 2) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 8 && col == 3) { System.out.println("A3");
		 * source.setBackground(Color.RED); } else if (row == 8 && col == 4) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 8 && col == 5) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 8 && col == 6) { System.out.println("A3");
		 * source.setBackground(Color.RED); } else if (row == 8 && col == 7) {
		 * System.out.println("A1"); source.setBackground(Color.RED); } else if (row ==
		 * 8 && col == 8) { System.out.println("A2"); source.setBackground(Color.RED); }
		 * else if (row == 8 && col == 9) { System.out.println("A3");
		 * source.setBackground(Color.RED); }else if (row == 8 && col == 10) {
		 * System.out.println("A3"); source.setBackground(Color.RED); }else if (row == 9
		 * && col == 1) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 9 && col == 2) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 9 && col == 3) {
		 * System.out.println("A3"); source.setBackground(Color.RED); } else if (row ==
		 * 9 && col == 4) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 9 && col == 5) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 9 && col == 6) {
		 * System.out.println("A3"); source.setBackground(Color.RED); } else if (row ==
		 * 9 && col == 7) { System.out.println("A1"); source.setBackground(Color.RED); }
		 * else if (row == 9 && col == 8) { System.out.println("A2");
		 * source.setBackground(Color.RED); } else if (row == 9 && col == 9) {
		 * System.out.println("A3"); source.setBackground(Color.RED); }else if (row == 9
		 * && col == 10) { System.out.println("A3"); source.setBackground(Color.RED);
		 * }else if (row == 10 && col == 1) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 10 && col == 2) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 10 && col == 3) { System.out.println("A3"); source.setBackground(Color.RED);
		 * } else if (row == 10 && col == 4) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 10 && col == 5) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 10 && col == 6) { System.out.println("A3"); source.setBackground(Color.RED);
		 * } else if (row == 10 && col == 7) { System.out.println("A1");
		 * source.setBackground(Color.RED); } else if (row == 10 && col == 8) {
		 * System.out.println("A2"); source.setBackground(Color.RED); } else if (row ==
		 * 10 && col == 9) { System.out.println("A3"); source.setBackground(Color.RED);
		 * }else if (row == 10 && col == 10) { System.out.println("A3");
		 * source.setBackground(Color.RED); }
		 */
	}
}
