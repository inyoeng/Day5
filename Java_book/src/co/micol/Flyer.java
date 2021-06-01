package co.micol;

//인터페이스
//1. 인터페이스는 다중상속 가능. 
//2. public abstract가 생략 되어 있는 거!
//모든 메서드는 추상 메서드가 됨. 
//3. 개발 표준 정해주기 때문에! 중요함. 

public interface Flyer {

	void takeOff();

	void fly();

	void land();

}