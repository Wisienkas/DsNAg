package algorithms;

public class ArrayGenerator {
	
	/**
	 * Will generate an random array based on the params
	 * Will only accept positive params
	 * @param size is the size of the array
	 * @param lowest is the lowest number allowed
	 * @param highest is the highest number allowed
	 * @return random int array
	 * @throws Exception if params violates the conditions
	 */
	public static Integer[] makeRandomArray(int size, int lowest, int highest) throws Exception{
		if(size < 0 || lowest > highest || lowest < 0 || highest < 0){
			throw new Exception("Negative params or lowest higher than highest");
		}
		Integer[] result = new Integer[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) ((Math.random() * (highest - lowest)) + lowest);
		}
		return result;
	}
	
	public static int[] makeRandomArrayPrimi(int size, int lowest, int highest) throws Exception{
		if(size < 0 || lowest > highest || lowest < 0 || highest < 0){
			throw new Exception("Negative params or lowest higher than highest");
		}
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) ((Math.random() * (highest - lowest)) + lowest);
		}
		return result;
	}
	
	/**
	 * Will make a sorted array of n size based on countUp for either 0,1,2,3,,,,n or n,n-1,n-2,,,,,,3,2,1
	 * @param size size of the array
	 * @param countUp boolean to determine sorting
	 * @return sorted array
	 * @throws Exception if size less than 0
	 */
	public static Integer[] makeSortedArray(int size, boolean countUp) throws Exception{
		if(size < 0){
			throw new Exception("Size too short");
		}
		Integer[] result = new Integer[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = countUp ? i : result.length - i;
		}
		return result;
	}
	
}
