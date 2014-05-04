package algorithms.charoptimizer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import datastructure.DataNode;

public class CharCounter {
	
	private int[] chars = new int[1 << 8];
	private File file;
	
	public CharCounter(File file){
		this.file = file;
	};
	
	public DataNode[] getCounts(){
		count();
		DataNode[] result = new DataNode[1 << 8];
		for (int i = 0; i < result.length; i++) {
			result[i] = new DataNode(chars[i], i);
		}
		return result;
	}

	private void count() {
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			int in;
			int unSupported = 0;
			while((in = fr.read()) != -1){
				if(in > 1 << 8 || in < 0){
					unSupported++;
					continue;
				}else{
					chars[in]++;
				}
			}
			System.out.println("Meet: " + unSupported + " Unsupported Characters!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if(fr != null){
					fr.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
