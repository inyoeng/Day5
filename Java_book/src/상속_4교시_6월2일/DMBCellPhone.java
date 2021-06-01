package 상속_4교시_6월2일;

public class DMBCellPhone extends CelPhone {
	//channel 만 추가
	int channel;
	
	public DMBCellPhone() {
		super("",""); // 부모생성자 호출하는거 생략은 가능.
		System.out.println("dmbcellphone 기본생성자");
	}
	
	public DMBCellPhone(String model, String color, int channel) {
		super(model, color);// 부모생성자 선택 호출 가능.
		this.channel = channel;
		System.out.println("dmb 생성자");
	}
	
	void turnOnDmb() {
		System.out.println("채널 "+channel+" 번 DMB 방송수신 시작");
	}
	
	void trunOffDmb() {
		System.out.println("DMB 방송수신을 멈춥니다.");
	}
	
	void changeChannel(int channel) {
		this.channel =channel;
		System.out.println("채널 변경");
	}

	@Override
	void powerOn() {
		super.powerOn();
		System.out.println("DMB poweron");
	}
	//override 재 정의 하는 것. 상속 받은 매서드를 고쳐 씀. 
	//cf) overloading 중복 정의 
}
