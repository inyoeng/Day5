package co.micol;

public class Bird extends Animal implements Flyer {
	Bird(){}
	public void run() {
		System.out.println("They run");
	}
	public void eat() {
		System.out.println("They mainly eat insects.");
	}
	public void takeOff	() {
		System.out.println("They take off");
	}
		
	public void fly() {
		System.out.println("Birds are flying");
	}
	public void land() {
		System.out.println("They land");
	}
	public void layEggs() {
		System.out.println("They lay Eggs.");
	}
	
}
