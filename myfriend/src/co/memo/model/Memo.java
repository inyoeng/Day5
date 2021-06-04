package co.memo.model;

public class Memo {

	protected String date;
	protected String content;

	public Memo() {
	}

	@Override
	public String toString() {
		return "Memo [ content=" + content + ",date=" + date +"]";
	}

	public Memo( String content,String date) {
		super();
		this.content= content;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Object getMemo() {
		return null;
	}

}
