package 클래스_2교시_6월1일;

/*
 * 1. 클래스 선언
 */
public class Robot {
	
	//필드
	//private(클래스 내부에서만 접근 가능) 접근 제한자.
	private int arm;
	private int leg; //leg못 바꾸게 만들었다.
	private String name;
	
	//setter: 필드 값 변경 
	public void setArm(int arm) {
		this.arm =arm;
	}
	
	
	
	public void setLeg(int leg) {
		this.leg = leg;
	}



	//getter : 필드 값 조회
	public int  getArm() {
		return this.arm;
	}
	
	public int getLeg() {
		return this.leg;
	}
	
	
	//일반 메서드
	public void print() {
		System.out.printf("arm :%d leg : %d",arm,leg);
	}
	
	
	
	
	//생성자 선언
	
	//기본 생성자 : 아무것도 넣지 않으면 컴파일러가 기본으로 생성해 주는 생성자. 
	//기본 생성자랑 인수 있는 생성자 쌍으로 만들자.
	//(하나라도 매개변수 있는 생성자 만들면 컴파일러가 생성 안해줌)
	
	public Robot() {}
	
	public Robot (int arm, int leg) {
		this.arm = arm; //필드에 있는 arm에 접근하기 위해 this 사용
		this.leg = leg; //this는 자기 자신 객체를 참조하는 참조 변수(객체 저장하는 변수 = 참조변수)
	}


	//name 까지 초기화 하는 생성자 만듬. 
	public Robot(int arm, int leg, String name) {
		super();
		this.arm = arm;
		this.leg = leg;
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
