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
		int[] B = new int[end - start];
		System.out.println(end - start);
		int[] C = new int[maxValue + 1];
		
		System.out.println("Counting Values...");
		CountValues(A, C);
		System.out.println("Adding counts...");
		CountIndexes(C);
		addToResult(A, C, B);
		
		return B;
	}

	private static void addToResult(int[] A, int[] C, int[] B) {
		for (int i = A.length - 1; i >= 0; i--) {
			int index = C[A[i]];
			index--;
			System.out.println("inserting at: " + index);
			B[index] = A[i];
			System.out.println("update of arrays!");
			System.out.print("Array B: ");
			ArrayUtils.printIntArray(B);
			System.out.print("Before C: ");
			ArrayUtils.printIntArray(C);
			C[A[i]]--;
			System.out.print("After C: ");
			ArrayUtils.printIntArray(C);
		}
	}

	private static void CountIndexes(int[] C) {
		for (int i = 1; i < C.length; i++) {
			ArrayUtils.printIntArray(C);
			C[i] += C[i - 1];
		}
	}

	private static void CountValues(int[] A, int[] C) throws Exception{
		for (int i = 0; i < A.length; i++) {
			ArrayUtils.printIntArray(C);
			C[A[i]]++;
		}
	}
	
	
}
