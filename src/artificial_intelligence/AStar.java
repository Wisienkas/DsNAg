package artificial_intelligence;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AStar {

	private Map<IPosition, Node> closedset; // set of nodes already evaluated
	private PriorityQueue<Node> openset; // nodes to be evaluated
	private Map<IPosition, Node> openset_check;
	private IMap map; // map of navigated nodes
	
	private int heuristicFactor = 1;
	
	private IPosition goal;
	private int g_score; // cost from start along best known path
	private int f_score; // estimated cost from start to goal
	
	public AStar(IPosition start, IPosition goal, IMap map){
		
		if(start == null || goal == null){
			System.out.println("Null goal or start for A*... \nSystem Closing...");
			System.exit(1);
		}
		
		this.map = map;
		this.goal = goal;
		this.g_score = map.getCost(start);
		this.f_score = g_score + heuristic_cost_estimate(start, goal);
		
		Node node = new Node(start, this.g_score, this.f_score);
		
		this.openset_check = new HashMap<>();
		this.openset = new PriorityQueue<>(10, node);
		this.openset.add(node);
		this.openset_check.put(start, node);
		this.closedset = new HashMap<>();
		
		Process();
	}

	private Node Process() {
		
		System.out.println("Started to process optimal way from start to goal");
		long tries = 0;
		while(!this.openset.isEmpty()){
			tries++;
			Node current = this.openset.poll();
			if(getDistance(current.getPosition(), goal) == 0){
				System.out.println("Found Solution in: " + tries + " Tries!");
				return reconstruct_path(current);
			}
			this.closedset.put(current.getPosition(), current);
			this.openset_check.remove(current.getPosition());
			for (IPosition neighbor : getNeighbors(current)) {
				if(neighbor == null || this.closedset.containsKey(neighbor)){
					continue;
				}
				int temp_g_score = current.getGScore() + neighbor.getCost();
				
				if(!openset_check.containsKey(neighbor) || betterSolution(temp_g_score, neighbor)){
					Node from = current;
					Node neighborNode;
					
					int new_g_score = temp_g_score;
					int new_f_score = temp_g_score + heuristic_cost_estimate(neighbor, goal);
					if(openset_check.containsKey(neighbor)){
						neighborNode = openset_check.get(neighbor);
						neighborNode.update(new_g_score, new_f_score);
						neighborNode.parent = from;
					}else{
						neighborNode = new Node(neighbor, new_g_score, new_f_score);
						neighborNode.parent = from;
						this.openset.add(neighborNode);
						this.openset_check.put(neighbor, neighborNode);
					}
					
				}
				
			}
		}
		System.out.println("Failed to find way...");
		return null;
	}

	private boolean betterSolution(int temp_g_score, IPosition neighbor) {
		if(this.openset_check.containsKey(neighbor)){
			if(temp_g_score < this.openset_check.get(neighbor).getGScore()){
				return true;
			}
		}
		return false;
	}

	private IPosition[] getNeighbors(Node current) {
		
		IPosition[] result = new IPosition[4];
		result = map.getNeighbors(current.getPosition());
		
		return result;
	}

	private Node reconstruct_path(Node current) {
		if(current.parent != null){
			reconstruct_path(current.parent);
		}
		System.out.println("Field x: " + current.getPosition().getX() + "\ty: " + 
						current.getPosition().getY() + "\tcost of f: " + current.getFScore() + 
						"\tcost of g: " + current.getGScore());
		return current;
	}

	private int heuristic_cost_estimate(IPosition start, IPosition goal) {
		return getDistance(start, goal) * this.heuristicFactor;
	}
	
	private int getDistance(IPosition p1, IPosition p2){
		return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
	}
	
}
