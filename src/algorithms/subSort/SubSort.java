package algorithms.subSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithms.ArrayGenerator;
import algorithms.ArrayUtils;
import algorithms.MergeSortUtil;
import algorithms.mergesort.Mergesort;
import algorithms.quicksort.QuickSort;

public class SubSort{
	
	private static final int LOWERLIMIT = 2;
	private static final int SIZES = 10;
	
	public static void main(String[] args) {
		try {
			Integer[] ints = ArrayGenerator.makeRandomArray(1000000, 0, 4000);
			float[] A = new float[ints.length];
			for (int i = 0; i < ints.length; i++) {
				A[i] = ((float)(ints[i] + Math.random()));
			}
			System.out.println("Starting to sort..");
//			for (float f : A) {
//				System.out.print(f + ", ");
//			}
			long time = System.currentTimeMillis();
			sort(A);
			System.out.println("Sort took: " + (System.currentTimeMillis() - time) + " ms!");
			System.out.println("passed: " + ArrayUtils.verifyArraySorted(A));
			System.out.println("Size: " + A.length);
//			for (float f : A) {
//				System.out.print(f + ", ");
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sort(List<Float> A){
		if(A.size() < 2){
			return;
		}
		float min = A.get(0);
		float max = min;
		
		
		// Find max min
		for (int i = 1; i < A.size(); i++) {
			if(min > A.get(i)){
				min = A.get(i);
			}else if(max < A.get(i)){
				max = A.get(i);
			}
		}
		if(max == min){
			return;
		}
		float modifier = (max - min) / 10; // 2 - 4 = 2 / 10 = 0.2
//		if(modifier == 0.0f){
//			System.out.println("mod == 0");
//		}
		float scalar = 1 / modifier;
		
//		//rounds
//		min = (float)((int) min);
//		max = (float)((int) max);
		
		List<Float>[] inputs = new ArrayList[SIZES];
		for (Float f : A) {
			try{
				int index = (int)Math.round(((f - min) * scalar));
				if(index == SIZES){
					index--;
				}
				if(index < 0 || index > SIZES - 1){
					System.out.println("index wrong");
				}
				if(inputs[index] == null){
					inputs[index] = new ArrayList<>();
				}
				inputs[index].add(f);
			} catch (ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
			}
		}
		for (List<Float> list : inputs) {
			if(list != null){
				sort(list);
			}
		}
		A.clear();
		for (int i = 0; i < inputs.length; i++) {
			if(inputs[i] != null){
				A.addAll(inputs[i]);
			}
		}
	}
	
	public static void sort(float[] A){
		if(A.length < 2){
//			if(A.length == 2){
//				if(A[1] < A[0]){
//					float temp = A[1];
//					A[1] = A[0];
//					A[0] = temp;
//				}
//			}
			return;
		}
		float min = A[0];
		float max = A[0];
		
		
		// Find max min
		for (int i = 1; i < A.length; i++) {
			if(A[i] < min){
				min = A[i];
			}if(A[i] > max){
				max = A[i];
			}
		}
		// if max and min was the same no reason to do anything
//		System.out.println("\nmin: " + min + "\tmax: " + max);
		if(max == min){
			return;
		}
		float modifier = (float)((max - min) / SIZES); // 2 - 4 = 2 / 10 = 0.2
//		if(modifier == 0.0f){
//			System.out.println("mod == 0");
//		}
		float scalar = 1 / modifier;
		
//		//rounds
//		min = (float)((int) min);
//		max = (float)((int) max);
		int[] input_sizes = new int[SIZES];
		int[] input_index = new int[SIZES];
		float[][] inputs = new float[SIZES][0];
//		System.out.println("Sorting: " + A.length + " elements!"); 
		for (Float f : A) {
			try{
				int index = (int)((f - min) * scalar);
				if(index == SIZES){
					index--;
				}
				if(index < 0 || index > SIZES - 1){
					System.out.println("index wrong");
				}
				if(input_sizes[index] == 0){
					input_sizes[index] = SIZES;
					inputs[index] = new float[SIZES];
					input_index[index] = 0;
				}else if(input_sizes[index] <= input_index[index]){
					float[] temp = inputs[index];
					input_sizes[index] *= 2;
					inputs[index] = new float[input_sizes[index]];
					for (int i = 0; i < temp.length; i++) {
						inputs[index][i] = temp[i];
					}
				}
				inputs[index][input_index[index]++] = f;
			} catch (ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
			} catch (OutOfMemoryError e){
				e.printStackTrace();
			}
		}
		int countEmpty = 0;
		for (int j = 0; j < inputs.length; j++) {
			if(inputs[j] != null && inputs[j].length > 0){
				if(A.length != input_index[j]){
					float[] list = new float[input_index[j]];
					for (int i = 0; i < input_index[j]; i++) {
						list[i] = inputs[j][i];
					}
					sort(list);
				}else{
//					System.out.println("WTF");
				}
			}else{
				countEmpty++;
			}
		}
//		System.out.println("empties: " + countEmpty);
		int c = 0;
		for (int i = 0; i < inputs.length; i++) {
			if(inputs[i] != null && input_index[i] > 0){
				for (int j = 0; j < input_index[i]; j++) {
					A[c++] = inputs[i][j];
				}
			}
		}
	}
}
