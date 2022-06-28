 public class Liste {

		private ListenElement kopf;
		private ListenElement temp;
	
	public Liste (int wert) {
		kopf=new ListenElement(wert);
	}
	public void add (int wert) {
		kopf.add(new ListenElement(wert));
	}
	
	public void addHead(int wert) {
		temp=kopf;
		kopf= new ListenElement(wert);
		kopf.add(temp);
	}
	
	public void firstLast() {
		System.out.print(kopf.get()+" ");
		kopf.firstLast();
	}
	
	public String toString() {
		return kopf.toString();
	}
	
	//Elemente zählen
	
	public int counter() {
	   return kopf.count();
	}
	
	
	
}
