package okna;

import javax.swing.*;

import graPvP.mechanikaGryPVP;
import poleGry.TabelaGracza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanszaGracza extends JFrame implements ActionListener {
	private JButton[][] buttons;
	private JButton[][] buttons2;
	private TabelaGracza tabela = new TabelaGracza();
	private mechanikaGryPVP silnikGry;
	private boolean graczDrugi;

	public PlanszaGracza(TabelaGracza tabela, mechanikaGryPVP silnikGry, boolean graczDrugi) {
		setSize(300, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.graczDrugi = graczDrugi;
		this.tabela = tabela;
		this.silnikGry = silnikGry;
		PasekDoOkenek mainMenuBar = new PasekDoOkenek();
		JMenuBar menuBar = mainMenuBar.getJMenuBar();
		setJMenuBar(menuBar);

		JPanel centerPanel = new JPanel();

		centerPanel.setLayout(new GridLayout(20, 10));

		buttons = new JButton[11][11];
		for (int i = 1; i < buttons.length; i++) {
			for (int j = 1; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBackground(Color.blue);
				centerPanel.add(buttons[i][j]);

			}
		}
		buttons2 = new JButton[11][11];
		for (int i = 1; i < buttons2.length; i++) {
			for (int j = 1; j < buttons2[i].length; j++) {
				buttons2[i][j] = new JButton("");

				if (tabela.getPole(i, j) != 1) {
					buttons2[i][j].setBackground(Color.black);
					centerPanel.add(buttons2[i][j]);
				} else {
					buttons2[i][j].setBackground(Color.cyan);
					centerPanel.add(buttons2[i][j]);
				}

			}
		}
		add(centerPanel);

	}

	// 1 pole puste
	// 2 pudło
	// 3 trariony
	// 4 cengtrum klikniecia w generatorze
	// 10 lotniskowiec
	// 11 niszczyciel
	// 12 krarzownik
	// 13 kuter
	public void ustawPoleNaAtak(int row, int col, int wartosc) {
		if (wartosc == 1) {
			buttons[row][col].setBackground(Color.cyan);

		} else if (wartosc == 2) {
			buttons[row][col].setBackground(Color.DARK_GRAY);
		} else if (wartosc == 3) {
			buttons[row][col].setBackground(Color.yellow);
		} else if (wartosc == 11 || wartosc == 10 || wartosc == 12 || wartosc == 13) {
			buttons[row][col].setBackground(Color.red);
		}
	}

	public void ustawPoleNaEfektAtaku(int row, int col, int wartosc) {
		if (wartosc == 1) {
			buttons2[row][col].setBackground(Color.white);
		} else if (wartosc == 2) {
			buttons2[row][col].setBackground(Color.DARK_GRAY);
		} else if (wartosc == 3) {
			buttons2[row][col].setBackground(Color.yellow);
		} else if (wartosc == 11 || wartosc == 10 || wartosc == 12 || wartosc == 13) {
			buttons2[row][col].setBackground(Color.red);
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		int row = -1;
		int col = -1;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (source == buttons[i][j]) {
					row = i;
					col = j;
					break;
				}
			}
		}
		silnikGry.sprawdzPolePrzeciwnika(row, col, graczDrugi);

	}
}
