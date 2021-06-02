package pkg.friend;

import pkg.other.Friend;

public class SchoolFriend extends Friend {
	
	
	public SchoolFriend(String gubun, String name, String tab,String birth) {
		super(gubun, name, tab);
		this.birth = birth;
	}

	String birth;
	public SchoolFriend(String birth) {
		super();
		this.birth = birth;
	}
	
	public SchoolFriend(String gubun, String name, String tab) {
		super(gubun, name, tab);
		
	}
	
	public void print() {
		System.out.printf("학교친구: %20s %20s %20s %20s\n",gubun,name,tab,birth);
	}

}
