package algorithms.countingsort;

import algorithms.ArrayUtils;

public class CountSort {
	
	public static void main(String[] args) {
		int[] A = new int[]{1, 6, 3, 2, 9, 4, 3, 3, 5, 1, 1};
		int[] B = new int[]{1};
		try {
			ArrayUtils.printIntArray(A);
			B = CountSort.Sort(A, 0, A.length, 9);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayUtils.printIntArray(B);
	}
	
	public static int[] Sort(int[] A, int start, int end, int maxValue) throws Exception{
		return Sort(A, start, end, maxValue, false);
	}
	
	public static int[] Sort(int[] A, int start, int end, int maxValue, boolean documentation) throws Exception{
		int[] B = new int[end - start];
		System.out.println(end - start);
		int[] C = new int[maxValue + 1];
		
		if(documentation){
			System.out.println("Counting Values...");
		}
		CountValues(A, C, documentation);
		if(documentation){
			System.out.println("Adding counts...");
		}
		CountIndexes(C, documentation);
		addToResult(A, C, B, documentation);
		
		return B;
	}

	private static void addToResult(int[] A, int[] C, int[] B, boolean documentation) {
		for (int i = A.length - 1; i >= 0; i--) {
			int index = C[A[i]] - 1;
			if(documentation){
				System.out.println("inserting at: " + index);
			}
			B[index] = A[i];
			if(documentation){
				System.out.println("update of arrays!");
				System.out.print("Array B: ");
				ArrayUtils.printIntArray(B);
				System.out.print("Before C: ");
				ArrayUtils.printIntArray(C);
			}
			C[A[i]]--;
			if(documentation){
				System.out.print("After C: ");
				ArrayUtils.printIntArray(C);
			}
		}
	}

	private static void CountIndexes(int[] C, boolean documentation) {
		for (int i = 1; i < C.length; i++) {
			if(documentation){
				ArrayUtils.printIntArray(C);
			}
			C[i] += C[i - 1];
		}
	}

	private static void CountValues(int[] A, int[] C, boolean documentation) throws Exception{
		for (int i = 0; i < A.length; i++) {
			if(documentation){
				ArrayUtils.printIntArray(C);
			}
			C[A[i]]++;
		}
	}
	
	
}
