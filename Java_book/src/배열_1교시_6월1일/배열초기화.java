package 배열_1교시_6월1일;

public class 배열초기화 {
	public static void main(String[] args) {
		
		//1차원 배열
		//배열 선언 -. 배열고 객체로 인식! new 힙영역에 핡당해야 함. 
		//베얄은 크기 고정!
		/*
		 * 순차적으로 데이터 저장하고 읽는 용도.
		 * 추가 삭제 번거롭다. 
		 */
		
		int [] a;  //배열 선언
		a = new int[10]; // 숫자는 크기를 말함. 저장할 크기 미리 정해줌 
		//배열 값 초기화 
		//배열은 index를 지정해서 방 번호에 값을 넣거나 불러올 수 있다.
		a[0] = 10;
		a[1] = 20;
		a[2] = 20; // 지정 안했으면 초기 값은 0
		a[3] = 90; //10이면 0~9까지 쓸 수 있다. for 문으로 쓰면 쉽다. 
		
		
		//배열 출력
		for(int i = 0 ; i < a.length ; i++){
		
			System.out.println(a[i]);
		}
		System.out.println();
		
		
		//삭제 기능 (삭제할 인덱스 다음부터 하나씩 앞으로 하나씩 당겨짐
		 
		for (int i =2; i <a.length ; i++){
			System.out.println(a[i-1] = a[i]);
		}
		System.out.println();
		
		//배열 선언과 초기화 한꺼번에 하기.
		int [] b = {100,200,300}; // == int [3] b = {100,200,300};
		System.out.println("배열크기: "+ b.length);
		
	}
}
