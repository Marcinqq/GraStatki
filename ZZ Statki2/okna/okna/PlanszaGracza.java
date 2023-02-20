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
	
	}
}
