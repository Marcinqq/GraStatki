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
	private boolean wnetrzeStatku = false;
	private boolean punktKlikniecia = false;

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

// wdrukowyanie czarnego pola
	public void drukStatku(int row, int col, int wyslany, JButton source) {
		if (tabela.getPole(row, col) == 65) {
			int pentla = dlugoscStatku;
			while (pentla != 0) {
				source.setBackground(Color.black);
				tabela.ustawPole(wyslany, row, col);
				buttons[row][col].setBackground(Color.black);
				row--;
				pentla--;
			}
			statkiDocelowe++;
			tabela.czyscGracza(buttons);
			poczatekStatku = true;
		} else if (tabela.getPole(row, col) == 45) {
			int pentla = dlugoscStatku;
			while (pentla != 0) {
				source.setBackground(Color.black);
				tabela.ustawPole(wyslany, row, col);
				buttons[row][col].setBackground(Color.black);
				row++;
				pentla--;
			}
			statkiDocelowe++;
			tabela.czyscGracza(buttons);
			poczatekStatku = true;
		} else if (tabela.getPole(row, col) == 56) {
			int pentla = dlugoscStatku;
			while (pentla != 0) {
				source.setBackground(Color.black);
				tabela.ustawPole(wyslany, row, col);
				buttons[row][col].setBackground(Color.black);
				col--;
				pentla--;
			}
			statkiDocelowe++;
			tabela.czyscGracza(buttons);
			poczatekStatku = true;
		} else if (tabela.getPole(row, col) == 54) {
			int pentla = dlugoscStatku;
			while (pentla != 0) {
				source.setBackground(Color.black);
				tabela.ustawPole(wyslany, row, col);
				buttons[row][col].setBackground(Color.black);
				col++;
				pentla--;
			}
			statkiDocelowe++;
			tabela.czyscGracza(buttons);
			poczatekStatku = true;
		} else if (tabela.getPole(row, col) == 4) {
			tabela.czyscGracza(buttons);
			poczatekStatku = true;
		}
	}

	public void dopasowanieStatku(int row, int col, int wyslany, JButton source) {
		if (tabela.getPole(row, col) == 1) {
			if (dlugoscStatku == 2) {
				if (dlugoscStatku + row < 12 && tabela.getPole(dlugoscStatku + row - 1, col) == 1) {
					source.setBackground(Color.red);
					buttons[dlugoscStatku + row - 1][col].setBackground(Color.blue);
					poczatekStatku = false;
					tabela.ustawPole(4, row, col);
					tabela.ustawPole(65, dlugoscStatku + row - 1, col);
					tabela.print();
				}
				if (row - dlugoscStatku + 1 > 0 && tabela.getPole(row - dlugoscStatku + 1, col) == 1) {
					source.setBackground(Color.red);
					buttons[row - dlugoscStatku + 1][col].setBackground(Color.blue);
					poczatekStatku = false;
					tabela.ustawPole(4, row, col);
					tabela.ustawPole(45, row - dlugoscStatku + 1, col);
					tabela.print();
				}
				if (dlugoscStatku + col < 12 && tabela.getPole(row, dlugoscStatku + col - 1) == 1) {
					source.setBackground(Color.red);
					buttons[row][dlugoscStatku + col - 1].setBackground(Color.blue);
					poczatekStatku = false;
					tabela.ustawPole(4, row, col);
					tabela.ustawPole(56, row, dlugoscStatku + col - 1);
					tabela.print();
				}
				if (col - dlugoscStatku + 1 > 0 && tabela.getPole(row, col - dlugoscStatku + 1) == 1) {
					source.setBackground(Color.red);
					buttons[row][col - dlugoscStatku + 1].setBackground(Color.blue);
					poczatekStatku = false;
					tabela.ustawPole(55, row, col);
					tabela.ustawPole(54, row, col - dlugoscStatku + 1);
					tabela.print();
				}
			} else {
				if (dlugoscStatku + row < 12 && tabela.getPole(dlugoscStatku + row - 1, col) == 1) {
					System.out.println("statek dlurzyszy niż 2");
					wnetrzeStatku = true; // true
					int pentla = dlugoscStatku ;
					System.out.println(wnetrzeStatku + " wnetrzeStatku");
					System.out.println(dlugoscStatku + "dlugoscStatku");
					System.out.println(pentla + "pentla przed");
					while (pentla != 0) {
						System.out.println(pentla + "pentla w");
						if (tabela.getPole(row, col) != 1) {
							System.out.println(tabela.getPole(row, col) + "tabela.getPole(row, col)");
							System.out.println(wnetrzeStatku + " wnetrzeStatku");
							wnetrzeStatku = false;
						}
						row++;
						pentla--;
					}
					row = row - dlugoscStatku;
					if (wnetrzeStatku) {
						source.setBackground(Color.red);
						buttons[dlugoscStatku + row - 1][col].setBackground(Color.blue);
						poczatekStatku = false;
						punktKlikniecia= true;
						tabela.ustawPole(65, dlugoscStatku + row - 1, col);
						tabela.print();
					}
				}
				if (row - dlugoscStatku + 1 > 0 && tabela.getPole(row - dlugoscStatku + 1, col) == 1) {
					System.out.println("statek dlurzyszy niż 2");
					wnetrzeStatku = true; // true
					int pentla = dlugoscStatku;

					while (pentla != 0) {
						if (tabela.getPole(row, col) != 1) {
							wnetrzeStatku = false;
						}
						row--;
						pentla--;
					}
					row = row + dlugoscStatku;
					if (wnetrzeStatku) {
						source.setBackground(Color.red);
						buttons[row - dlugoscStatku + 1][col].setBackground(Color.blue);
						poczatekStatku = false;
						punktKlikniecia= true;
						tabela.ustawPole(45, row - dlugoscStatku + 1, col);
						tabela.print();
					}
				}
				if (dlugoscStatku + col < 12 && tabela.getPole(row, dlugoscStatku + col - 1) == 1) {
					System.out.println("statek dlurzyszy niż 2");
					wnetrzeStatku = true; // true
					int pentla = dlugoscStatku;

					while (pentla != 0) {
						if (tabela.getPole(row, col) != 1) {
							wnetrzeStatku = false;
						}
						col++;
						pentla--;
					}
					col = col - dlugoscStatku;
					if (wnetrzeStatku) {
						source.setBackground(Color.red);
						buttons[row][dlugoscStatku + col - 1].setBackground(Color.blue);
						poczatekStatku = false;
						punktKlikniecia= true;
						tabela.ustawPole(56, row, dlugoscStatku + col - 1);
						tabela.print();
					}
				}
				if (col - dlugoscStatku + 1 > 0 && tabela.getPole(row, col - dlugoscStatku + 1) == 1) {
					System.out.println("statek dlurzyszy niż 2");
					wnetrzeStatku = true; // true
					int pentla = dlugoscStatku;

					while (pentla != 0) {
						if (tabela.getPole(row, col) != 1) {
							wnetrzeStatku = false;
						}
						col--;
						pentla--;
					}
					col = col + dlugoscStatku;
					if (wnetrzeStatku) {
						source.setBackground(Color.red);
						buttons[row][col - dlugoscStatku + 1].setBackground(Color.blue);
						poczatekStatku = false;
						punktKlikniecia= true;
						tabela.ustawPole(54, row, col - dlugoscStatku + 1);
						tabela.print();
					}
				}
				if(punktKlikniecia) {
					tabela.ustawPole(4, row, col);
					punktKlikniecia= false;
				}
			}
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
					}
				}
			}
			if (poziomStatku == 1) {
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
					}
				}
			}
			if (poziomStatku == 2) {
				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
					statkiDocelowe = 0;
					statekNaMapie = statki.getKuter();
					dlugoscStatku = statki.getKuterDlugosc();
				} else {
					wyslany = 12;
					dopasowanieStatku(row, col, wyslany, source);
					if (statkiDocelowe == statekNaMapie) {
						poziomStatku++;
						statkiDocelowe = 0;
						statekNaMapie = statki.getKuter();
						dlugoscStatku = statki.getKuterDlugosc();
					}
				}
			}
			if (poziomStatku == 3) {
				if (statkiDocelowe == statekNaMapie) {
					poziomStatku++;
				} else {
					int wyslany = 13;
					dopasowanieStatku(row, col, wyslany, source);
					if (statkiDocelowe == statekNaMapie) {
						poziomStatku++;
					}
				}
			} else if (poziomStatku >= 4) {
				System.out.println("poziomStatku else koniec wstawiania statków pora włączyć grę");
				tabela.print();
			}
		} else {
			drukStatku(row, col, wyslany, source);
		}
	}
}
