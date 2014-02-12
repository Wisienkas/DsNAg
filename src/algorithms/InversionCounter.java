package algorithms;

public class InversionCounter {
	
	public static void main(String[] args) {
		int[] array = new int[]{2,3,8,6,1};
		int count = countInversions(array);
		System.out.println("Pairs: " + count);
	}
	/**
	 * Will count the amount of inversions.
	 * <br>
	 * An inversion is a case of for Array A[] that i < j and A[i] > A[j]
	 * @param array to be counted
	 * @return counts
	 */
	public static int countInversions(int[] array){
		int count = 0;
		
		for(int i = 0; i < array.length; i++){
			for (int j = i + 1; j < array.length; j++) {
				if(j != i)
					count += (i < j && array[i] > array[j]) ? 1 : 0;
			}
		}
		return count;
	}
}
