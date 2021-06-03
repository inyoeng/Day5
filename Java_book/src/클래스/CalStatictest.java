package 클래스;

public class CalStatictest {

	public static void main(String[] args) {
		//정적 멤버는 클래스 이름으로 직접 접근이 가능. 
		//객체 생성하지 않고도 클래스 이름으로 직접 가능. 
		
		//CalStatic.pi = 3.141592;
		System.out.println(CalStatic.PI);

		
		System.out.println(CalStatic.add(5, 7));
//		CalStatic c2 = new CalStatic();
//		c2.pi = 3; 
//		System.out.println(c2);
	}

}
