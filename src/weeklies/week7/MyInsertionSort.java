package weeklies.week7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MyInsertionSort {
	
	static HashMap<String, Integer[]> makeCases(String[] names, int inputSize){
		HashMap<String, Integer[]> mapOfCases = new HashMap<>();
		Random rnd = new Random();
		
		Integer[] case1 = new Integer[inputSize];
		for(int i = 0; i < inputSize; i++){
			case1[i] = i;
		}
		mapOfCases.put(names[0], case1);
		
		Integer[] case2 = new Integer[inputSize];
		for(int i = 0; i < inputSize; i++){
			case2[i] = inputSize - i;
		}
		mapOfCases.put(names[1], case2);
		
		Integer[] case3 = new Integer[inputSize];
		for(int i = 0; i < inputSize; i++){
			case3[i] = rnd.nextInt(10000000);
		}
		mapOfCases.put(names[2], case3);
		
		
		return mapOfCases;
	}
	
	public static void main(String[] args) {
		

		Random rnd = new Random();
		String[] namings = new String[]{"case1", "case2", "case3"};
		
		for (int i = 0; i < 10000; i++) {
			String hold = namings[1];
			namings[1] = namings[2];
			namings[2] = hold;
		}
		
		HashMap<String, Integer[]> mapOfCases;
		int runtimePerCase = 7;
		
		// For first input Size
		mapOfCases = makeCases(namings, 100);
		
		for (int i = 0; i < namings.length; i++) {
			long average = 0;
			for (int j = 0; j < runtimePerCase; j++) {
				average += runTimeTest(mapOfCases.get(namings[i]), namings[i]);
			}
			System.out.println("average for " + namings[i] + ": " + (average / namings.length) + " ns");
		}
		
		// for seconds input Size
		mapOfCases = makeCases(namings, 10000);
		
		for (int i = 0; i < namings.length; i++) {
			long average = 0;
			for (int j = 0; j < runtimePerCase; j++) {
				average += runTimeTest(mapOfCases.get(namings[i]), namings[i]);
			}
			System.out.println("average for " + namings[i] + ": " + (average / namings.length) + " ns");
		}
		
		// for third input Size
		mapOfCases = makeCases(namings, 100000);
		
		for (int i = 0; i < namings.length; i++) {
			long average = 0;
			for (int j = 0; j < runtimePerCase; j++) {
				average += runTimeTest(mapOfCases.get(namings[i]), namings[i]);
			}
			System.out.println("average for " + namings[i] + ": " + (average / namings.length) + " ns");
		}
	}
	
	static long runTimeTest(Integer[] arr, String naming){
		Random rnd = new Random();
		long time = System.nanoTime();
		Integer[] arr1 = sort(arr);
		time = System.nanoTime() - time;
//		System.out.println("timeSpent " + naming + ": " + time + " ns");
		arr1[1].floatValue();
		return time;
	}
	
	
	public static Integer[] sort(Integer[] array){
		
		for(int i = 1; i < array.length; i++){
			int j = i;
			while(j > 0 && array[j - 1] > array[j]){
				int holder = array[j - 1];
				array[j - 1] = array[j];
				array[j] = holder;
				j--;
			}
		}
		return array;
	}
	
}
