package algorithms.binary;

import algorithms.ArrayUtils;

public class BinaryDigits {
	
	public static void main(String[] args) {
		System.out.println(binaryDigits(54));
	}
	
	public static String binaryDigits(long n){
		boolean[] digits = new boolean[2];
		int i = 0;
		long d = n;
		while(d > 0){
			if(i >= digits.length){
				digits = ArrayUtils.evolveArray(digits);
			}
			digits[i] = d % 2 == 0 ? false : true;
			d /= 2;
			i++;
		}
		return print(digits, i - 1);
	}
	
	private static String print(boolean[] digits, int i) {
		System.out.println("length: " + i);
		String result = "";
		while(i >= 0){
			result += digits[i] ? "1" : "0";
			i--;
		}
		return result;
	}
	
}
