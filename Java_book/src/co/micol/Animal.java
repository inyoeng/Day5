package co.micol;

public abstract class Animal {
	
	Animal (){}
	public void run() {
		System.out.println("We run.");
	}
	public abstract void eat();
	public void sleep() {
		System.out.println("we sleep.");
	}

}
