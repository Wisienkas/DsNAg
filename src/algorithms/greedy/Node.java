package algorithms.greedy;

public class Node {
	
	public enum Arrow{
		LEFT, UP, SLOPING, END;
	}
	
	int value;
	Arrow arrow;
	
	public Node(Arrow arrow, int value){
		this.value = value;
		this.arrow = arrow;
	}
	
}
