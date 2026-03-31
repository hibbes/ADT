import java.util.Arrays;
import java.util.Random;

/**
 * Test.java  –  ADT / Listen-Projekt
 *
 * Laufzeit-Benchmark der implementierten Sortieralgorithmen.
 *
 * <h3>Was passiert hier?</h3>
 * <ol>
 *   <li>Ein zufälliges Integer-Array wird generiert.</li>
 *   <li>Das Array wird für jeden Algorithmus frisch kopiert
 *       (mittels {@link System#arraycopy}), damit alle denselben
 *       Ausgangszustand haben.</li>
 *   <li>Die Laufzeit jedes Algorithmus wird mit
 *       {@link System#currentTimeMillis()} gemessen.</li>
 * </ol>
 *
 * <h3>Erwartetes Ergebnis für große n:</h3>
 * <pre>
 *   QuickSort     O(n log n)  →  sehr schnell
 *   SelectionSort O(n²)       →  deutlich langsamer
 *   BubbleSort    O(n²)       →  ähnlich wie SelectionSort (Bugfix nötig!)
 * </pre>
 *
 * <h3>Hinweis:</h3>
 * {@link System#currentTimeMillis()} misst Wanduhrzeit (Wall-Clock-Time),
 * nicht reine CPU-Zeit. Für präzisere Messungen eignet sich
 * {@link System#nanoTime()}.
 *
 * <h3>Auskommentierter Code am Ende:</h3>
 * Testet die verkettete Liste (Liste.java) – wurde während der Entwicklung
 * genutzt und als Dokumentation beibehalten.
 */
public class Test {
    /** Startzeitpunkt der Messung in Millisekunden seit dem 1.1.1970 */
    static long startTime = 0;

    /** Länge des zu sortierenden Arrays – hier bewusst klein (10).
     *  Für aussagekräftige Laufzeitmessungen: mind. 100.000 empfohlen. */
    static int length = 10;

    /** Endzeitpunkt der Messung */
    static long endTime = 0;

    /**
     * Einstiegspunkt des Programms.
     * Erzeugt ein zufälliges Array und lässt es von allen
     * Sortieralgorithmen nacheinander sortieren.
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {

        // ── Zufälliges Testarray generieren ───────────────────────────
        Random rand = new Random();
        int[] numbers = new int[length];   // Originalwerte – werden nie verändert
        int[] toSort  = new int[length];   // Arbeitskopie für jeden Algorithmus

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);  // Zufallszahlen 0–999.999
        }

        QuickSort q = new QuickSort();

        // ── 1. QuickSort ──────────────────────────────────────────────
        // System.arraycopy(src, srcPos, dest, destPos, length):
        // Kopiert 'numbers' vollständig in 'toSort' – jeder Algorithmus
        // erhält exakt dieselbe Ausgangssortierung.
        System.arraycopy(numbers, 0, toSort, 0, numbers.length);
        System.out.println("QuickSort");
        startTime = System.currentTimeMillis();
        q.quicksort(toSort, 0, toSort.length - 1);   // rekursiver In-place-Sort
        endTime = System.currentTimeMillis();
        System.out.print("Zeit: ");
        System.out.println(endTime - startTime);      // Laufzeit in ms
        System.out.println(Arrays.toString(toSort));  // sortiertes Ergebnis

        // ── 2. SelectionSort ──────────────────────────────────────────
        System.arraycopy(numbers, 0, toSort, 0, numbers.length);  // Array zurücksetzen
        System.out.println("SelectionSort");
        System.out.println(Arrays.toString(SortAlgorithms.selectionSort(toSort)));
        // Hinweis: keine Zeitmessung hier – leicht ergänzbar wie bei QuickSort

        // ── 3. BubbleSort ─────────────────────────────────────────────
        System.arraycopy(numbers, 0, toSort, 0, numbers.length);  // Array zurücksetzen
        System.out.println("BubbleSort");
        System.out.println(Arrays.toString(SortAlgorithms.bubbleSort(toSort)));
        // ⚠ Achtung: BubbleSort enthält einen Bug (length-- falsch platziert)
        // → Ergebnis kann falsch/unsortiert sein! Siehe SortAlgorithms.java.

    }

}

//
/*
 * ── Auskommentierter Test für Liste.java ──────────────────────────────────
 *
 * Liste liste = new Liste(3);   // Kopf mit Wert 3
 * liste.add(5);                 // 3 → 5
 * liste.add(43);                // 3 → 5 → 43
 * liste.add(9);
 * liste.add(12);
 * liste.add(13);
 * liste.add(7);                 // 3 → 5 → 43 → 9 → 12 → 13 → 7
 *
 * System.out.println(liste);
 *
 * liste.addHead(42);            // 42 → 3 → 5 → 43 → 9 → 12 → 13 → 7
 * System.out.println(liste);
 *
 * System.out.println(liste.counter());   // Länge: 8
 *
 * liste.firstLast();            // Gibt erstes und letztes Element aus
 *
 * System.out.println("\n" + liste.find(4));  // Suche nach Index 4 → Wert 12
 *
 * liste.remove(7);              // Element mit Wert 7 entfernen
 * System.out.println(liste);
 */
