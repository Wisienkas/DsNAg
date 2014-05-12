package artificial_intelligence.suduko;

public class Suduko {
	
	int[][] map = new int[9][9];
	
	public Suduko(int[][] aMap){
		map = aMap;
	}
	
	public Suduko(){
	}
	
	public boolean solve(int[][] map, int row, int column, int number){
		if(Constraints.ValidColumn(map[row]) && 
				Constraints.ValidRow(getValidRow(map, column)) &&
				Constraints.ValidBox(getBox(map, row, column)));
		
	}

	private int[] getBox(int[][] map, int row, int column) {
		int j, i;
		i = (row / 3) * 3
		return null;
	}

	private int[] getValidRow(int[][] map, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
