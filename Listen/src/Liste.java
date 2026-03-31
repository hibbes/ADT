/**
 * Einfach verkettete Liste ganzer Zahlen.
 *
 * <p>Eine <b>verkettete Liste</b> ist eine dynamische Alternative zum Array:
 * Elemente können jederzeit hinzugefügt oder entfernt werden, ohne die Größe
 * im Voraus angeben zu müssen. Der Nachteil: kein direkter Zugriff per Index
 * (man muss immer von vorne durchgehen).</p>
 *
 * <p>Diese Klasse verwaltet den Kopf ({@code kopf}) der Liste. Alle Operationen
 * werden über {@link ListenElement}-Methoden rekursiv auf der Knotenkette
 * ausgeführt.</p>
 *
 * <p><b>Visualisierung:</b>
 * <pre>
 *   Liste               ListenElement        ListenElement
 *   [kopf] ──────────▶  [inhalt=3, next] ──▶ [inhalt=5, next=null]
 * </pre></p>
 *
 * @author hibbes
 * @see ListenElement
 */
public class Liste {

    /**
     * Zeiger auf den ersten Knoten der Liste.
     * Über {@code kopf} erreicht man die gesamte Liste.
     */
    private ListenElement kopf;

    /**
     * Hilfsvariable für interne Umstrukturierungen (z. B. addHead).
     */
    private ListenElement temp;

    /**
     * Erstellt eine Liste mit einem einzigen Element.
     *
     * @param wert erster Wert der Liste
     */
    public Liste(int wert) {
        kopf = new ListenElement(wert);
    }

    /**
     * Hängt einen neuen Wert ans Ende der Liste.
     *
     * @param wert der hinzuzufügende Wert
     */
    public void add(int wert) {
        kopf.add(new ListenElement(wert));
    }

    /**
     * Fügt einen neuen Wert am Anfang der Liste ein (als neues erstes Element).
     *
     * <p>Der neue Knoten wird zum neuen Kopf, der bisherige Kopf wird
     * an den neuen Knoten gehängt.</p>
     *
     * @param wert der als erstes einzufügende Wert
     */
    public void addHead(int wert) {
        temp = kopf;                          // alten Kopf merken
        kopf = new ListenElement(wert);       // neuer Kopf
        kopf.add(temp);                       // alten Kopf anhängen
    }

    /**
     * Entfernt den ersten Knoten mit dem angegebenen Wert.
     *
     * <p>Ist der Kopf selbst der gesuchte Knoten, wird der Kopfzeiger
     * auf den nächsten Knoten gesetzt.</p>
     *
     * @param wert der zu entfernende Wert
     */
    public void remove(int wert) {
        if (kopf.get() == wert) {
            kopf = kopf.getNext();    // Kopf entfernen: Kopfzeiger weiterschieben
        }
        kopf.remove(wert);            // Weitersuchen im Rest der Liste
    }

    /**
     * Gibt erstes und letztes Element der Liste auf der Konsole aus.
     */
    public void firstLast() {
        System.out.print(kopf.get() + " ");   // Erstes Element
        kopf.firstLast();                      // Letztes Element (rekursiv)
    }

    /**
     * Sucht einen Wert in der Liste.
     *
     * @param wert gesuchter Wert
     * @return gefundener Wert oder {@code -1}
     */
    public int find(int wert) {
        return kopf.find(wert);
    }

    /**
     * @return alle Elemente als String, durch Leerzeichen getrennt
     */
    @Override
    public String toString() {
        return kopf.toString();
    }

    /**
     * @return Anzahl der Elemente in der Liste
     */
    public int counter() {
        return kopf.count();
    }
}
