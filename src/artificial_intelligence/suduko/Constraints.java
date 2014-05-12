package artificial_intelligence.suduko;

public class Constraints {
	
	public static boolean ValidRow(int[] A){
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if(A[i] == A[j]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean ValidColumn(int[] A){
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if(A[i] == A[j]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean ValidBox(int[] A){
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if(A[i] == A[j]){
					return false;
				}
			}
		}
		return true;
	}
}
