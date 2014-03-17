package algorithms.mergesort;

public class Mergesort {
	
	public static void mergeSort(int[] A, int start, int end){
		if(end - start < 1)
			return;
		int split = ((end - start) / 2) + start;
		mergeSort(A, start, split);
		mergeSort(A, split + 1, end);
		merge(A, start, end, split);
	}
	
	public static void merge(int[] A, int start, int end, int split){
		int[] L = new int[(split + 1) - start];
		int[] R = new int[end - split];
		
		for(int i = 0; i < L.length; i++){
			L[i] = A[start + i];
		}
		for(int i = 0; i < R.length; i++){
			R[i] = A[split + 1 + i];
		}

		int ri = 0;
		int li = 0;
		
		for(int i = start; i <= end; i++){
			
			if(L[li] <= R[ri]){
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
