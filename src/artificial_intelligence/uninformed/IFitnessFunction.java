package artificial_intelligence.uninformed;

public interface IFitnessFunction {
	public int getScore(Individual individual);
	public boolean satisfied(Individual individual);
}
