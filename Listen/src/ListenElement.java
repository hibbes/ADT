/**
 * Ein einzelnes Element (Knoten) einer einfach verketteten Liste.
 *
 * <p>Eine verkettete Liste besteht aus solchen Knoten: Jeder kennt seinen eigenen
 * Inhalt ({@code inhalt}) und zeigt auf den nächsten Knoten ({@code next}).
 * Der letzte Knoten zeigt auf {@code null}.</p>
 *
 * <p><b>Visualisierung:</b>
 * <pre>
 *   ListenElement(3) → ListenElement(5) → ListenElement(9) → null
 *   [inhalt=3, next]   [inhalt=5, next]   [inhalt=9, next=null]
 * </pre></p>
 *
 * <p>Alle Methoden (add, remove, find, count, …) sind <b>rekursiv</b> implementiert:
 * Jede Methode erledigt ihren Teil am aktuellen Knoten und delegiert den Rest
 * an {@code next}.</p>
 *
 * @author hibbes
 * @see Liste
 */
public class ListenElement {

    /** Der gespeicherte Wert dieses Knotens. */
    private int inhalt;

    /**
     * Zeiger auf den nächsten Knoten.
     * {@code null} wenn dies der letzte Knoten der Liste ist.
     */
    private ListenElement next;

    /**
     * Erstellt einen neuen Knoten mit dem angegebenen Wert.
     * {@code next} ist zunächst {@code null} (der Knoten steht allein).
     *
     * @param inhalt der zu speichernde Wert
     */
    public ListenElement(int inhalt) {
        this.inhalt = inhalt;
    }

    /**
     * Hängt einen neuen Knoten ans Ende der Liste.
     *
     * <p><b>Rekursion:</b><br>
     * - Ist {@code next == null}, sind wir am Ende → {@code next = neu}.<br>
     * - Sonst: geh weiter → {@code next.add(neu)}.</p>
     *
     * @param neu der anzuhängende Knoten
     */
    public void add(ListenElement neu) {
        if (next == null) {
            next = neu;          // Basisfall: Ende der Liste erreicht
        } else {
            next.add(neu);       // Rekursion: weiter zum nächsten Knoten
        }
    }

    /** @return der nachfolgende Knoten (oder {@code null} am Ende) */
    public ListenElement getNext() {
        return next;
    }

    /** @return der gespeicherte Wert dieses Knotens */
    public int get() {
        return inhalt;
    }

    /**
     * Entfernt den Knoten mit dem angegebenen Wert aus der Liste.
     *
     * <p>Kann nur Knoten entfernen, die <em>nach</em> dem aktuellen stehen
     * (den aktuellen Knoten selbst entfernt {@link Liste#remove(int)}).</p>
     *
     * @param wert der zu entfernende Wert
     */
    public void remove(int wert) {
        if (next != null) {
            if (next.get() == wert) {
                // Nachfolger ist der Gesuchte → überbrücken
                next = (next.getNext() != null) ? next.getNext() : null;
            } else {
                next.remove(wert);   // Rekursion: weiter suchen
            }
        }
    }

    /**
     * Sucht einen Wert in der Liste.
     *
     * @param wert gesuchter Wert
     * @return den gefundenen Wert oder {@code -1} wenn nicht vorhanden
     */
    public int find(int wert) {
        if (inhalt == wert) return inhalt;          // Basisfall: gefunden
        if (next == null)   return -1;              // Basisfall: nicht gefunden
        return next.find(wert);                     // Rekursion: weiter suchen
    }

    /**
     * Gibt das erste und das letzte Element der (Rest-)Liste aus.
     * (Vorgänger-Element gibt sich selbst aus; letzter Knoten gibt sich aus.)
     */
    public void firstLast() {
        if (next == null) {
            System.out.print(inhalt);   // Letzter Knoten
        } else {
            next.firstLast();           // Weiterreichen bis zum Ende
        }
    }

    /**
     * Gibt die Liste als String zurück (Elemente durch Leerzeichen getrennt).
     *
     * @return z. B. {@code "3 5 9 12"}
     */
    @Override
    public String toString() {
        if (next == null) return "" + inhalt;
        return inhalt + " " + next.toString();   // Rekursion: Rest anhängen
    }

    /**
     * Zählt die Anzahl der Knoten in der (Rest-)Liste inklusive dieses Knotens.
     *
     * @return Anzahl der Knoten
     */
    public int count() {
        if (next == null) return 1;          // Basisfall: einzelner Knoten
        return 1 + next.count();             // Rekursion: 1 + Länge des Rests
    }

    /**
     * Summiert alle Werte in der (Rest-)Liste.
     *
     * @return Summe aller Werte
     */
    public int addition() {
        if (next == null) return inhalt;
        return inhalt + next.addition();
    }
}
