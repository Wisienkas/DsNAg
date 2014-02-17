package algorithms;

public class HeapSortUtil {
	
	public static void main(String[] args) {
		Number[] A = new Number[0];
		try {
			A = ArrayGenerator.makeRandomArray(13, 0, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MergeSortUtil.printArray(A);
		heapSort(A);
		MergeSortUtil.printArray(A);

	}
	
	public static void heapSort(Number[] A){
		maxHeapify(A);
	}

	public static void maxHeapify(Number[] A) {
		for(int i = A.length / 2; i >= 0; i--){
			System.out.println("checking index: " + i);
			int index = i;
			int indexCheck = index;
			while(true){
				index = checkForChildSwap(A, index);
				System.out.println("return :" + index + "\tcheck: " + indexCheck);
				if(indexCheck == index){
					System.out.println("not moved");
					break;
				}
				indexCheck = index;	
			}
		}
	}

	private static int checkForChildSwap(Number[] A, int i) {
		Integer c1 = i * 2 < A.length ? A[i * 2].intValue() : null;
		Integer c2 = (i * 2) + 1< A.length ? A[(i * 2) + 1].intValue() : null;
		boolean result;
		if(c1 == null){
			return i;
		}else if(c2 == null){
			if(c1 > A[i].intValue()){
				A[i * 2] = A[i];
				A[i] = c1;
				return i * 2;
			}
			return i;
		}else{
			int index = c1 >= c2 ? i * 2 : (i * 2) + 1;
			if(A[index].intValue() > A[i].intValue()){
				A[index] = A[i];
				A[i] = c1 >= c2 ? c1 : c2;
				return index;
			}
			return i;
		}
	}

}
