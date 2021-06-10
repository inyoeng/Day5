package exam02;

import java.util.ArrayList;
import java.util.List;

public class BookList extends BookAccess  {
	
	ArrayList<Book> books = new ArrayList<Book>();

	@Override
	public void insert(Book friend) {
		books.add(friend);
	}

	@Override
	public List<Book> findName(String name) {
		List<Book> list = new ArrayList<Book>(); 
		for (Book b : books) {
			if(b.getName().contains(name)) {
				list.add(b); 
			}
		}
		return list; 
	}

	@Override
	public Book findIsbn(String isbn) {
		Book book = null ;
		for (Book b : books) {
			if(b.getIsbn().contains(isbn)) {
				book = b;
				break;
			}
		}
		return book;
	}

	@Override
	public Book findall() {
		
		return null;
	}

}
