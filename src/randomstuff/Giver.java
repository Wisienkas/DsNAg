package randomstuff;

import java.util.ArrayList;

public class Giver{
	
	private ArrayList<Something> myObject;
	private int count = 0;
	
	public Giver(){
		this.myObject = new ArrayList<>();
	}
	
	public ISomething getSomething(){
		this.myObject.add(new Something());
		if(!(count < this.myObject.size())){
			return null;
		}
		Something s1 = this.myObject.get(count);
		
		count++;
		return s1;
		
	}
}
