package algorithms;

public class CountingSortUtil {
	
	public static void main(String[] args) {
		
		int[] A = new int[]{7,2,0,7,6,5,7,3,3,2};
		int[] B = new int[A.length];
		
		ArrayUtils.printIntArray(A);
		
		countSort(A, B, 7);
		
		ArrayUtils.printIntArray(B);
	}
	
	public static void countSort(int[] A, int[] B, int k){
		
		if(A.length != B.length){
			System.out.println("A and B not same length!");
			return;
		}
		
		int[] C = new int[k + 2];
		
		// Setting C array values to 0
		for(int i = 0; i < C.length; i++){
			C[i] = 0;
		}
		
		// histogram for A's values representation
		for(int i = 0; i < A.length; i++){
			C[A[i]]++;
		}
		
		// calcing index for index values
		for(int i = 1; i < C.length; i++){
			C[i] += C[i - 1];
		}
		
		for(int i = A.length - 1; i >= 0; i--){
			int n = A[i];
			B[C[n] - 1] = n;
			C[n]--;
		}
	}


	
}
