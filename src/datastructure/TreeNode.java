package datastructure;

public class TreeNode extends DataNode{
	
	public TreeNode(int v, Object o) {
		super(v, o);
	}
	
	public TreeNode parent;
	public TreeNode leftChild;
	public TreeNode rightChild;
}
