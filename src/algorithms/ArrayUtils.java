package algorithms;

public class ArrayUtils {
	
	public static void printIntArray(int[] A){
		String s = "Array{";
		for (int i = 0; i < A.length; i++) {
			s += A[i];
			s += (i + 1 != A.length) ? ", " : "}";
		}
		
		System.out.println(s);
	}
}
