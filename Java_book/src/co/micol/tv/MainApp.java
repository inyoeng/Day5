package co.micol.tv;

import java.rmi.Remote;

public class MainApp {
	//명령행 인수
	public static void main(String[] args) {
		
		//SamsungTv tv = new SamsungTv();
		//LgTv tv = new LgTv();
		
		/*
		 * 다형성 만들기
		 * 
		 * 다형성 : 참조하는 대상의 메서드가 호출
		 * 같은 코드라도 참조 대상에 다라서 메서드가 호출되기 떄문에 실행결과가 다름. 
		 * 
		 * 1. 부모타입의 참조 변수가 자식 객체를 참조 할 수 있다.********
		 * 
		 */
		RemoteControl tv = (RemoteControl)BeanFactory.getBean(args[0]);
		
		tv.powerOn();
		tv.volumup();
		tv.volumdown();
		tv.powerOff();
 }
}
