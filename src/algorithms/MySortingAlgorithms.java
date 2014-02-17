package algorithms;


public class MySortingAlgorithms {

	public static void main(String[] args) {
		//Number[] array = new Integer[]{26,71,2,86,10,5,75,1,34,8,23,52,71,92};
		Number[] array = new Number[0];
		long time = 0;
		long time1 = 0;
		try {
			time = System.nanoTime();
			array = ArrayGenerator.makeRandomArray(10000000, 0, 109900000);
//			array = ArrayGenerator.makeSortedArray(100000, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		time1 = System.nanoTime();
		array = mergeSort(array);
//		array = insertionSort(array);
		time1 = System.nanoTime() -time1;
		System.out.println("array generator time: " + time);
		System.out.println("mergesort time: " + time1);
	}
	
	/**
	 * Will give you a String which includes all the elements of the array
	 * @param array the array to be added to the string
	 * @return string which includes the array
	 */
	public static String makeString(Number[] array){
		String output = "array: {";
		if(array == null){
			output += "null";
		}else{
			for (Number n : array) {
				output += n.longValue() + ", ";
			}
		}
		output += "}";
		return output;
	}
	
	/**
	 * InsertionSort Algorithm
	 * @param array to be sorted
	 * @return sorted array
	 */
	public static Number[] insertionSort(Number[] array) {

		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j - 1].doubleValue() > array[j].doubleValue()) {
				Number holder = array[j - 1];
				array[j - 1] = array[j];
				array[j] = holder;
				j--;
			}
		}
		return array;
	}

	/**
	 * MergeSort algorithm
	 * @param array to be sorted
	 * @return array sorted
	 */
	public static Number[] mergeSort(Number[] array) {
		if(array.length <= 1){
			return array;
		}

		Number[] array1 = getSubArray(array, 0, array.length / 2);
		Number[] array2 = getSubArray(array, array.length / 2,
				array.length);
		array1 = mergeSort(array1);
		array2 = mergeSort(array2);
		
		return merge(array1, array2);
	}
	
	/**
	 * checks if n1 is lesser than or equal n2
	 * @param n1
	 * @param n2
	 * @return true if n1 <= n2 else false
	 */
	private static boolean CompareNumbers(Number n1, Number n2){
		Long l1 = n1.longValue();
		Long l2 = n2.longValue();
		if(l1 != l2){
			return l1 < l2 ? true : false;
		}
		return n1.doubleValue() <= n2.doubleValue() ? true : false;
	}
	
	/**
	 * Will merge 2 arrays in a sorted manor;
	 * @param array1
	 * @param array2
	 * @return sorted array
	 */
	private static Number[] merge(Number[] array1, Number[] array2) {
		Number[] result = new Number[array1.length + array2.length];
		int i1 = 0;
		int i2 = 0;
		int endValue = 0;
		for (int k = 0; k < result.length && array1.length > i1 && array2.length > i2; k++) {
			if(CompareNumbers(array1[i1], array2[i2])){
				result[k] = array1[i1];
				i1++;
			}else{
				result[k] = array2[i2];
				i2++;
			}
			endValue = k;
		}
		if(endValue < result.length){
			if(array1.length <= i1){
				for(int j = endValue + 1; j < result.length; j++){
					result[j] = array2[i2];
					i2++;
				}
			}else if(array2.length <= i2){
				for(int j = endValue +1; j < result.length; j++){
					result[j] = array1[i1];
					i1++;
				}
			}
		}
		return result;
	}


	/**
	 * Will retrive a subArray from a given array, starting from the given start to the given end
	 * @param array to get subarray from
	 * @param start index
	 * @param end index of array + 1;
	 * @return
	 */
	private static Number[] getSubArray(Number[] array, int start, int end) {
		if(start > end){
			return new Number[0];
		}
		Number[] result = new Number[end - start];
		for (int i = 0; i < result.length; i++) {
			result[i] = array[start + i];
		}
		return result;
	}
	
	private static int partion(int[] A, int p, int r){
		int x = A[r];
		int i = p - 1;
		int holder;
		boolean allSame = true;
		for(int j = p; j < r; j++){
			if(allSame){
				if(A[j] != A[r])
					allSame = false;
			}
			if(A[j] <= x){
				i++;
				holder = A[i];
				A[i] = A[j];
				A[j] = holder;
			}
		}
		holder = A[i + 1];
		A[i + 1] = A[r];
		A[r] = holder;
		
		return allSame ? ((p + r) / 2) : (i + 1);
	}
	
	public static class IndexHolder{
		public int q = 0;
		public int t = 0;
	}
	
	private static IndexHolder partion2(int[] A, int p, int r){
		int x = A[r];
		int i = p - 1;
		int t = i;
		int holder;
		boolean allSame = true;
		for(int j = p; j < r; j++){
			if(allSame){
				if(A[j] != A[r])
					allSame = false;
			}
			if(A[j] < x){
				i++;
				t++;
				holder = A[i];
				A[i] = A[j];
				A[j] = holder;
				holder = A[t];
				A[t] = A[j];
				A[j] = A[t];
			}else if(A[j] == x){
				t++;
				holder = A[t];
				A[t] = A[j];
			}
		}
		holder = A[t +1];
		A[t + 1] = A[r];
		A[r] = holder;
		
		IndexHolder result = new IndexHolder();
		result.q = i + 1;
		result.t = t + 1;
		
		return result;
	}
	
//	public static Number[] heapSort(Number[] array, )

}
