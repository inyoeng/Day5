package 도형_다중상속;

public class Tri extends Shape implements Draw{
	int h;
	Tri(int h, int w){
		//super(w);
		this.h = h;
		this.w = w;
	}

	@Override
	public void area() {
		result = w*h /2;
	}

	@Override
	public void draw() {
		System.out.println("Triangle draw");
	}

	
	
	
}
