package patikaplus.week4.nighter;

import patikaplus.util.Array;
import patikaplus.util.Print;

public class Test {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 11, 8, 9, 10};
		
		Print.array(Array.removeAndNarrow(arr, 11));
	}

}
