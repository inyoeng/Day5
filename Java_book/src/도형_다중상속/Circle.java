package 도형_다중상속;

public class Circle extends Shape implements Draw{
	
	public Circle(int w){
		//super(w);
		this.w = w;
	}

	@Override
	public void area() {
		result = w*w* 3.14;
	}

	@Override
	public void draw() {
		System.out.println("Circle draw");
	}
	
	
}
