package 클래스_2교시_6월1일;

public class RobotTest {

	public static void main(String[] args) {
		/*
		 * 2. new로 객체 생성
		 */
		
		//Robot r = new Robot(2.4);
		//r.arm =2;
		//r.leg=4; //값 바꾸기 가능(접근 못하게 만드려면 private로 바꿔)
		Robot r2 = new Robot(2,2);
		System.out.println(r2.getArm());
		System.out.println(r2.getLeg());
		
		
		/*
		 * 3. 객체 사용(메서드 호출)
		 */
		r2.print();
		
	}

}
