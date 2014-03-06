package artificial_intelligence;

import java.util.Comparator;

public class Node implements Comparator<Node>{
	
	private IPosition position;
	
	private int g_score;
	private int f_score;
	
	public Node parent;
	
	public Node(IPosition position, int g_score, int f_score){
		this.position = position;
		this.f_score = f_score;
		this.g_score = g_score;
	}
	
	public int getFScore(){
		return this.f_score;
	}
	
	public int getGScore(){
		return this.g_score;
	}
	
	public void update(int g_score, int f_score){
		this.g_score = g_score;
		this.f_score = f_score;
	}
	
	public IPosition getPosition(){
		return this.position;
	}

	@Override
	public int compare(Node n1, Node n2) {
		
		return n1.getFScore() - n2.getFScore();
	}
	
}
