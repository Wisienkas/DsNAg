package artificial_intelligence.uninformed;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Genetic {
	
	private static Random staRnd = new Random();
	public static final char[] regex = new char[]{
//			'1','2','3','4','5','6','7','8','9','0',
			'q','w','e','r','t','y','u','i','o','p',
			'a','s','d','f','g','h','j','k','l',
			'z','x','c','v','b','n','m'
	};
	
	private TreeSet<Individual> population;
	private TreeSet<Individual> new_population;
	private IFitnessFunction fitness;
	private Random rnd = new Random();
	private Individual bestIndividual;
	private int indi_length;
	
	
	
	public Genetic(TreeSet<Individual> startTown, IFitnessFunction ff, int length){
		this.indi_length = length;
		for (Individual individual : startTown) {
			if(individual.parts.length != length){
				System.out.println("Invalid length!");
				System.exit(1);
			}
		}
		this.population = startTown;
		this.fitness = ff;
		
		
		System.out.println("Starting Town!");
		for (Individual indi : population) {
			System.out.println(getString(indi.parts) + "\tScore: " + fitness.getScore(indi));
		}
	}
	
	public Genetic(IFitnessFunction ff, int length, int size){
		this(getRandomPopulation(length, size), ff, length);
	}
	
	private static TreeSet<Individual> getRandomPopulation(int length, int size) {
		TreeSet<Individual> starties = new TreeSet<Individual>();
		for(int i = 0; i < size; i++){
			starties.add(getRandomIndividual(length));
		}
		return starties;
	}

	public Individual solveProblem(long timeout){
		long start = System.currentTimeMillis();
		long generation = 0;
		boolean newBest = false;
		if(population == null){
			System.out.println("Population not instanziated!");
			System.exit(1);
		}
		for (Individual indi : population) {
			fitness.satisfied(indi);
			if(bestIndividual == null || fitness.getScore(indi) > fitness.getScore(bestIndividual)){
				bestIndividual = indi;
			}
		}
		while(timeout == 0 || start + timeout > System.currentTimeMillis()){
			new_population = new TreeSet<Individual>();
			new_population.add(bestIndividual);
			for(int i = 0; i < population.size() - 1; i++){
				Individual z;
				if(i % 4 == 0){
					Individual x = randomSelection(population);
					Individual y = randomSelection(population);
					z = merge(x, y);
				}else{
					z = getRandomIndividual(this.indi_length);
				}
				if(bestIndividual == null || fitness.getScore(z) > fitness.getScore(bestIndividual)){
					bestIndividual = z;
					partsToString(z);
					System.out.println("Generation: " + generation);
					newBest = true;
				}
				if(fitness.satisfied(z)){
					return z;
				}
				new_population.add(z);
			}
			population = new_population;
			generation++;
			if(newBest){
				for (Individual indi : population) {
					System.out.println(getString(indi.parts) + "\tScore: " + fitness.getScore(indi));
				}
				newBest = false;
			}
		}
		return bestIndividual;
	}

	private String getString(char[] parts) {
		String s = "";
		for (int i = 0; i < parts.length; i++) {
			s += parts[i];
		}
		return s;
	}

	private void partsToString(Individual z) {
		System.out.println("Best so far: " + getString(z.parts) + "\tScore: " + fitness.getScore(z));
	}

	private Individual merge(Individual x, Individual y) {
		int x_parts = rnd.nextInt(x.parts.length - 1) + 1;
		Individual indi = new Individual(x, y, x_parts);
		if(rnd.nextBoolean()){
			return getRandomIndividual(x.parts.length);
		}
		return rnd.nextInt() % 8 == 0 ? mutate(indi) : indi;
	}

	private static Individual getRandomIndividual(int length) {
		char[] parts = new char[length];
		for(int j = 0; j < length; j++){
			parts[j] = getRandomPart();
		}
		return new Individual(parts);
	}

	private void randomize(Individual indi) {
		char[] old = indi.parts;
		char[] new_c = new char[old.length];
		boolean[] used = new boolean[old.length];
		int count = old.length;
		int index = 0;
		while(count > 0){
			int num = rnd.nextInt(old.length);
			if(!used[num]){
				new_c[index] = old[num];
				used[num] = true;
				count--;
				index++;
			}
		}
	}

	private Individual mutate(Individual indi) {
		
		int index = rnd.nextInt(indi.parts.length);
		indi.parts[index] = getRandomPart();
		
		return indi;
	}

	private static char getRandomPart() {
		return regex[staRnd.nextInt(regex.length)];
	}

	private Individual randomSelection(TreeSet<Individual> population) {
		Individual[] indies = getHighestIndies(population, 3);
		int[] chances = new int[population.size()];
		Individual[] indies = new Individual[population.size()];
		int count = 0;
		for (Individual indi : population) {
			chances[count] = this.fitness.getScore(indi);
			indies[count] = indi;
			count++;
		}
		chances = countUp(chances);
		return indies[select(chances)];
	}

	private Individual[] getHighestIndies(TreeSet<Individual> population, int i) {
		Individual[] indies = new Individual[i];
		for(int i = 0; i < 0; i++){
			population.
		}
		
		return null;
	}

	private int select(int[] chances) {
		if(chances[chances.length - 1] == 0){
			return rnd.nextInt(chances.length);
		}
		int number = rnd.nextInt(chances[chances.length - 1]);
		for(int i = chances.length - 1; i >= 0; i--){
			if(number > chances[i]){
				return i + 1;
			}
		}
		return 0;
	}

	private int[] countUp(int[] chances) {
		for(int i = 1; i < chances.length; i++){
			chances[i] = chances[i - 1];
		}
		return chances;
	}
}
