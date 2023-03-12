package okna;

import javax.swing.*;

import mapa.UstawieniePolaMapa;
import mapa.Statki;
import poleGry.TabelaGracza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoStartowe extends JFrame {
	private JButton pvpButton;
	private JButton vsIAButton;
	private JButton vsTest;
	private JButton exitButton;

	public OknoStartowe() {
		setTitle("Main Menu");
		setSize(500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		pvpButton = new JButton("PvP");
		vsIAButton = new JButton("Vs IA");
		vsTest = new JButton("Test");
		exitButton = new JButton("Exit");
		PasekDoOkenek mainMenuBar = new PasekDoOkenek();
		JMenuBar menuBar = mainMenuBar.getJMenuBar();
		setJMenuBar(menuBar);

		pvpButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// lidzba graczy 1 = 1 vs pc
				// lidzba graczy 2 = 2
				// lidzba graczy 3 = test
				JOptionPane.showMessageDialog(null, "Opcja gry dla 2 graczy");
				JOptionPane.showMessageDialog(null, "Gracz 1 ustawia statki");
				int lidzbaGraczy;
				int wersjaPola = 4;// ilosc statków, 4 to na test
				Statki statki = new Statki(wersjaPola);
				UstawieniePolaMapa window = new UstawieniePolaMapa(lidzbaGraczy = 2,statki);
				setVisible(false);

			}
		});

		vsIAButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "VS PC");
				

				int lidzbaGraczy;
				int wersjaPola = 1;// ilosc statków
				Statki statki = new Statki(wersjaPola);
				UstawieniePolaMapa window = new UstawieniePolaMapa(lidzbaGraczy = 1,statki);
			}
		});

		vsTest.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "TEST");
				

				int lidzbaGraczy;
				int wersjaPola = 1;// ilosc statków
				Statki statki = new Statki(wersjaPola);
				UstawieniePolaMapa window = new UstawieniePolaMapa(lidzbaGraczy = 3,statki);

			}
		});

		exitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(pvpButton);
		add(vsIAButton);
		add(vsTest);
		add(exitButton);
	}

}