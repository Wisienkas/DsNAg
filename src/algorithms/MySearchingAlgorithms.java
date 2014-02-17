package algorithms;

public class MySearchingAlgorithms {
	
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[0];
		try {
//			arr = (Integer[]) ArrayGenerator.makeSortedArray(5000, true);
			arr = (Integer[]) ArrayGenerator.makeSortedArray(45, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer[] values = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			values[i] = (Integer) binarySearch(arr, arr[i]);
			System.out.println("Value: " + arr[i] + "\tIndex: " + i + "\tStatus: " + values[i]);
		}
		System.out.println("Value: " + 99 + "\tIndex: NaN" + "\tStatus: " + binarySearch(arr, 99));
		System.out.println("Value: " + 56 + "\tIndex: NaN" + "\tStatus: " + binarySearch(arr, 56));
		System.out.println("Value: " + 87 + "\tIndex: NaN" + "\tStatus: " + binarySearch(arr, 87));
//		arr = (Integer[]) MySortingAlgorithms.insertionSort(arr);
//		System.out.println(MySortingAlgorithms.makeString(arr));
//		System.out.println("Index of value: " + binarySearch(arr, 431));
	}
	
	/**
	 * Will Search array binary in precision of long, Only whole numbers
	 * @param array of type {@link Number}
	 * @param v of type {@link Number}
	 * @return int index number of value in array if found, else null
	 */
	public static Number binarySearch(Number[] array, Number v){
		
		float modifier = array.length / 2;
		float finerIndex = modifier;
		int index = (int) modifier;
		if(array[index].longValue() == v.longValue()){
			return index;
		}
		int overcount = 2;
		while(array[index].longValue() != v.longValue()){
			if(overcount == 0){
				break;
			}
			Long focus = array[index].longValue();
			modifier /= 2;
			if(modifier < 1){
				overcount--;
			}
			if(focus.equals(v.longValue())){
				return index;
			}else if(focus.compareTo(v.longValue()) < 0){
				finerIndex += modifier;
				index += modifier < 1 ? 1 : modifier;
			}else if(focus.compareTo(v.longValue()) > 0){
				finerIndex -= modifier;
				index -= modifier < 1 ? 1 : modifier;
			}
			if(index - finerIndex > 1 || finerIndex - index > 1){
				index = Math.round(finerIndex);
			}
			if(index < 0 || index > array.length -1){
				return null;
			}
		}
		return array[index].longValue() == v.longValue() ? index : null; 
	}
	
	/**
	 * Will search array of Number in precision of Long, Only whole numbers ! :O
	 * @param array of type {@link Number}
	 * @param v of type {@link Number}
	 * @return int index value if found value, else null
	 */
	public Number liniarSearch(Number[] array, Number v){
		
		for(int i = 0; i < array.length; i++){
			if(array[i].longValue() == v.longValue()){
				return i;
			}
		}
		return null;
	}
	
}
