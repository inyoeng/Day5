package co.micol.tv;

public class LgTv implements RemoteControl{
	
	LgTv(){
		System.out.println("Lg Tv");
	}
	@Override
	public void powerOn() {
		System.out.println("LG tv -- 전원 on");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LG tv -- 전원 on");
		
	}

	@Override
	public void volumup() {
		System.out.println("LG tv -- Volume up");
	}

	@Override
	public void volumdown() {
		System.out.println("LG tv -- Volume down");		
	}

}
