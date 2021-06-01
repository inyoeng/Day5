package 도형_다중상속;

public class AppMain2 {
	
	public static void main(String[] args) {
	Shape s = new Rect(4,5);
	execute(s);
	
	s =new Circle(4);
	execute(s);
	
	}
	
	public static void execute(Shape s) {
		if ( s instanceof Draw) {
		((Draw)s).draw();
		}
		if ( s instanceof Moveable) {
		((Moveable)s).move();}
		s.area();
	}
	}
	
	

