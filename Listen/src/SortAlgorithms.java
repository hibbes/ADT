
public class SortAlgorithms {

	static int[] array = { 4, 5, 9, 1, 5, 90, 8, 4, 5, 3, -1 }; // zu sortierendes Array

	public static void main(String[] args) {

		
	}

	public static int[] bubbleSort(int[] array) {

		int[] sort = array;
		int length = sort.length - 1;
		int tmp = 0;

		while (length > 1) {

			for (int i = 0; i <= length; i++) {
				if (sort[i] > sort[i + 1]) {
					tmp = sort[i];
					sort[i] = sort[i + 1];
					sort[i + 1] = tmp;
				}
				length--;
			}

		}
		return sort;
	}

	public static int[] selectionSort(int[] array) {
		int[] sort = array; // array wird in ein Arbeitsarray überschrieben.

		int counter = 0; // Zähler, der den Beginn des Sorierbereiches anzeigt.
		int number = 0; // Speicher für die "Selected" Zahl.
		int tmp = 0; // Hilfsvariable für Kopiervorgang

		for (int i = 0; i < sort.length - 1; i++) { // Schleife, die die Suchvorgänge von Feld 0 bis zum letzten Feld
													// steuert. Schleife Endet, wenn letztes Feld als kleinste,
													// sortierende Zahl markiert.
			number = sort[i];

			for (int j = counter; j < sort.length - 1; j++) { // Schleife, die den Suchdurchgang für das jeweils erste
																// Arrayfeld steuert und damit alle Felder
																// durchklappert.
				if (number > sort[j + 1]) { // wenn Zahl im ersten Feld größer als Vergleichsfeld...
					tmp = sort[j + 1];
					sort[j + 1] = number;
					number = tmp;
				} // ...tausche die Werte
			}
			sort[counter] = number; // Schreibe gefundene kleinste Zahl in erstes Feld.
			counter++; // Erstes Feld ist hier sortiert, zähle Anfangsbereich für nächsten Durchgang um
						// 1 hoch.
		}

		return sort;
	}

	public static void ausgabe(int[] array) {
		for (int i = 0; i <= array.length - 1; i++) {
			System.out.println(array[i] + " ");
		}
	}

}
