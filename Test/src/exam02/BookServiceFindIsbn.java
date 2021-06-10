package exam02;

import java.util.Scanner;

public class BookServiceFindIsbn implements BookService {

	Scanner sc = new Scanner(System.in);

	@Override
	public void execute(BookList books) {
		// isbn을 입력받고 

		while (true) {
			System.out.println("Enter Isbn > ");
			String isbn = sc.next();
			// list에서 검색하고
			if (books.equals(isbn)) {
				Book book = books.findIsbn(isbn);
				// 결과 출력
				System.out.println(book);
				break;
			} else {
				System.out.println("없는 번호입니다. 디시 입력하세요!");
			}
		}
	}

}
