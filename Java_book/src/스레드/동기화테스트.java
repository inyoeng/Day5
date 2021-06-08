package 스레드;

public class 동기화테스트 {

	public static void main(String[] args) {
		//공유객체 : user 1,2가 공유
		
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		user1.setCal(cal); //100 2초 대기
	
		User2 user2 = new User2();
		user2.setCal(cal); //50 2초 대기  두개 총 2초 
							//calculator에서 synchromized걸면 총 4초
		
		user1.start();
		user2.start();
 	}

}
