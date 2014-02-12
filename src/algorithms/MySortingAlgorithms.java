package algorithms;


public class MySortingAlgorithms {

	public static void main(String[] args) {
		Integer[] array = new Integer[]{26,71,2,86,10,5,75,1,34,8,23,52,71,92};
		System.out.println(makeString(array));
		array = mergeSort(array);
		System.out.println(makeString(array));
	}
	
	/**
	 * Will give you a String which includes all the elements of the array
	 * @param array the array to be added to the string
	 * @return string which includes the array
	 */
	public static String makeString(Integer[] array){
		String output = "array: {";
		if(array == null){
			output += "null";
		}else{
			for (Integer integer : array) {
				output += integer + ", ";
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
	public static Integer[] insertionSort(Integer[] array) {

		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j - 1] > array[j]) {
				int holder = array[j - 1];
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
	public static Integer[] mergeSort(Integer[] array) {
		if(array.length <= 1){
			return array.length == 1 ? new Integer[]{array[0]} : null;
		}
		Integer[] array1 = getSubArray(array, 0, array.length / 2);
		Integer[] array2 = getSubArray(array, array.length / 2,
				array.length);
		System.out.println("new roundup");
		System.out.println(makeString(array1));
		System.out.println(makeString(array2));
		array1 = mergeSort(array1);
		array2 = mergeSort(array2);
		
		return merge(array1, array2);
	}

	/**
	 * Will merge 2 arrays in a sorted manor;
	 * @param array1
	 * @param array2
	 * @return sorted array
	 */
	private static Integer[] merge(Integer[] array1, Integer[] array2) {
		if((array1 == null || array2 == null)){
			return array1 == null ? array2 : array1;
		}else if(array1.length == 0 || array2.length == 0){
			return array1.length == 0 ? array2 : array1;
		}
		Integer[] result = new Integer[array1.length + array2.length];
		int i1 = 0;
		int i2 = 0;
		for (int k = 0; k < result.length; k++) {
			if(array1.length <= i1){
				result[k] = array2[i2];
				i2++;
			}else if(array2.length <= i2){
				result[k] = array1[i1];
				i1++;
			}else if(array1[i1] < array2[i2]){
				result[k] = array1[i1];
				i1++;
			}else{
				result[k] = array2[i2];
				i2++;
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
	private static Integer[] getSubArray(Integer[] array, int start, int end) {
		if(start > end){
			return new Integer[0];
		}
		Integer[] result = new Integer[end - start];
		for (int i = 0; i < result.length; i++) {
			result[i] = array[start + i];
		}
		return result;
	}

}
