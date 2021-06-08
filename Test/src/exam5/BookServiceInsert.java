package exam5;

import java.util.Scanner;

public class BookServiceInsert implements BookService {
	
	BookServiceInsert(){}
	
	BookList b = new BookList();
	
	
	@Override
	public void execute(BookList list) {
		Book book = new Book();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("isbn");
		String isbn = sc.next();
		System.out.println("name");
		String name = sc.next();
		System.out.println("content");
		String content = sc.next();
		
		book.setIsbn(isbn);
		book.setName(name);
		book.setContent(content);
		
		
		list.insert(book);
	}
	

	
}
