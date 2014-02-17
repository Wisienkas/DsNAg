package algorithms;

public class InversionCounter {
	
	public static void main(String[] args) {
		int[] array = new int[]{2,3,8,6,1};
		int count = countInversions(array);
		int count2 = countInversions2(array);
		System.out.println("Pairs: " + count);
		System.out.println("Pairs: " + count2);
	}
	/**
	 * Will count the amount of inversions.
	 * <br>
	 * An inversion is a case of for Array A[] that i < j and A[i] > A[j]
	 * @param A to be counted
	 * @return counts
	 */
	public static int countInversions(int[] A){
		int count = 0;
		
		for(int i = 0; i < A.length; i++){
			for (int j = i + 1; j < A.length; j++) {
				count += (i < j && A[i] > A[j]) ? 1 : 0;
			}
		}
		return count;
	}
	
	public static int countInversions2(int[] A){
		if(A.length <= 1){
			return 0;
		}
		int count = 0;
		//converting to Number[] due to generics
		Number[] M = new Number[A.length];
		for(int i = 0; i < A.length; i++){
			M[i] = (Integer) A[i];
		}
		Number[] B = MySortingAlgorithms.mergeSort(M);
		for(int j = 0; j < B.length; j++){
			Integer B_value = (Integer) MySearchingAlgorithms.binarySearch(B, M[j]);
			
			count += j > B_value ? j - B_value : 0;
		}
		return count;
	}
}
