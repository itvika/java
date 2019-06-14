package bank;

public class Person {
	private String name;
	
	Person(String n){
		this.name=n;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
