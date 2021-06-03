package pkg.friend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pkg.other.Friend;

public class FriendList implements FriendAccess{
	
	List<Friend> friends; //리스트는 인터패이스라 new키워드로 생성 불가.->arraylist로
	
	public FriendList (){
		friends = new ArrayList<Friend>();
	}

	@Override
	public void insert(Friend Friend) {
		friends.add(Friend);
	}

	@Override
	public void update(Friend Friend) {
		
	}

	@Override
	public void delete(String name) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
	}

	@Override
	public void selectAll() {
		System.out.println("friend List");
		return;
	}

	@Override
	public Friend SelectOne(String name) {
		for(Friend f : friends) {
			if(f.getName().equals(name)) {
				System.out.println(f);
				return f;
			}
		}
		return null;
	}
	
}
