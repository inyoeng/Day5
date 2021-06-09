package co.friend.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import co.friend.access.FriendAccess;
import co.friend.access.FriendDAO;
import co.friend.model.Friend;

public class CollectionEx2 {

	public static void main(String[] args) {
		System.out.println("hello".hashCode());
		System.out.println("hello".hashCode());
		System.out.println("hi".hashCode());
		"hello".hashCode();
		
		
		Set<Friend> set = new HashSet<>();
		
		FriendAccess dao =new FriendDAO();
		
		ArrayList<Friend> list = dao.selectAll();	
		for(int i =1; i <list.size();i++) {
			set.add(list.get(i));// 중복을 제거하는 Set값을 담는다. 
			System.out.println(list.get(i));
		}
		
		System.out.println("<set>");
		for(Friend fr : set) {
			System.out.println(fr);
		}
		
	}

}
