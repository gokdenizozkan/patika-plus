package patikaplus.week1;

import patikaplus.util.Input;
import patikaplus.util.Math;
import patikaplus.util.Print;

public class ArmstrongNumFinder {
	public static void run() {
		int length, num, remaining, sum = 0;
		String numString;
		
		numString = Input.getLine("Please enter a number:");
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
