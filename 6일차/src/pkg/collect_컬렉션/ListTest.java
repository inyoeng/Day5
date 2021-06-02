package pkg.collect_컬렉션;

import java.util.ArrayList;
import java.util.LinkedList;

import pkg.friend.CompanyFriend;
import pkg.friend.SchoolFriend;
import pkg.other.Friend;

public class ListTest {
	public static void main(String[] args) {
		
	
	LinkedList<Friend> list = new LinkedList<Friend>();
	list.add(new Friend("학교","인영","010-333"));
	list.add(new CompanyFriend("회사","다영","010-233","사장"));
	list.add(new SchoolFriend("학교","박보검","22030"));
	//list.add(123);
	
	//System.out.println(list);
	
	for (Friend fr: list) {
		System.out.println(fr.getName()); //name이 protected되었으니 getter를 이용하자. 
	}
	System.out.println("===============");
	
	
	//remove
	list.remove(0);
	for (Friend fr: list) {
		System.out.println(fr.getName());
	}
	
	Friend fr = list.get(0); //list의 0번째를 fr에 가지고 옴
	System.out.println("the first name is: " +fr.getName());
	
	//마지막이름 찾기: size
	System.out.println("The last name is: "+ list.get(list.size()-1).getName());
	
	
	//clone
	list.set(1, new Friend("중","서강준","454"));
	for (Friend f: list) {
		System.out.println(f.getName()); 
	}
	
	
	
	}
}
