package algorithms.quicksort;


public class QuickSort {
	
	public static void Sort(int[] A, int start, int end){
		if(end <= start || start < 0 || end >= A.length){
			return;
		}
		int q = partion(A, start, end);
		Sort(A, start, q - 1);
		Sort(A, q + 1, end);
	}
	
	public static void Sort2(int[] A, int start, int end){
		if(end <= start || start < 0 || end >= A.length){
			return;
		}
		int[] q = partion2(A, start, end);
		Sort(A, start, q[0] - 1);
		Sort(A, q[1] + 1, end);
	}
	
	private static int partion(int[] A, int start, int end) {
		int end_low = start - 1;
		int number = A[end];
		for (int i = start; i <= end; i++) {
			if(A[i] <= number){
				swap(A, i, end_low + 1);
				end_low++;
			}
		}
		return end_low;
	}

	private static int[] partion2(int[] A, int start, int end) {
		int end_low = start - 1;
		int end_equal = start - 1;
		int number = A[end];
		for (int i = start; i <= end; i++) {
			if(A[i] == number){
				swap(A, i, end_equal + 1);
				end_equal++;
			}else if(A[i] < number){
				swap(A, i, end_low + 1, end_equal + 1);
				end_low++;
				end_equal++;
			}
		}
//		ArrayUtils.printIntArray(A);
//		System.out.println("Start: " + start + "\tLow: " + end_low + "\tEqual: " + end_equal + "\tEnd: " + end);
		
		return new int[]{end_low, end_equal};
	}

	private static void swap(int[] A, int i, int end_low, int end_equal) {
		swap(A, i, end_low);
		swap(A, i, end_equal);
	}


	private static void swap(int[] A, int i, int j) {
		if(i == j){
			return;
		}
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
}
