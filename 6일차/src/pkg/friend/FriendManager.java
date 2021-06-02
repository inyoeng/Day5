package pkg.friend;
/*
 * 클래스 중첩 가능. but public은 중첩 안됨.
 */

import java.util.List;

import pkg.other.Friend;

public class FriendManager implements FriendAccess {
	Friend[] friends = new Friend[5];

	public FriendManager() {
		friends[0]= new CompanyFriend("삼성","가","010-123","부장");
		friends[1]= new SchoolFriend("나원초","나","010-134","0101");
		friends[2]= new CompanyFriend("삼성","다","010-1453","과장");
		friends[3]= new SchoolFriend("화랑중","라","010-1354544");
		friends[4]= new CompanyFriend("네이버","마","010-1114123","");
		
	}
	
	
	@Override
	public void insert(Friend Friend) {
		
	}

	@Override
	public void update(Friend Friend) {
		
	}

	@Override
	public void delete(Friend Friend) {
		
	}

	@Override
	public List selectAll() {
		System.out.println("Friend Manager");
		return null;
	}

	@Override
	public Friend SelectOne(Object key) {
		return null;
	}
	
	
	
}
