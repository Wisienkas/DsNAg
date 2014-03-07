package artificial_intelligence.informed;

public interface IMap {
	
	public int getCost(IPosition position);

	public IPosition[] getNeighbors(IPosition position);
}
