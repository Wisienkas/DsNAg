package algorithms;

public class MySearchingAlgorithms {
	
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[0];
		try {
			arr = (Integer[]) ArrayGenerator.makeSortedArray(5000, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		arr = (Integer[]) MySortingAlgorithms.insertionSort(arr);
		System.out.println(MySortingAlgorithms.makeString(arr));
		System.out.println("Index of value: " + binarySearch(arr, 17));
	}
	
	public static Integer binarySearch(Integer[] array, Integer v){
		
		int modifier = array.length / 2;
		int index = modifier + 1;
		if(array[index] == v){
			return index;
		}
		byte movedByZero = 0;
		while(!array[index].equals(v)){
			Integer focus = array[index];
			modifier /= 2;
			if(focus.equals(v)){
				System.out.println("was equal");
				return index ;
			}else if(focus.compareTo(v) < 0){
				if(modifier < 1){
					if(movedByZero > 2){
						return null;
					}
					movedByZero++;
					index += 1;
				}
				index += modifier;
			}else if(focus.compareTo(v) > 0){
				if(modifier < 1){
					if(movedByZero > 2){
						return null;
					}
					movedByZero++;
					index -= 1;
				}
				index -= modifier;
			}
			if(index < 0 || index > array.length -1){
				return null;
			}
		}
		return array[index].equals(v) ? index : null; 
		
	}
	
}
