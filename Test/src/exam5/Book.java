package exam5;

public class Book {
	//테이블의 구조와 동일하게 해야..
	String isbn;
	String name;
	String content;
	
	public Book() {}
	
	public Book(String isbn, String name, String content) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", content=" + content + "]";
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
