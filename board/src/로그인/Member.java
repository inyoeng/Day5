package 로그인;

public class Member {
	String id;
	int pw;
	
	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
}
