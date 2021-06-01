package 클래스_2교시_6월1일;

public class CalStatic {

	final static double PI = 3.14;
	//final 은 변경 불가. 상수가 됨. -> 상수는 대문자로
	//static은 모든 객체가 공유하는 필드. 객체 생성하지 않고도 클래스 이름으로~
	@Override
	public String toString() {
		return "CalStatic [pi=" + PI + "]";
	}
	
	
	
	public static int add(int inNum1, int inNum2) {
		return inNum1 +inNum2;
	}
}
