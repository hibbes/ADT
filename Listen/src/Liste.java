public class Liste {

	private ListenElement kopf;
	private ListenElement temp;

	public Liste(int wert) {
		kopf = new ListenElement(wert);
	}

	public void add(int wert) {
		kopf.add(new ListenElement(wert));
	}

	public void addHead(int wert) {
		temp = kopf;
		kopf = new ListenElement(wert);
		kopf.add(temp);
	}

	public void remove(int wert) {
		if (kopf.get() == wert) {
			kopf = kopf.getNext();
		}
		kopf.remove(wert);
	}

	public void firstLast() {
		System.out.print(kopf.get() + " ");
		kopf.firstLast();
	}

	public int find(int wert) {
		return kopf.find(wert);
	}

	public String toString() {
		return kopf.toString();
	}

	// Elemente zählen

	public int counter() {
		return kopf.count();
	}

}
