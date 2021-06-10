package co.yedam.lamda;

//람다쓰기!

//함수적 표현이 가능한 인터페이스
@FunctionalInterface
interface Run {
	void run();
}

class RunCls implements Run{
	//인터페이스 구현 객체
	@Override
	public void run() {
		System.out.println("Running!");
	}
	
}

public class FunctionalEx1 {

	public static void main(String[] args) {
		RunCls cls = new RunCls();
		cls.run();
		
		
		//인터페이스는 new안되지만 ....위에서 익명 객체 만들어줌
		//쉽게 람다 표현식으로 쓰기!
		//consumer type functional interface : 리턴타입 없다. 
		Run r = () ->	System.out.println("Running fast!");
			
		
		r.run();
		
	}

}
