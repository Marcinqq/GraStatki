package mapa;

public class Statki {
	private int lotniskowiec;// 5
	private int niszczyciel;// 4
	private int krarzownik;// 3
	private int kuter;// 2
	private final int lotniskowiecDlugosc = 5;// 5
	private final int niszczycielDlugosc = 4;// 4
	private final int krarzownikDlugosc = 3;// 3
	private final int kuterDlugosc = 2;// 2
	private int wejscie;

	public Statki(int wejscie) {
		this.wejscie = wejscie;
		if (wejscie == 1) {
			lotniskowiec = 1;
			niszczyciel = 1;
			krarzownik = 2;
			kuter = 4;
		} else if (wejscie == 2) {
			lotniskowiec = 2;
			niszczyciel = 2;
			krarzownik = 1;
			kuter = 1;
		} else if (wejscie == 3) {
			lotniskowiec = 4;
			niszczyciel = 0;
			krarzownik = 0;
			kuter = 4;
		} else {
			lotniskowiec = 1;
			niszczyciel = 0;
			krarzownik = 0;
			kuter = 1;
		}

	}

	public int getLotniskowiec() {
		return lotniskowiec;
	}

	public void downLotniskowiec() {
		lotniskowiec--;
	}

	public int getNiszczyciel() {
		return niszczyciel;
	}

	public void downNiszczyciel() {
		niszczyciel--;
	}

	public int getKrarzownik() {
		return krarzownik;
	}

	public void downKrarzownik() {
		krarzownik--;
	}

	public int getKuter() {
		return kuter;
	}

	public void downKuter() {
		kuter--;
	}

	public int getLotniskowiecDlugosc() {
		return lotniskowiecDlugosc;
	}

	public int getNiszczycielDlugosc() {
		return niszczycielDlugosc;
	}

	public int getKrarzownikDlugosc() {
		return krarzownikDlugosc;
	}

	public int getKuterDlugosc() {
		return kuterDlugosc;
	}
}
