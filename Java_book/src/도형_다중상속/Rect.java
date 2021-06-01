package 도형_다중상속;

public class Rect extends Shape implements Draw,Moveable{
	int h;
	
	Rect(int h, int w){
		this.h =h;
		this.w =w;
	}

	@Override
	public void area() {
		result = w*h;
	}

	@Override
	public void draw() {
		System.out.println("직사각형을 그리자!");
	}

	@Override
	public void move() {
		System.out.println("move it");
	}
}
	
	
