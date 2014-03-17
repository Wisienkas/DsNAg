package algorithms.treesort;

public class Node {
	
	public boolean black;
	public Node leftChild;
	public Node rightChild;
	public Node parent;
	public Element element;
	
	public Node(Node parent, Element e){
		this.parent = parent;
		this.element = e;
	}
	
}
