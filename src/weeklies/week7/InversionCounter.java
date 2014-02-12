package weeklies.week7;

public class InversionCounter {
	
	public static void main(String[] args) {
		int[] array = new int[]{2,3,8,6,1};
		int count = countInversions(array);
		System.out.println("Pairs: " + count);
	}
	
	public static int countInversions(int[] array){
		int count = 0;
		
		for(int i = 0; i < array.length; i++){
			for (int j = i + 1; j < array.length; j++) {
				if(j != i)
					count += pair(i, j, array[i], array[j]) ? 1 : 0;
			}
		}
		return count;
	}

	private static boolean pair(int i, int j, int k, int l) {
		return (i < j && l > k) ? true : false;
	}
}
