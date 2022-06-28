 public class Liste {

		private ListenElement kopf;
	
	public Liste (int wert) {
		kopf=new ListenElement(wert);
	}
	public void add (int wert) {
		kopf.add(new ListenElement(wert));
	}
	public String toString() {
		return kopf.toString();
	}
	
	//Elemente zählen
	
	public int counter() {
	   return kopf.count();
	}
	
	
	
}
