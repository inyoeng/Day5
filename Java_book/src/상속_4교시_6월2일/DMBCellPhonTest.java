package 상속_4교시_6월2일;

public class DMBCellPhonTest {

	public static void main(String[] args) {
		DMBCellPhone phone = new DMBCellPhone();
		DMBCellPhone dmb = new DMBCellPhone("삼성","검정",10);
		
		System.out.println(dmb.color);
		System.out.println(dmb.model);
		System.out.println(dmb.channel);
		
		dmb.powerOn();
		dmb.bell();
		dmb.turnOnDmb();
		dmb.changeChannel(11);
		dmb.trunOffDmb();
		dmb.powerOff();
	}

}
