package co.micol;

public class AppMain {

	public static void main(String[] args) {
		Human human = new Human();
		human.sleep();
		human.think();
		
		Bird bird = new Bird();
		bird.eat();
		bird.fly();
		
		Superman superman = new Superman();
		superman.fly();
	}

}
