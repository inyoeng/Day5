package co.friend.model;

public class Friend {
	
	protected String gubun;
	protected String name;
	protected String tab;
	
	public Friend() {}
	public Friend(String gubun, String name, String tab) {
		super();
		this.gubun = gubun;
		this.name = name;
		this.tab = tab;
	}
	
	@Override
	public String toString() {
		return "Friend [gubun=" + gubun + ", name=" + name + ", tab=" + tab + "]";
	}
	public void print() {
		System.out.printf("친구: %20s %20s %20s\n",gubun,name,tab);
	}
	
	
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}

	
}
