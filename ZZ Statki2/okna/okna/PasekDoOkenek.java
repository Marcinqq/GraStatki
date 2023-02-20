package okna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class PasekDoOkenek {
	public JMenuBar getJMenuBar() {
		// GeneratorMapy planszaGracza = new GeneratorMapy();
		// JFrame frame = planszaGracza.getJFrame();
		JMenuBar menuBar = new JMenuBar();

		JMenu menuFile = new JMenu("Plik");
		menuBar.add(menuFile);
		JMenuItem start = new JMenuItem("Start");
		menuFile.add(start);
		start.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				OknoStartowe startowe = new OknoStartowe();
				startowe.setVisible(true);

			}

		});

		JMenuItem powrot = new JMenuItem("Powrót do menu");
		menuFile.add(powrot);

		JMenuItem exit = new JMenuItem("Exit");
		menuFile.add(exit);
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenu menuEdit = new JMenu("Edycja");
		menuBar.add(menuEdit);
		JMenu menuShips = new JMenu("Statki");
		menuEdit.add(menuShips);
		JMenuItem destroyer = new JMenuItem("Niszczyciel");
		menuShips.add(destroyer);
		JMenuItem cruiser = new JMenuItem("Krążownik");
		menuShips.add(cruiser);
		JMenuItem frigate = new JMenuItem("Fregata");
		menuShips.add(frigate);

		JMenu menuSettings = new JMenu("Ustawienia");
		menuBar.add(menuSettings);

		return menuBar;
	}

}