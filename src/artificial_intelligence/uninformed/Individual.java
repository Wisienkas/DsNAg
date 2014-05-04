package artificial_intelligence.uninformed;


public class Individual {
	
	public char[] parts;
	
	public Individual(char[] seed){
		parts = seed;
	}
	
	public Individual(Individual i1, Individual i2, int i1_parts){
		parts = new char[i1.parts.length];
		for(int i = 0; i < parts.length; i++){
			parts[i] = i < i1_parts ? i1.parts[i] : i2.parts[i];
		}
	}
}
