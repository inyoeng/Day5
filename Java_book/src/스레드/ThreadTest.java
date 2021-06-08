package 스레드;

/*
 * 방법 1. 스레드 상속받아서 
 */

public class ThreadTest {

	public static void main(String[] args) {
		
		Print100 print100 = new Print100();		
		//new Print1000.start
		print100.setPriority(Thread.MIN_PRIORITY);
		print100.start();
		System.out.println(print100.getName());
		Thread thread2 = new Thread(new Print1000());
		thread2.start();
		
		Thread thread1 = new Thread(new Print10000());
		thread1.start();
		
		//익명객체
		//(클래스 선언과 객체 생성을 한꺼번에: 익명객체 통해 425p)
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 2000; i <2100; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
			}}});
		thread3.start();
		
	
	
	//익명객체 람다식으로 만들기
	//구현 클래수, 구현 메서드가 하나 뿐일 때만 쓸 수 이싿. 
	
	Thread thread4 = new Thread( () ->  {
			for (int i = 3000; i <3100; i++) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}});
	thread4.start();
	

	
	}
}

