package co.micol.tv;

public class SamsungTv implements RemoteControl{
	
	public SamsungTv(){
		System.out.println("samsung tv 객체생성");
	}
	@Override
	public void powerOn() {
		System.out.println("samsung tv -- 전원 on");
		
	}

	@Override
	public void powerOff() {
		System.out.println("samsung tv -- 전원 off");		
	}

	@Override
	public void volumup() {
		System.out.println("samsung tv -- Volume up");		
	}

	@Override
	public void volumdown() {
		System.out.println("samsung tv -- Volume down");		
	}

}
