package artificial_intelligence.uninformed.implementation;

import artificial_intelligence.uninformed.Genetic;
import artificial_intelligence.uninformed.IFitnessFunction;
import artificial_intelligence.uninformed.Individual;

public class FindName implements IFitnessFunction{
	
	public static void main(String[] args) {
		FindName fn = new FindName("Nikolaj");
		Genetic gene = new Genetic(fn, "Nikolaj".length(), 50);
		Individual result = gene.solveProblem(50000);
//		String s = "";
//		for (int i = 0; i < result.parts.length; i++) {
//			s += result.parts[i];
//		}
//		System.out.println("RESULT: " + s);
	}
	
	private char[] check;
	private int max;
	
	public FindName(String name){
		check = name.toCharArray();
		max = (check.length * 5) + (check.length * 3);
	}

	@Override
	public int getScore(Individual individual) {
		int score = check.length * 3;
		boolean[] duplies = new boolean[check.length];
		for (int i = 0; i < individual.parts.length; i++) {
			for (int j = 0; j < check.length; j++) {
				if(Character.toLowerCase(check[j])  == Character.toLowerCase(individual.parts[i])){
					if(j == i){
						if(duplies[j]){
//							score += 2;
//							break;
						}else{
							score += 5;
							duplies[j] = true;
							break;
						}
					}else if(!duplies[j]){
//						score += 2;
//						duplies[j] = true;
//						break;
					}
				}
			}
		}
		return score;
	}

	@Override
	public boolean satisfied(Individual individual) {
		return getScore(individual) == this.max;
	}
	
}
