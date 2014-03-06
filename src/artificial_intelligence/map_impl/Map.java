package artificial_intelligence.map_impl;

import java.util.Random;

import artificial_intelligence.AStar;
import artificial_intelligence.IMap;
import artificial_intelligence.IPosition;

public class Map implements IMap {
	
	public static void main(String[] args) {
		Map m = new Map();
		m.generateMap(10, 10);
		AStar as = new AStar(m.getPosition(0, 0), m.getPosition(7, 8), m);
	}
	
	private Field[][] map;
	
	private final int costVary = 5;
	
	public Map(){
	}
	
	public void generateMap(int height, int width){
		
		System.out.println("Generating Map..");
		
		Random rnd = new Random();
		this.map = new Field[height][width];
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				this.map[i][j] = new Field(i, j, rnd.nextInt(this.costVary - 1) + 1);
			}
		}
	}
	
	@Override
	public int getCost(IPosition position) {
		
		if(exist(position)){
			return map[position.getX()][position.getY()].getCost();
		}
		return -1;
	}

	private boolean exist(IPosition position) {
		
		if(map.length > position.getX()){
			if(map[position.getX()].length > position.getY()){
				return true;
			}
		}
		return false;
	}

	@Override
	public IPosition[] getNeighbors(IPosition position) {
		IPosition[] result = new IPosition[4];
		
		// up
		result[0] = getPosition(position.getX(), position.getY() - 1);
		
		// down
		result[1] = getPosition(position.getX(), position.getY() + 1);
		
		// left
		result[2] = getPosition(position.getX() - 1, position.getY());
		
		// right
		result[3] = getPosition(position.getX() + 1, position.getY());
		
		return result;
	}

	private IPosition getPosition(int x, int y) {
		if(x < map.length && x >= 0){
			if(y < map[x].length && y >= 0){
				return map[x][y];
			}
		}
		return null;
	}

}
