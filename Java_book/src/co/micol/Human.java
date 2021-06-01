package co.micol;

public class Human extends Animal{
	Human() {}
	public void think() {
		System.out.println("인간은 생각하는 동물이다. ");
	}
	@Override
	public void eat() {
		System.out.println("Human eats beef");
		
	}
}
