
public class QuickSort {

	public int teilung(int liste[], final int erstes, final int letztes) {
		int pivot = liste[(erstes + letztes) / 2];

		int positionLinks = erstes;

		int positionRechts = letztes;

		while (positionLinks <= positionRechts) {
			while (liste[positionLinks] < pivot) {
				positionLinks++;
			}

			while (liste[positionRechts] > pivot) {
				positionRechts--;
			}
//
			if (positionLinks <= positionRechts) {
				int tmp = liste[positionLinks];
				liste[positionLinks] = liste[positionRechts];
				liste[positionRechts] = tmp;
				positionLinks++;
				positionRechts--;
			}
		}
    
		return positionLinks;

	}

	public void quicksort(int liste[], final int erstes, final int letztes) {
		int index = teilung(liste, erstes, letztes);

		if (erstes < index - 1) {
			quicksort(liste, erstes, index-1);
		}

		if (index < letztes) {
			quicksort(liste, index, letztes);
		}
	}
}
