package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

import algorithms.greedy.Node.Arrow;

public class SubSequence {
	
	public static void main(String[] args) {
		String s1 = " furntiated directly on the slide. This is nice for two ";
		String s2 = "In this exampectly from a file, so we don’t have diverging slides and exampl";
		SubSequence ss = new SubSequence(s1, s2);
		for (String string : ss.longestSubSequences()) {
			System.out.println(string);
		}
	}
	
	private char[] s1_arr;
	private char[] s2_arr;
	
	public SubSequence(String s1, String s2){
		s1_arr = s1.toCharArray();
		s2_arr = s2.toCharArray();
	}
	
	public String[] longestSubSequences(){
		System.out.println("making empty grid!");
		Node[][] resultGrid = new Node[s1_arr.length + 1][s2_arr.length + 1];
		System.out.println("Grid made i: " + resultGrid.length + "\tj: " + resultGrid[0].length);
		
		// Set zeroes around
		System.out.println("Filling out zeroes");
		setZeroes(resultGrid);
		System.out.println("Zeroes filled...");
		
		// Calculating array
		System.out.println("Filling Grid!");
		fillGrid(resultGrid);
		System.out.println("Grid successfully filled");
		
		// follow arrows
		String[] result = resolveString(resultGrid);
		
		//reverse String
		return result;
	}

	private String reverseString(String result) {
		char[] c_arr = result.toCharArray();
		for (int i = 0; i < c_arr.length / 2; i++) {
			char temp = c_arr[i];
			c_arr[i] = c_arr[c_arr.length - i - 1];
			c_arr[c_arr.length - i - 1] = temp;
		}
		
		return String.copyValueOf(c_arr);
	}

	private String[] resolveString(Node[][] resultGrid) {
		List<String> resultList = new ArrayList<>();
		
		int i = resultGrid.length - 1;
		int j = resultGrid[resultGrid.length - 1].length - 1;
		Node node = resultGrid[i][j];
		int maxLength = node.value;
		System.out.println("Max length: " + maxLength);
		for (int k = 0; k < resultGrid.length - 1; k++) {
			int i2 = resultGrid[k].length - 1;
			node = resultGrid[k][i2];
			if(node.value > maxLength){
				System.out.println("Found higher!");
				resultList.clear();
				maxLength = node.value;
				resultList.add(addString(k, i2, resultGrid));
			}else if(node.value == maxLength){
				resultList.add(addString(k, i2, resultGrid));
			}
		}
		for (int k = 0; k < resultGrid[0].length - 1; k++) {
			int i2 = resultGrid.length - 1;
			node = resultGrid[i2][k];
			if(node.value > maxLength){
				resultList.clear();
				maxLength = node.value;
				resultList.add(addString(i2, k, resultGrid));
			}else if(node.value == maxLength){
				resultList.add(addString(i2, k, resultGrid));
			}
		}
		String[] result = new String[resultList.size()];
		for (int k = 0; k < result.length; k++) {
			result[k] = resultList.get(k);
		}
		return result;
	}

	private String addString(int k, int i2, Node[][] resultGrid) {
		String result = "";
		Node node = resultGrid[k][i2];
		while(node.arrow != Arrow.END){
			switch (node.arrow) {
			case SLOPING:
				result += s1_arr[k - 1];
				k--;
				i2--;
				break;
			case LEFT:
				i2--;
				break;
			case UP:
				k--;
				break;
			default:
				System.out.println("unknown case");
				break;
			}
			node = resultGrid[k][i2];
		}
		return reverseString(result);
	}

	private void fillGrid(Node[][] resultGrid) {
		for (int i = 1; i < resultGrid.length; i++) {
			System.out.println("");
			for (int j = 1; j < resultGrid[i].length; j++) {
				if(s1_arr[i - 1] == s2_arr[j - 1]){
					resultGrid[i][j] = new Node(Arrow.SLOPING, resultGrid[i - 1][j - 1].value + 1);
					System.out.print(resultGrid[i - 1][j - 1].value + 1 + " , ");
				}else if(resultGrid[i - 1][j].value >= resultGrid[i][j - 1].value){
					resultGrid[i][j] = new Node(Arrow.UP, resultGrid[i - 1][j].value);
					System.out.print(resultGrid[i - 1][j].value + " , ");
				}else{
					resultGrid[i][j] = new Node(Arrow.LEFT, resultGrid[i][j - 1].value);
					System.out.print(resultGrid[i][j - 1].value + " , ");
				}
			}
		}
	}

	private void setZeroes(Node[][] resultGrid) {
		for (int i = 0; i < resultGrid.length; i++) {
			resultGrid[i][0] = new Node(Arrow.END, 0);
		}
		for (int j = 0; j < resultGrid[0].length; j++) {
			resultGrid[0][j] = new Node(Arrow.END, 0);
		}
	}
	
}
