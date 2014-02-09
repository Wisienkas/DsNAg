package cycles;

import java.util.ArrayList;

public class Cycler {
	
	public static void main(String[] args) {
		int[] a_r_r = new int[]{7,3,2,4,5,8,0,1,6,9};
		System.out.println(getCycles(a_r_r));
	}
	
	private static boolean[] b_arr;
	private static int[] i_arr;
	
	public static int getCycles(int[] arr){
		
		b_arr = new boolean[arr.length];
		i_arr = arr;

		int cycles = 0;
		
		while(findCycle(i_arr, b_arr)){
			cycles++;
		}
		
		return cycles;
	}


	private static boolean findCycle(int[] i_arr, boolean[] b_arr) {
		int pointer = 0;
		for (int i = 0; i < i_arr.length; i++) {
			if(!b_arr[i]){
				pointer = i;
				do{
					b_arr[pointer] = true;
					pointer = i_arr[pointer];		
				}while(!b_arr[pointer]);
				return true;
			}
		}
		
		return false;
	}
	
}
