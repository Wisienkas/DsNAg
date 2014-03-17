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
	
	public static boolean verifyArraySorted(int[] A){
		for (int i = 1; i < A.length; i++) {
			if(A[i - 1] > A[i]){
				return false;
			}
		}
		return true;
	}
	
	public static double[] evolveArray(double[] A){
		double[] new_A = new double[A.length * 2];
		for(int i = 0; i < A.length; i++){
			new_A[i] = A[i];
		}
		return new_A;
	}
	
	public static boolean[] evolveArray(boolean[] A){
		boolean[] new_A = new boolean[A.length * 2];
		for(int i = 0; i < A.length; i++){
			new_A[i] = A[i];
		}
		return new_A;
	}
	
	public static float[] evolveArray(float[] A){
		float[] new_A = new float[A.length * 2];
		for(int i = 0; i < A.length; i++){
			new_A[i] = A[i];
		}
		return new_A;
	}
	
	public static int[] evolveArray(int[] A){
		int[] new_A = new int[A.length * 2];
		for(int i = 0; i < A.length; i++){
			new_A[i] = A[i];
		}
		return new_A;
	}
	
	public static long[] evolveArray(long[] A){
		long[] new_A = new long[A.length * 2];
		for(int i = 0; i < A.length; i++){
			new_A[i] = A[i];
		}
		return new_A;
	}
}
