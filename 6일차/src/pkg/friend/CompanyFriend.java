package pkg.friend;

import pkg.other.Friend;

public class CompanyFriend extends Friend {

	String duty;
	
	public CompanyFriend() {
		super();
	}

	public CompanyFriend(String gubun, String name, String tab,String duty) {
		super(gubun, name, tab);
		this.duty = duty;
	}


	public void print() {
		System.out.printf("회사친구: %20s %20s %20s %20s\n",gubun, name, tab, duty);
	}
	
}
