package poleGry;

public class TabelaGracza {

	private int[][] pole = new int[12][12];

	// 1 pole puste
	// 2 pudło
	// 3 trariony
	// 10 lotniskowiec
	// 11 niszczyciel
	// 12 krarzownik
	// 13 kuter
	public TabelaGracza() {
		for (int i = 0; i < pole.length; i++) {
			for (int j = 0; j < pole[i].length; j++) {
				pole[i][j] = 1;
			}
		}

	}

	public void ustawPole(int wgrywanie, int i, int j) {

		pole[i][j] = wgrywanie;
		;
	}

	public void klikAtak(int[][] pole) {

	}

	public int getPole(int i, int j) {
		
		if(i>10||j>10||i<1||j<1) {
			
		return 11;
		}
		
		
		return pole[i][j];
	}

	public void print() {
		for (int i = 0; i < pole.length; i++) {
			for (int j = 0; j < pole[i].length; j++) {
				System.out.print(pole[i][j] + " ");
			}
			System.out.println();
		}
	}

}
