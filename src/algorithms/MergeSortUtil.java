package algorithms;

public class MergeSortUtil {
	
	
	public static void main(String[] args) {
		Number[] A = new Number[0];
		try {
			A = ArrayGenerator.makeRandomArray(50, 0, 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		printArray(A);
		mergeSort(A, 0, A.length - 1);
		printArray(A);
		
	}
	
	public static void printArray(Number[] A){
		String s = "Array{";
		for (Number number : A) {
			s += number.floatValue() + ", ";
		}
		s += "lol";
		s = s.replace(", lol" ,"}");
		System.out.println(s);
	}
	
	public static void mergeSort(Number[] A, int start, int end){
		if(end - start < 1)
			return;
		int split = ((end - start) / 2) + start;
		mergeSort(A, start, split);
		mergeSort(A, split + 1, end);
		merge(A, start, end, split);
	}
	
	public static void merge(Number[] A, int start, int end, int split){
		Number[] L = new Number[(split + 1) - start];
		Number[] R = new Number[end - split];
		
		for(int i = 0; i < L.length; i++){
			L[i] = A[start + i];
		}
		for(int i = 0; i < R.length; i++){
			R[i] = A[split + 1 + i];
		}

		int ri = 0;
		int li = 0;
		
		for(int i = start; i <= end; i++){
			
			if(L[li].floatValue() <= R[ri].floatValue()){
				A[i] = L[li];
				li++;
			}else{
				A[i] = R[ri];
				ri++;
			}
			if(li == L.length){
				while(ri < R.length){
					i++;
					A[i] = R[ri];
					ri++;
				}
				return;
			}
			if(ri == R.length){
				while(li < L.length){
					i++;
					A[i] = L[li];
					li++;
				}
				return;
			}
		}
	}
	
}
