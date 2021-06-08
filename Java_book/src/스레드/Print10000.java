package 스레드;

public class Print10000 implements Runnable {

	 //이건 스체드가 아니고 스레드로 실행가능한.(Runnable)-> 스레드 만들어야..
	@Override
	public void run() {
		for (int i = 10000; i <10100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
	}
	}
	
}
