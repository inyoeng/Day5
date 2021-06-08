package exam5;

import java.util.ArrayList;
import java.util.Scanner;

public class BookServiceFind implements BookService {

	BookServiceFind() {
	}

	public void execute(BookList list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름입력 >");
		String a = sc.next();
		ArrayList<Book> book = list.findName();
		for (Book bo : book) {
			if (bo.getName().contains(a)) {
				System.out.println(bo);
			}
		}
	}

}
