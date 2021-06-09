package pkg.friend;

import pkg.other.Friend;

public class AppMain {
	public static void main(String[] args) {

		Friend f = new CompanyFriend("학교", "가", "전화번호", "과장");
		f.print();

		Friend s = new SchoolFriend("학교", "가", "전화번호", "1101");
		s.print();

		// FirendAcess manager = BenFactory.getBean(FriendAccess.class);
		FriendManager manager = new FriendManager();// FriendList();
		for (Friend fr : manager.friends) {
			if (fr instanceof CompanyFriend) {

				fr.print();
			}
		}
		manager.selectAll();

		/*
		 * 다형성 (상속 받고 오버라이딩이 전제!) 1. 부모타입의 참조변수가 자식객체를 참조가능 2. 메서드 실행하면 참조한 대상의 메서드가
		 * 호출되므로 결과가 다 다름.
		 * 
		 */
	}

}
