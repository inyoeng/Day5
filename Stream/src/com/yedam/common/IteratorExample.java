package com.yedam.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IteratorExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hong","Park","Choi"); // 한번에 넣을 수 있다. 
		Iterator<String> iter = list.iterator(); //반복된 요소를 지정하고 사용위해 반복자 선언.
		while(iter.hasNext()) {
			String val = iter.next();
			System.out.println(val.toUpperCase().length());
		}
		
		//간략한 표현위해 stream사용
		System.out.println("<Stream>");
		Stream<String> stream = list.stream();
		
		stream.forEach(new Consumer<String>() {
			
			//consumer의 추상메서드
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		});
		
		//sample요소를 db에서 가져오도록 한다.
		
		PersonDAO dao = new PersonDAO();
		ArrayList <Person> persons = dao.getPersonList();
		Stream<Person> pStream = persons.stream();
		pStream.forEach(new Consumer<Person>() {

			@Override
			public void accept(Person t) {
				System.out.println(t.toString());
			}});
		
		
		//이를 람다식으로 줄이기
		PersonDAO dao1 = new PersonDAO();
		ArrayList <Person> persons1 = dao1.getPersonList();
		Stream<Person> pStream1 = persons1.stream();
		Long cnt = pStream1
		.filter((t) ->  t.getAge()>20//return값이 참인 경우만 다음으로! 
				)
		.filter((t) -> t.getName().startsWith("i"))
		//.forEach((t) ->System.out.println(t.toString())); //리스트 처리하거나
		.count();
		System.out.println("최종처리건수: "+cnt);
	}
}
