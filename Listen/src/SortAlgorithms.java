/**
 * SortAlgorithms.java  –  ADT / Listen-Projekt
 *
 * Enthält zwei klassische Sortierverfahren:
 *   1. BubbleSort   – O(n²), einfach, aber langsam
 *   2. SelectionSort – O(n²), etwas besser in der Praxis als BubbleSort
 *
 * Beide Verfahren arbeiten „in-place" auf dem übergebenen Array-Objekt.
 * In Java sind Arrays Referenztypen – die Zuweisung
 *       int[] sort = array;
 * erzeugt KEINE Kopie, sondern zeigt sort auf dasselbe Objekt im Heap.
 * Dadurch wird das Original-Array ebenfalls verändert!
 *
 * ──────────────────────────────────────────────────────────────────────
 * Bekannter Bug in bubbleSort():
 * Das Dekrement `length--` steht INNERHALB der inneren for-Schleife.
 * Dadurch wird die obere Schranke bei jedem Vergleichsschritt
 * verkleinert, nicht erst nach einem vollständigen Durchlauf.
 * Das führt dazu, dass die Schleife vorzeitig abbricht und das Array
 * nur teilweise sortiert wird.
 *
 * Korrekte Platzierung: `length--` muss nach der for-Schleife stehen
 * (aber noch innerhalb der while-Schleife).
 * ──────────────────────────────────────────────────────────────────────
 *
 * Weiterführende Sortierverfahren (O(n log n)):
 *   → MergeSort.java, QuickSort.java in diesem Projekt
 */
public class SortAlgorithms {

    /** Testdaten: gemischtes Array mit negativem Wert und Duplikaten */
    static int[] array = { 4, 5, 9, 1, 5, 90, 8, 4, 5, 3, -1 };

    /**
     * Einstiegspunkt – hier kann man die Sortiermethoden manuell aufrufen
     * und testen. Für automatisierte Laufzeitmessungen → Test.java.
     */
    public static void main(String[] args) {
        // Zum Testen: ausgabe(bubbleSort(array));
        // Zum Testen: ausgabe(selectionSort(array));
    }

    // ──────────────────────────────────────────────────────────────────
    //  BubbleSort
    // ──────────────────────────────────────────────────────────────────
    /**
     * Sortiert ein Integer-Array aufsteigend mit dem BubbleSort-Verfahren.
     *
     * <h3>Idee:</h3>
     * In jedem Durchlauf werden benachbarte Elemente verglichen.
     * Ist das linke größer als das rechte, werden sie getauscht.
     * Das größte Element "blubbert" dadurch ans Ende – wie eine Blase
     * die nach oben steigt (→ Name „Bubble").
     *
     * <pre>
     * Durchlauf 1: [4, 5, 9, 1, 5, 90, 8, 4, 5, 3, -1]
     *   → 90 blubbert ans Ende: [..., 90]
     * Durchlauf 2: verbleibende n-1 Elemente werden sortiert
     * ...
     * </pre>
     *
     * <h3>Laufzeit:</h3>
     * <ul>
     *   <li>Best case:  O(n²) – keine Frühabbuch-Optimierung implementiert</li>
     *   <li>Worst case: O(n²)</li>
     * </ul>
     *
     * <h3>Historischer Bug:</h3>
     * <p>Eine frühere Version hatte {@code length--} <b>innerhalb</b> der
     * inneren for-Schleife stehen. Dadurch wurde die Schranke bei jedem
     * Einzelvergleich verkleinert, sodass die Sortierung zu früh abbrach
     * und das Array nur teilweise sortiert wurde.</p>
     *
     * <p>Die korrekte Platzierung ({@code length--} nach der for-Schleife)
     * ist in der aktuellen Fassung umgesetzt – so wie es sein soll.</p>
     *
     * @param array Das zu sortierende Array (wird in-place verändert!)
     * @return Dasselbe Array-Objekt, aufsteigend sortiert
     */
    public static int[] bubbleSort(int[] array) {

        int[] sort = array;               // Achtung: Referenz, keine Kopie!
        int length = sort.length - 1;     // obere Grenze des unsortierten Bereichs
        int tmp;                          // Hilfsvariable für den Tausch

        while (length > 0) {
            for (int i = 0; i < length; i++) {
                if (sort[i] > sort[i + 1]) {
                    // Nachbarn vertauschen: der größere Wert „wandert" nach rechts
                    tmp         = sort[i];
                    sort[i]     = sort[i + 1];
                    sort[i + 1] = tmp;
                }
            }
            length--;   // nach einem vollständigen Durchlauf ist das größte
                        // Element am Ende → obere Grenze schrumpft um 1
        }
        return sort;
    }

    // ──────────────────────────────────────────────────────────────────
    //  SelectionSort
    // ──────────────────────────────────────────────────────────────────
    /**
     * Sortiert ein Integer-Array aufsteigend mit dem SelectionSort-Verfahren.
     *
     * <h3>Idee:</h3>
     * In jedem Durchlauf wird das kleinste Element im unsortierten
     * Restbereich gesucht und an die erste Position dieses Bereichs
     * geschrieben. Der sortierte Bereich wächst damit um 1.
     *
     * <pre>
     * Ausgangslage:  [4, 5, 9, 1, 5, 90, 8, 4, 5, 3, -1]
     *                 ↑ counter=0, suche kleinstes ab hier
     *
     * Durchlauf 1:   Kleinstes = -1 → tausche mit Position 0
     *               [-1, | 5, 9, 1, 5, 90, 8, 4, 5, 3, 4]
     *
     * Durchlauf 2:   Kleinstes im Rest = 1 → tausche mit Position 1
     *               [-1, 1, | 9, 5, 5, 90, 8, 4, 5, 3, 4]
     * ...
     * </pre>
     *
     * <h3>Besonderheit dieser Implementierung:</h3>
     * Statt die Position des Minimums zu merken, wird das Minimum
     * schrittweise durch den Restbereich „gezogen" (per swap-Kette).
     * Das ist korrekt, aber ineffizienter als der klassische Ansatz,
     * bei dem nur einmal am Ende getauscht wird.
     *
     * <h3>Laufzeit:</h3>
     * <ul>
     *   <li>Immer O(n²) – unabhängig von der Eingabe</li>
     *   <li>Vorteil gegenüber BubbleSort: weniger Schreiboperationen</li>
     * </ul>
     *
     * @param array Das zu sortierende Array (wird in-place verändert!)
     * @return Dasselbe Array-Objekt, aufsteigend sortiert
     */
    public static int[] selectionSort(int[] array) {
        int[] sort = array;  // Referenz auf dasselbe Objekt – kein Kopieren

        int counter = 0;     // Beginn des unsortierten Bereichs
        int number = 0;      // das aktuell "gezogene" (kleinste bekannte) Element
        int tmp = 0;         // Hilfsvariable für den Tausch

        // Äußere Schleife: wächst den sortierten Bereich von vorne auf
        for (int i = 0; i < sort.length - 1; i++) {
            number = sort[i];  // Kandidat: aktuell erstes Element im Restbereich

            // Innere Schleife: sucht das Minimum im Restbereich
            // und "zieht" es nach vorne (swap-Kette)
            for (int j = counter; j < sort.length - 1; j++) {
                if (number > sort[j + 1]) {
                    // sort[j+1] ist kleiner → nach vorne tauschen
                    tmp = sort[j + 1];
                    sort[j + 1] = number;
                    number = tmp;
                }
            }

            sort[counter] = number;  // Minimum an die sortierte Position schreiben
            counter++;               // sortierter Bereich wächst um 1
        }

        return sort;
    }

    // ──────────────────────────────────────────────────────────────────
    //  Hilfsfunktion
    // ──────────────────────────────────────────────────────────────────
    /**
     * Gibt alle Elemente eines Integer-Arrays zeilenweise auf der Konsole aus.
     *
     * @param array Das auszugebende Array
     */
    public static void ausgabe(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println(array[i] + " ");
        }
    }

}
