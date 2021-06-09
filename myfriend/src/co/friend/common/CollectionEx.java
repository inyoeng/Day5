package co.friend.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionEx {
	public static void main(String[] args) {
		List<String> list = null;
		list = new ArrayList<String>(); //구현 클래스
		list.add("im");
		list.add("jung");
		list.add("jung");
		list.add("choi");
		
		list.remove(0);
		
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Set<String> set = new HashSet<>();
		set.add("Hong");
		set.add("Hong");
		set.add("j");
		set.add("he");
		
		//중복된 값 허용하지 않음.
		System.out.println("<Set>");
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String value = iter.next();
			System.out.println(value);
		}
		}
	}

