package algorithms.bitshift;

public class BitShift {
	
	public static final int BYTESIZE = 8;
	
	public static void main(String[] args) {
		
		int x = 244;
		System.out.println("x: " + x);
		boolean[] b_arr = byteToBooleanArray(x);
		for (boolean b : b_arr) {
			System.out.print(b ? "1" : "0");
		}
		System.out.println("");
		System.out.println("x: " + booleanArrayToByte(b_arr));
		
	}
	
	public static boolean[] byteToBooleanArray(int in){
		if(in > 1 << BYTESIZE || in < 0){
			System.out.println("Not between 0-255");
			return null;
		}
		boolean[] result = new boolean[BYTESIZE];
		int check = 0x01;
		for(int i = 0; i < BYTESIZE; i++){
			result[BYTESIZE - 1 - i] = ((in & check) != 0);
			check = check << 1;
		}
		
		return result;
	}
	
	public static boolean[] byteToBooleanArray(int in, int bits){
		if(in > 1 << bits || in < 0 || bits > 31){
			System.out.println("Not between 0-255");
			return null;
		}
		boolean[] result = new boolean[bits];
		int check = 0x01;
		for(int i = 0; i < bits; i++){
			result[bits - 1 - i] = ((in & check) != 0);
			check = check << 1;
		}
		
		return result;
	}
	
	public static int booleanArrayToByte(boolean[] bits){
		int output = 0;
		if(bits.length != 8){
			return output;
		}
		int modifier = 1;
		for (int i = bits.length - 1; i >= 0; i--) {
			output += bits[i] ? modifier : 0;
			modifier <<= 1;
		}
		return output;
	}
}
