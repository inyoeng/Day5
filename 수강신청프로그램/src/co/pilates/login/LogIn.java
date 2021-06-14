package co.pilates.login;

public class LogIn {
	String id;
	String pw;
	
	@Override
	public String toString() {
		return "LogIn [id=" + id + ", pw=" + pw + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
