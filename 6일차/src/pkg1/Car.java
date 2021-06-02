package pkg1;

public class Car {
	private String model; //필드 만들면 private 하기
	private int speed;
	private boolean isStop;
	

	public Car() {} //기본생성자 꼭!
	
	public Car(String model, int speed) {
		this.model = model;
		if(speed < 50) {
			speed =50;
		}
		this.speed = speed;
	} //매개변수 두 개 짜리 생성자
	
	public Car(String model) {
		this(model, 0); //speed 또 this 로 불러오지 않고 이렇게도 됨
	}
	
	
	//getters and Setters
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//get이 아니고 그냥 isStop만 나옴. boolean타입에서는 is가 맞음. 
	public boolean isStop() {
		return isStop;
	}
	
	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
}
