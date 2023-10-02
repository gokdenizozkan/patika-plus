package patikaplus.week1;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Math;
import com.gokdenizozkan.util.Print;

public class ArmstrongNumFinder {
	public static void run() {
		int length, num, remaining, sum = 0;
		//String numString;
		
		String numString = Input.getLine("Please enter a number:");
		length = numString.length();
		
		num = Integer.parseInt(numString);
		
		int dividingNum = num;
		for (int i = 0; i < length; i++) {
			remaining = dividingNum % 10;
			dividingNum /= 10;
			sum += Math.pow(remaining, length);
		}
		
		if (num == sum) {
			Print.nline("Armstrong!");
		}
		else {
			Print.nfline("Ops %d %d", num, sum);
		}
	}
	
	public static void main(String[] args ) {
		run();
	}
}
