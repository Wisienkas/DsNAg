package artificial_intelligence.uninformed;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Genetic {
	
	
	private Set<Individual> population;
	private Set<Individual> new_population;
	private IFitnessFunction fitness;
	
	public Genetic(Set<Individual> startTown, IFitnessFunction ff){
		this.population = startTown;
		this.fitness = ff;
	}
	
	public String solveProblem(){
		for(int i = 0; i < population.size(); i++){
			Individual x = randomSelection(population);
			Individual y = randomSelection(population);
			
		}
		
		return null;
	}

	private Individual randomSelection(Set<Individual> population) {
		
		
		
		Random rnd = new Random();
		int[] chances = new int[population.size()];
		Individual[] indies = new Individual[population.size()];
		int count = 0;
		int total = 0;
		for (Individual indi : population) {
			chances[count] = this.fitness.getScore(indi);
			indies[count] = indi;
			total += chances[count];
			count++;
		}
		countUp(chances);
		return indies[select(rnd, chances)];
	}

	private int select(Random rnd, int[] chances) {
		
		int number = rnd.nextInt(chances[chances.length - 1] - 1);
		
		
		return chances.length - 1;
	}

	private void countUp(int[] chances) {
		for(int i = 1; i < chances.length; i++){
			chances[i] = chances[i - 1];
		}
	}
}
