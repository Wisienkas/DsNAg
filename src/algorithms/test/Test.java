package algorithms.test;

import java.util.ArrayList;
import java.util.List;

import algorithms.ArrayGenerator;
import algorithms.ArrayUtils;
import algorithms.countingsort.CountSort;
import algorithms.mergesort.Mergesort;
import algorithms.quicksort.QuickSort;
import algorithms.subSort.SubSort;

public class Test {

	public static void main(String[] args) {
		int size = 100000;
		int k = size * 20;
		int runs = 5;
		int sorts = 5;
		int active;
		String[] names = new String[]{
				"Quicksort - Sort 1",
				"Quicksort - Sort 2",
				"Countsort - Sort  ",
				"Mergesort - Sort  ",
				"SubSort   - Sort"};
		long[] times = new long[sorts];
		boolean[][] passed = new boolean[sorts][runs];
		for (int i = 0; i < runs; i++) {
			try {
				//generate arrays;
				int[] A = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				int[] B = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				int[] C = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				int[] D = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				int[] E = ArrayGenerator.makeRandomArrayPrimi(size, 0, k);
				
				
				active = 0;
				System.out.print("| " + names[active] + " |\t  Time: ");
				long time = System.nanoTime();
				QuickSort.Sort(A, 0, A.length - 1);
				time = (System.nanoTime() - time) / 1000000;
				times[active] += time;
				passed[active][i] = ArrayUtils.verifyArraySorted(A);
				System.out.println(time + "ms");
				
				
				active = 1;
				System.out.print("| " + names[active] + " |\t  Time: ");
				time = System.nanoTime();
				QuickSort.Sort(B, 0, B.length - 1);
				time = (System.nanoTime() - time) / 1000000;
				times[active] += time;
				passed[active][i] = ArrayUtils.verifyArraySorted(B);
				System.out.println(time + "ms");
				
				
				active = 2;
				System.out.print("| " + names[active] + " |\t  Time: ");
				time = System.nanoTime();
				C = CountSort.Sort(C, 0, C.length, k);
				time = (System.nanoTime() - time) / 1000000;
				times[active] += time;
				passed[active][i] = ArrayUtils.verifyArraySorted(C);
				System.out.println(time + "ms");
				
				
				active = 3;
				System.out.print("| " + names[active] + " |\t  Time: ");
				time = System.nanoTime();
				Mergesort.mergeSort(D, 0, D.length - 1);
				time = (System.nanoTime() - time) / 1000000;
				times[active] += time;
				passed[active][i] = ArrayUtils.verifyArraySorted(D);
				System.out.println(time + "ms");
				
				active = 4;
				System.out.print("| " + names[active] + " |\t  Time: ");
				float[] E_float = new float[E.length];
				for (int j = 0; j < E.length; j++) {
					E_float[j] = (float) (E[i] + Math.random());
				}
				time = System.nanoTime();
				SubSort.sort(E_float);
				time = (System.nanoTime() - time) / 1000000;
				times[active] += time;
				System.out.println(ArrayUtils.verifyArraySorted(E_float));
				passed[active][i] = ArrayUtils.verifyArraySorted(E_float);
				E_float = null;
				System.out.println(time + "ms");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("\nFinal Results!! \n");
		for (int j = 0; j < sorts; j++) {
			System.out.print("Average for " + j + ": " + (times[j] / runs) + "ms\t");
			for (int j2 = 0; j2 < runs; j2++) {
				System.out.print("status: " + j2 + " == " + passed[j][j2] +" :: ");
			}
			System.out.println("");
		}
	}
}
