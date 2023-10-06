package dev.patika.plus.week4;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Print;

public class TryCatch {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		a:
		try {
			do {
				int in = Input.getInt("Please enter a number to retrieve a value from the array:\n(type -1 to exit)");
				if (in == -1) break;
				Print.nline("Retrieved number: " + arr[in] + "\n");
			} while (true);
		} catch (Exception e) {
			Print.nline("\n!!! Could not retrieve a value. !!!\n!!! Number does to correspond to a value in the array. !!!\n");
			main(null);
		}
	}
}
