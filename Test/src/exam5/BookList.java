package exam5;

import java.util.ArrayList;
import java.util.List;

public class BookList extends BookAccess{
	
	ArrayList<Book> books = new ArrayList();

	BookList(){}


	
	@Override
	public ArrayList<Book> findName() {
		
			
		return books;
		
	}


	@Override
	public void insert(Book book) {
		
		books.add(book);
	}



	
	}

	


	


