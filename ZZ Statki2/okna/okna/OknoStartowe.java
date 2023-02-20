package okna;

import javax.swing.*;

import mapa.GeneratorMapy;
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
		setSize(500, 300);
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
				JFrame pvpFrame = new JFrame("PvP");
				pvpFrame.setSize(400, 300);
				pvpFrame.setVisible(true);
				setVisible(false);

			}
		});

		vsIAButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				PlanszaGracza window = new PlanszaGracza();
				window.setVisible(true);

			}
		});

		vsTest.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Zaznacz 10 pol");
				GeneratorMapy window = new GeneratorMapy();

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