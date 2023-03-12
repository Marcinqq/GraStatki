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

	public PlanszaGracza(TabelaGracza tabela, mechanikaGryPVP silnikGry) {
		setSize(300, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		this.tabela = tabela;
		this.silnikGry = silnikGry;
		PasekDoOkenek mainMenuBar = new PasekDoOkenek();
		JMenuBar menuBar = mainMenuBar.getJMenuBar();
		setJMenuBar(menuBar);

		
		JPanel centerPanel = new JPanel();
		//JPanel centerPanel2 = new JPanel();
		centerPanel.setLayout(new GridLayout(20, 10));
		//centerPanel2.setLayout(new GridLayout(10, 10));
		buttons = new JButton[11][11];
		for (int i = 1; i < buttons.length; i++) {
			for (int j = 1; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBackground(Color.cyan);
				centerPanel.add(buttons[i][j]);
			}
		}
		buttons2 = new JButton[11][11];
		for (int i = 1; i < buttons2.length; i++) {
			for (int j = 1; j < buttons2[i].length; j++) {
				buttons2[i][j] = new JButton("");
				buttons[i][j].setBackground(Color.blue);
				centerPanel.add(buttons2[i][j]);
			}
		}
		add(centerPanel);
		//add(centerPanel2);

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
		System.out.println(row + " i " + col);
		source.setBackground(Color.BLACK);

	}
}
