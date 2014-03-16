package algorithms.test;

import algorithms.ArrayGenerator;
import algorithms.ArrayUtils;
import algorithms.countingsort.CountSort;
import algorithms.mergesort.Mergesort;
import algorithms.quicksort.QuickSort;

public class Test {

	public static void main(String[] args) {
		int size = 10000000;
		int k = size * 20;
		int runs = 5;
		int sorts = 4;
		long[] times = new long[sorts];
		boolean[][] passed = new boolean[sorts][runs];
		for (int i = 0; i < runs; i++) {
			try {
				//generate arrays;
				int[] A = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				int[] B = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				int[] C = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				int[] D = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				
				
				System.out.println("Quicksort - Sort 1");
				long time = System.nanoTime();
				QuickSort.Sort(A, 0, A.length - 1);
				time = System.nanoTime() - time;
				time /= 1000000;
				times[0] += time;
				passed[0][i] = ArrayUtils.verifyArraySorted(A);
				System.out.println("time: " + time + "ms");
				
				
				System.out.println("Quicksort - Sort 2");
				time = System.nanoTime();
				QuickSort.Sort(B, 0, B.length - 1);
				time = System.nanoTime() - time;
				time /= 1000000;
				times[1] += time;
				passed[1][i] = ArrayUtils.verifyArraySorted(B);
				System.out.println("time: " + time + "ms");
				
				
				System.out.println("Countsort - Sort");
				time = System.nanoTime();
				C = CountSort.Sort(C, 0, C.length, k);
				time = System.nanoTime() - time;
				time /= 1000000;
				times[2] += time;
				passed[2][i] = ArrayUtils.verifyArraySorted(C);
				System.out.println("time: " + time + "ms");
				
				
				System.out.println("Mergesort - Sort");
				time = System.nanoTime();
				Mergesort.mergeSort(D, 0, D.length - 1);
				time = System.nanoTime() - time;
				time /= 1000000;
				times[3] += time;
				passed[3][i] = ArrayUtils.verifyArraySorted(D);
				System.out.println("time: " + time + "ms");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Average");
		for (int j = 0; j < sorts; j++) {
			System.out.print("total for " + j + ": " + (times[j] / runs) + "ms\t");
			for (int j2 = 0; j2 < runs; j2++) {
				System.out.print("status: " + j2 + " == " + passed[j][j2] +" :: ");
			}
			System.out.println("");
		}
	}
}
