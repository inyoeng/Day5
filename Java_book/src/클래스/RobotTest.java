package 클래스;

public class RobotTest {

	public static void change(int a) {//참조변수
		a += 10; //지역 변수라서 스택에 쌓이고 다시 main함수 가면 지워짐. 스택에는 남아있다. 
	}
	
	
	
	public static void change(Robot robot) {
		robot.setArm(5);
	}
	

	
	public static void main(String[] args) {
		/*
		 * 2. new로 객체 생성
		 */
		
		//Robot r = new Robot(2.4);
		//r.arm =2;
		//r.leg=4; //값 바꾸기 가능(접근 못하게 만드려면 private로 바꿔)
		Robot r2 = new Robot(2,2);
		change(r2);
		System.out.println(r2.getArm());
		
		
		int a  = 1;
		change(a);
		System.out.println(a);
		
		/*
		 * 3. 객체 사용(메서드 호출)
		 */
		r2.print();
		
	}

}
