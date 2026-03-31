import java.util.Random;

/**
 * MergeSort – effizienter Sortieralgorithmus nach dem "Teile und Herrsche"-Prinzip.
 *
 * <h2>Algorithmus-Idee</h2>
 * <ol>
 *   <li><b>Teile:</b> Halbiere das Array in zwei gleich große Hälften.</li>
 *   <li><b>Sortiere rekursiv:</b> Sortiere jede Hälfte für sich.</li>
 *   <li><b>Zusammenführen (Merge):</b> Füge die zwei sortierten Hälften zu einem
 *       sortierten Array zusammen.</li>
 * </ol>
 *
 * <p><b>Visualisierung für [5, 3, 8, 1, 4]:</b>
 * <pre>
 *   [5, 3, 8, 1, 4]
 *   ↙               ↘
 *   [5, 3]         [8, 1, 4]
 *   ↙    ↘         ↙       ↘
 *   [5]  [3]     [8]     [1, 4]
 *                        ↙   ↘
 *                       [1]  [4]
 *   ↘    ↙      ↘       ↙
 *   [3, 5]      [8]   [1, 4]
 *          ↘         ↙
 *           [1, 4, 8]
 *      ↘              ↙
 *       [1, 3, 4, 5, 8]  ← fertig!
 * </pre></p>
 *
 * <p><b>Zeitkomplexität:</b> O(n log n) – auch im schlimmsten Fall.
 * Deutlich besser als BubbleSort oder SelectionSort (O(n²)) für große Arrays.</p>
 *
 * @author hibbes
 */
public class MergeSort {

    /**
     * Erzeugt ein zufälliges Array, sortiert es mit MergeSort und gibt
     * vorher und nachher aus.
     *
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        System.out.println("Vorher:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nNachher:");
        printArray(numbers);
    }

    /**
     * Sortiert das Array rekursiv mit MergeSort.
     *
     * <p>Basisfall: Array mit 0 oder 1 Element ist bereits sortiert (return).<br>
     * Rekursionsschritt: In zwei Hälften teilen, jede sortieren, dann mergen.</p>
     *
     * @param inputArray das zu sortierende Array (wird in-place modifiziert)
     */
    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        // Basisfall: Array mit 0 oder 1 Elementen ist bereits sortiert
        if (inputLength < 2) return;

        // Mittelpunkt berechnen und Array aufteilen
        int midIndex    = inputLength / 2;
        int[] leftHalf  = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        // Linke Hälfte befüllen (Index 0 bis midIndex-1)
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        // Rechte Hälfte befüllen (Index midIndex bis Ende)
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        // Rekursiv sortieren
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Zusammenführen
        merge(inputArray, leftHalf, rightHalf);
    }

    /**
     * Führt zwei sortierte Arrays zu einem sortierten Array zusammen.
     *
     * <p>Mit drei Zeigern (i = links, j = rechts, k = Zielarray) wird
     * jeweils das kleinere der beiden "vorderen" Elemente in das Zielarray
     * geschrieben.</p>
     *
     * @param inputArray Zielarray (wird überschrieben)
     * @param leftHalf   sortierte linke Hälfte
     * @param rightHalf  sortierte rechte Hälfte
     */
    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;

        // Solange beide Hälften noch Elemente haben: das kleinere nehmen
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k++] = leftHalf[i++];
            } else {
                inputArray[k++] = rightHalf[j++];
            }
        }
        // Rest der linken Hälfte anhängen (falls vorhanden)
        while (i < leftHalf.length)  inputArray[k++] = leftHalf[i++];
        // Rest der rechten Hälfte anhängen (falls vorhanden)
        while (j < rightHalf.length) inputArray[k++] = rightHalf[j++];
    }

    /**
     * Gibt alle Elemente des Arrays auf der Konsole aus.
     *
     * @param numbers das auszugebende Array
     */
    private static void printArray(int[] numbers) {
        for (int n : numbers) System.out.println(n);
    }
}
