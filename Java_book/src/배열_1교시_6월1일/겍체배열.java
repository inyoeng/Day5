package 배열_1교시_6월1일;

import java.awt.Point;

/*
 * 객체 배열 = 배열의 요소 타입이 객체인경우
 */
public class 겍체배열 {
	public static void main(String[] args) {
		//변수 선언, a는 지역변수 
		Score [] a;
		a = new Score[10];
		a[0] = new Score("in", 100, 100, 100);
		a[1] = new Score("young", 95, 100, 70);
		a[2] = new Score("hs", 60, 50, 40);
	
	
	for (int i = 0; i < a.length ; i++) {
		if(a[i] != null) {//null오류 안나도록 ... 10개 있다고 했는데
		System.out.println(a[i].name);
		}
	}
	
	//선언과 동시에 초기화 
	Score[] b = {new Score("in", 100, 100, 100),
			new Score("young", 95, 100, 70),
			new Score("hs", 60, 50, 40)};
	               //in 배열 변수 = 확장 for 문.
	for (Score score :b) {//b를 반복하게따, = 향상된 for문이라고 부름. 
		System.out.print(score.name+" ");
		System.out.println(score.total);
	}
	
	//객체배열
	//point x,y좌표 값 저장
	
	Point [] c = {new Point(10,10),
			new Point(30,10),
			new Point(30,30),
			new Point(10,30)};
	
	//확장 for문 이용해서 x,y좌표 출력
	
	for (Point point: c) {
		System.out.println(point.x+" & "+ point.y);
	}
	
}
}
