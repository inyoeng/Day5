package Wrapper;

import java.util.ArrayList;
import java.util.List;

/*
 * 1. 기본 데이터 타입을 객체화
 * 2. 타입 변환
 */

public class WrapperTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));
		list.add(new Integer(10)); //박싱
		list.add(100); //오토 박싱: integer로 자동 박싱 됨
	
		Integer a = 100;
		int b =a.intValue(); //언박싱
		b =a;  // 오토 언박싱: 포장 풀어서 int 값만 가져옴
		
		String s = Integer.toString(a);
	
	}
}
