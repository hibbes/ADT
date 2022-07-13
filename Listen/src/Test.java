import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		QuickSort q = new QuickSort();
	    int[] zuSortieren = {3,6,1,9,7,1,6};
	    System.out.println(Arrays.toString(zuSortieren));
	    q.quicksort(zuSortieren,  0, 6);
	    System.out.println(Arrays.toString(zuSortieren));
		
	/*	Liste liste = new Liste(3);
		liste.add(5);
		liste.add(43);
		liste.add(9);
		liste.add(12);
		liste.add(13);
		liste.add(7);
		
		System.out.println(liste);
		
		liste.addHead(42);
		
		System.out.println(liste);
		
		
		System.out.println(liste.counter());
		
		liste.firstLast();
		
		System.out.println("\n"+liste.find(4));
		
		liste.remove(7);
		System.out.println(liste);
		*/
	} 

} 
