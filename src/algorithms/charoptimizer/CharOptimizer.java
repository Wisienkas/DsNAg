package algorithms.charoptimizer;

import java.io.File;

import datastructure.DataNode;
import datastructure.TreeNode;

public class CharOptimizer {
	
	private File file;
	
	public CharOptimizer(File file){
		
		this.file = file;
	}
	
	public TreeNode getOptimizationTree(){
		CharCounter cc = new CharCounter(file);
		
		DataNode[] chars = cc.getCounts();
		
		
		
		
	}
	
}
