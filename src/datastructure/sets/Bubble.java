package datastructure.sets;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Bubble {
	
	public Set<Bubble> directions;
	public boolean isUsed = false;
	public Properties props;
	
	public Bubble(){
		directions = new HashSet<>(8);
		props = new Properties();
	}
}
