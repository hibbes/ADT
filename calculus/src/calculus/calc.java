package calculus;

/**
 * calc.java  –  ADT / calculus-Paket
 *
 * Minimalbeispiel zur Demonstration von Gleitkomma-Arithmetik in Java.
 *
 * <h3>Was passiert hier?</h3>
 * Das Programm berechnet den Ausdruck:
 * <pre>
 *   a = 0.3
 *   Ergebnis = (a / 3) * a  =  (0.3 / 3) * 0.3  =  0.1 * 0.3  =  0.03
 * </pre>
 *
 * <h3>Warum steht das im ADT-Projekt?</h3>
 * Vermutlich ein experimenteller Scratch-Code aus der Entwicklungsphase,
 * der versehentlich committet wurde. Die Klasse demonstriert keine
 * Datenstruktur, sondern Gleitkommaverhalten.
 *
 * <h3>Gleitkommazahlen in Java:</h3>
 * {@code double} verwendet IEEE 754 mit 64 Bit (53 Bit Mantisse).
 * Viele Dezimalbrüche wie 0.3 sind binär nicht exakt darstellbar:
 * <pre>
 *   0.3  → binär: 0.0100110011001100... (unendlich wiederholend)
 * </pre>
 * Daher kann das Ergebnis minimal von 0.03 abweichen, z.B.:
 * <pre>
 *   (0.3 / 3) * 0.3  →  0.030000000000000002
 * </pre>
 * Für exakte Dezimalrechnung (z.B. Geldbeträge) sollte man
 * {@link java.math.BigDecimal} verwenden.
 */
public class calc {

    /**
     * Einstiegspunkt – berechnet und gibt (a/3)*a aus.
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {

        double a = 0.3;

        // Berechne (a/3)*a = (0.3/3)*0.3 = 0.1*0.3
        // Erwartetes Ergebnis: 0.03
        // Tatsächlich (IEEE 754): 0.030000000000000002
        System.out.println((a / 3) * a);

    }

}
