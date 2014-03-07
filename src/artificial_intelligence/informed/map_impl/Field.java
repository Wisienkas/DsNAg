package artificial_intelligence.informed.map_impl;

import artificial_intelligence.informed.IPosition;


public class Field implements IPosition {

	private int x;
	private int y;
	private int cost;
	private boolean inOptimal;
	
	public Field(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	@Override
	public int getCost(){
		return this.cost;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public boolean inOptimal(){
		return this.inOptimal;
	}
	
	@Override
	public void setInOptimal(){
		this.inOptimal = true;
	}
}
