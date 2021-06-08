package 스레드;

public class User1 extends Thread {

	private Calculator cal;

	
	public void setCal(Calculator cal) {
		this.cal = cal;
		this.setName("User1");
	}


	@Override
	public void run() {
		cal.setMemory(100);
		super.run();
	}
	}

	

