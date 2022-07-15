import java.util.Arrays;
import java.util.Random;

public class Test {
	static long startTime = 0;
	static int length = 10;
	static long endTime = 0;

	public static void main(String[] args) {

		// Array generieren

		Random rand = new Random();
		int[] numbers = new int[length];
		int[] toSort = new int[length];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(1000000);
		}

		QuickSort q = new QuickSort();

		// Quicksort

		System.arraycopy(numbers, 0, toSort, 0, numbers.length);
		System.out.println("QuickSort");
		startTime = System.currentTimeMillis();
		q.quicksort(toSort, 0, toSort.length - 1);
		endTime = System.currentTimeMillis();
		System.out.print("Zeit: ");
		System.out.println(endTime-startTime);

		System.out.println(Arrays.toString(toSort));

		// SelectionSort
		System.arraycopy(numbers, 0, toSort, 0, numbers.length);
		System.out.println("SelectionSort");
		System.out.println(Arrays.toString(SortAlgorithms.selectionSort(toSort)));

		// BubbleSort
		System.arraycopy(numbers, 0, toSort, 0, numbers.length);
		System.out.println("BubbleSort");
		System.out.println(Arrays.toString(SortAlgorithms.bubbleSort(toSort)));

	}

}

//
/*
 * Liste liste = new Liste(3); liste.add(5); liste.add(43); liste.add(9);
 * liste.add(12); liste.add(13); liste.add(7);
 * 
 * System.out.println(liste);
 * 
 * liste.addHead(42);
 * 
 * System.out.println(liste);
 * 
 * 
 * System.out.println(liste.counter());
 * 
 * liste.firstLast();
 * 
 * System.out.println("\n"+liste.find(4));
 * 
 * liste.remove(7); System.out.println(liste);
 */
