package com.yedam.common;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class StreamExample {

	public static void main(String[] args) {
		//1.스트림 2. 중간처리, 최종처리 3. 결과
		List<Person> list = null;
		PersonDAO dao = new PersonDAO();
		list = dao.getPersonList();
		OptionalDouble avg = list.stream()//stream생성
		.filter((t) -> t.getAge()%2 ==0 ) //(중간처리)필터링기능
		//.filter(t -> t.getId()>900) //id번호가 900이상만
		.mapToInt((p) -> p.getAge())//매핑기능 a->b
		//.forEach(v -> System.out.println(v))//출력
		.average();//나이 평균 구하기
		
		if(avg.isPresent()) { //avg가 있으면
	System.out.println("평균나이: " +avg.getAsDouble()); //avg를 double로 뽑겠다. 
		}else {
			System.out.println("만족하는 요소가 없습니다.");
		}
	}

}
