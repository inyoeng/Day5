package pkg.friend;

import java.util.Scanner;

import pkg.other.Friend;

public class FriendAppMain {

	public static void main(String[] args) {

		FriendList list = new FriendList();
		
		//등록
		Friend f = new CompanyFriend("a","가","123","부장");
		list.insert(f);
		System.out.println(f);
		f = new SchoolFriend("초등","나","123");
		list.insert(f);
		System.out.println(f);
		
		//검색
		System.out.println("검색할 이름을 입력하세요");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println(list.SelectOne(name));
		
		//수정
		System.out.println("update");
		f = new SchoolFriend("초등","김기자","123");
		list.update(f);
		System.out.println(f);
		
		//삭제
		list.delete(null);
		System.out.println(f);
		
		
		//전체조회
		list.selectAll();
		
	}

}
