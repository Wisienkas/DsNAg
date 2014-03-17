package randomstuff;

public class User {
	
	public static void main(String[] args) {
		Giver g = new Giver();
		
		ISomething S1 = g.getSomething();
		ISomething S2 = g.getSomething();
		if(S1 == null){
			System.out.println("S1: null");
			return;
		}
		if(S2 == null){
			System.out.println("S2: null");
			return;
		}
		
		System.out.println("S1 : " + S1.getName());
		System.out.println("S2 : " + S2.getName());
		
		S1.setName("other");
		
		System.out.println("S1 : " + S1.getName());
		System.out.println("S2 : " + S2.getName());
	}
	
}
