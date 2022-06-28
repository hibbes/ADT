public class ListenElement {

	private int inhalt;
	private ListenElement next;

	public ListenElement(int inhalt) {
		this.inhalt = inhalt;
	}

	public void add(ListenElement neu) {
		if (next == null) {
			next = neu;
		} else {
			next.add(neu);
		}
	}

	public String toString() {
		if (next == null) {
			return "" + inhalt;
		} else {
			return ""+inhalt+" "+next.toString();
		}
	}
	
	public int count() {
		if(next == null) {
			return 1;
		}else {
			return 1+next.count();
		}
			
		}
		
		public int addition() {
			if(next == null) {
				return inhalt;
			}else {
				return inhalt+next.addition();
				
				
			}
		
	}
	

}
