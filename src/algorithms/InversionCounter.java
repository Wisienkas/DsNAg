package algorithms;

public class InversionCounter {
	
	public static void main(String[] args) {
		Number[] A = new Number[0];
		try {
			A = ArrayGenerator.makeRandomArray(10, 0, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count = countInversions(A);
		int count2 = countInversions2(A, 0 , A.length - 1);
		System.out.println("Pairs: " + count);
		System.out.println("Pairs: " + count2);
	}
	/**
	 * Will count the amount of inversions.
	 * <br>
	 * An inversion is a case of for Array A[] that i < j and A[i] > A[j]
	 * @param A to be counted
	 * @return counts
	 */
	public static int countInversions(Number[] A){
		int count = 0;
		
		for(int i = 0; i < A.length; i++){
			for (int j = i + 1; j < A.length; j++) {
				count += (i < j && A[i].intValue() > A[j].intValue()) ? 1 : 0;
			}
		}
		return count;
	}
	
	public static int countInversions2(Number[] A, int start, int end){
		int result= 0;
		if(end - start < 1){
			return result;
		}
		int split = ((end - start) / 2) + start;
		result += countInversions2(A, start, split);
		result += countInversions2(A, split + 1, end);
		result += mergeInversion(A, start, end, split);
		
		return result;
	}
	private static int mergeInversion(Number[] A, int start, int end, int split) {
		int result = 0;
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
				int LSkip = L.length - li;
				result +=  LSkip;
				ri++;
			}
			if(li == L.length){
				while(ri < R.length){
					i++;
					A[i] = R[ri];
					int LSkip = L.length - li;
					result +=  LSkip;
					ri++;
				}
				return result;
			}
			if(ri == R.length){
				while(li < L.length){
					i++;
					A[i] = L[li];
					li++;
				}
				return result;
			}
		}
		return result;
	}
	
	
}
