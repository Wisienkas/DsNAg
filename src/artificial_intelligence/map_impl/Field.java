package artificial_intelligence.map_impl;

import artificial_intelligence.IPosition;

public class Field implements IPosition {

	private int x;
	private int y;
	private int cost;
	
	public Field(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
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

}
