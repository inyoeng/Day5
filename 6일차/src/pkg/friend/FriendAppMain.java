package pkg.friend;

import pkg.other.Friend;

public class FriendAppMain {

	public static void main(String[] args) {

		FriendList list = new FriendList();
		
		//등록
		Friend f = new CompanyFriend("a","가","123","부장");
		list.insert(f);
		f = new SchoolFriend("초등","가","123");
		list.insert(f);
		
		//검색
		System.out.println(list.SelectOne(null));
		
		//수정
		
		f = new SchoolFriend("초등","김기자","123");
		list.update(f);
		
		//삭제
		list.delete(null);
		
		
		//전체조회
		list.selectAll();
		
	}

}
