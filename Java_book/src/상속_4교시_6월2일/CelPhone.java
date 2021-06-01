package 상속_4교시_6월2일;

public class CelPhone {
	String model;
	String color;
	
	public CelPhone() {
		System.out.println("cellphone 기본생성자");
	}

	public CelPhone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
		System.out.println("cellphone 생성자");
	}
	
	void powerOn() {
		System.out.println("Power on");
	}
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	void bell() {
		System.out.println("벨이 울립니다.");
	}
}
