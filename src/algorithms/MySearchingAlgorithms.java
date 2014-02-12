package algorithms;

public class MySearchingAlgorithms {
	
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{123,6,234,634,5,431,23,723,62,234,2};
		arr = (Integer[]) MySortingAlgorithms.insertionSort(arr);
		System.out.println(MySortingAlgorithms.makeString(arr));
		System.out.println("Index of value: " + binarySearch(arr, 723));
	}
	
	public static Integer binarySearch(Integer[] array, Integer v){
		
		int modifier = array.length / 2;
		int index = modifier + 1;
		System.out.println("Index: " + index);
		if(array[index] == v){
			return index;
		}
		while(!array[index].equals(v)){
			Integer focus = array[index];
			System.out.println("value:" + focus + " ? " + v);
			System.out.println((focus.equals(v)));
			modifier /= 2;
			if(focus.equals(v)){
				System.out.println("was equal");
				return index;
			}else if(focus.compareTo(v) < 0){
				System.out.println("counting Up by " + modifier);
				index += modifier < 1 ? 1 : modifier;
				System.out.println("new Index: " + index);
			}else if(focus.compareTo(v) > 0){
				System.out.println("counting Down by " + modifier);
				index -= modifier < 1 ? 1 : modifier;
				System.out.println("new Index: " + index);
			}
			if(index < 0 || index > array.length -1){
				return null;
			}
		}
		return array[index].equals(v) ? index : null; 
		
	}
	
}
