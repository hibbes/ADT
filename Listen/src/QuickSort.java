/**
 * QuickSort – in der Praxis sehr schneller Sortieralgorithmus.
 *
 * <h2>Algorithmus-Idee</h2>
 * <ol>
 *   <li><b>Pivot wählen:</b> Element aus der Mitte als Referenzpunkt.</li>
 *   <li><b>Partitionieren:</b> Alle Elemente kleiner als Pivot links, alle größeren rechts.</li>
 *   <li><b>Rekursiv sortieren:</b> Linke und rechte Teilmenge separat sortieren.</li>
 * </ol>
 *
 * <p><b>Partitionierungs-Beispiel</b> für [5, 3, 8, 1, 4] (Pivot = 8):
 * <pre>
 *   links→          ←rechts
 *   [5, 3, 8, 1, 4]  Pivot = 8 (Mitte)
 *
 *   Alle Elemente &lt; 8 bleiben links, alle &gt; 8 gehen rechts.
 *   Ergebnis: [..., 8, ...] mit 8 an richtiger Position.
 * </pre></p>
 *
 * <p><b>Zeitkomplexität:</b>
 * O(n log n) im Durchschnitt, O(n²) im schlechtesten Fall (bereits sortiertes Array
 * mit ungünstigem Pivot). In der Praxis meist schneller als MergeSort.</p>
 *
 * @author hibbes
 */
public class QuickSort {

    /**
     * Partitioniert den Teilbereich {@code liste[erstes..letztes]} um ein Pivot-Element.
     *
     * <p>Pivot = Element in der Mitte des Teilbereichs.<br>
     * Zwei Zeiger (links, rechts) bewegen sich aufeinander zu:
     * <ul>
     *   <li>Links wandert nach rechts, solange es Elemente kleiner als Pivot findet.</li>
     *   <li>Rechts wandert nach links, solange es Elemente größer als Pivot findet.</li>
     *   <li>Wenn beide anhalten: Elemente tauschen → kleinere links, größere rechts.</li>
     * </ul>
     * </p>
     *
     * @param liste   das zu sortierende Array
     * @param erstes  erster Index des Teilbereichs (inkl.)
     * @param letztes letzter Index des Teilbereichs (inkl.)
     * @return der Index, ab dem die rechte Teilmenge beginnt
     */
    public int teilung(int[] liste, final int erstes, final int letztes) {
        int pivot = liste[(erstes + letztes) / 2];  // Pivot = Mittelelement

        int positionLinks  = erstes;
        int positionRechts = letztes;

        while (positionLinks <= positionRechts) {
            // Links vorwärts: solange Elemente kleiner als Pivot
            while (liste[positionLinks]  < pivot) positionLinks++;
            // Rechts rückwärts: solange Elemente größer als Pivot
            while (liste[positionRechts] > pivot) positionRechts--;

            // Tauschen wenn linker Zeiger noch nicht hinter rechtem
            if (positionLinks <= positionRechts) {
                int tmp = liste[positionLinks];
                liste[positionLinks]  = liste[positionRechts];
                liste[positionRechts] = tmp;
                positionLinks++;
                positionRechts--;
            }
        }
        return positionLinks;  // Trennpunkt für rekursive Aufrufe
    }

    /**
     * Sortiert den Teilbereich {@code liste[erstes..letztes]} rekursiv.
     *
     * <p>Nach der Partitionierung ({@link #teilung}) sind zwei Teilbereiche
     * entstanden. Jeder wird rekursiv sortiert.</p>
     *
     * @param liste   das zu sortierende Array
     * @param erstes  erster Index (inkl.)
     * @param letztes letzter Index (inkl.)
     */
    public void quicksort(int[] liste, final int erstes, final int letztes) {
        int index = teilung(liste, erstes, letztes);  // Partitionieren

        // Linke Teilmenge rekursiv sortieren (falls mehr als 1 Element)
        if (erstes < index - 1) {
            quicksort(liste, erstes, index - 1);
        }
        // Rechte Teilmenge rekursiv sortieren (falls mehr als 1 Element)
        if (index < letztes) {
            quicksort(liste, index, letztes);
        }
    }
}
