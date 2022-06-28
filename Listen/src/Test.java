
public class Test {

	public static void main(String[] args) {
		Liste liste = new Liste(3);
		liste.add(5);
		liste.add(7);
		liste.add(9);
		liste.add(12);
		liste.add(13);
		liste.add(7);
		System.out.println(liste);
		System.out.println(liste.counter());
		
	}

}
