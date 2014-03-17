package randomstuff;

public class Something implements ISomething{

	private String name = "not set";
	
	@Override
	public void setName(String s) {
		this.name = s;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
