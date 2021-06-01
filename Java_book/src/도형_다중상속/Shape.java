package 도형_다중상속;

public abstract class Shape {
	int w;
	double result;
	
	Shape(){}
	
	public Shape(int w, int h) {
		this.w= w;
		
	}
	public void print() {
		System.out.println("면적="+result);
	}
	public abstract void area();
	
}
