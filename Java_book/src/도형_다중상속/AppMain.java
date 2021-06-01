package 도형_다중상속;

public class AppMain {

	public static void main(String[] args) {
		
//		Shape s = new Rect(4,5);
//		s.area();
//		s.print();
//		
//		s = new Tri(4,5);
//		s.area();
//		s.print();
		
		Shape [] s = new Shape[3];
		s[0] = new Rect(3,5);//자식이 부모로 자동 형변환 
		s[1] = new Circle(2);
		s[2] = new Tri(5,4);
		
		for(Shape temp :s) {
			temp.area();
			temp.print();
		}
		
		Draw [] s1 = new Draw[3];
		s1[0] = new Rect(3,5);
		s1[1] = new Circle(2);
		s1[2] = new Tri(5,4);
				
		for(Draw temp :s1) {
			temp.draw();
			if(temp instanceof Rect) {
			((Rect)temp).area(); //부모타입을 자식 타입으로는 강제 변환!
			}
			else if( temp instanceof Circle) {
				((Circle)temp).area();
			}else if( temp instanceof Tri) {
				((Tri)temp).area();
				}
			if (temp instanceof Shape) {
				((Shape)temp).area();
				((Shape)temp).print();
			}
			if( temp instanceof Moveable) {
				((Moveable)temp).move();
			}
		}
		
		
	}

}
