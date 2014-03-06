package artificial_intelligence;

public interface IMap {
	
	public int getCost(IPosition position);

	public IPosition[] getNeighbors(IPosition position);
}
