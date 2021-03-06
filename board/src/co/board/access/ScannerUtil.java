package co.board.access;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.board.model.Board;

public class ScannerUtil {
	static Scanner sc = new Scanner(System.in);

	// 스캔해서 넣은거 while try해서
	public static int readInt(String prompt) {
		System.out.println(prompt + ">");
		return readInt(); // 프렄프트 출력 후 readInt로 가서 값 입력받음.
	}

	// 숫자 넣어라.
	public static int readInt() {
		String s = null;
		int i = 0;

		while (true) {
			try {
				System.out.println("Enter Number: ");
				s = sc.next();
				i = Integer.valueOf(s);
				System.out.println(i);

				// 아니면 그냥 result = sc.nextInt(); 받아도 된다.
				break;
			} catch (Exception e) {
				System.out.println("정수 값을 입력하세요.");
			}
		}
		return i;

	}

	// 문자 넣어라.
	public static String readStr() {
		String s = null;
		int i = 0;

		while (true) {
			try {
				System.out.println("Enter String: ");
				s = sc.next();
				i = Integer.valueOf(s);
				System.out.println("문자 값을 입력하세요.");
			} catch (Exception e) {
				System.out.println(s);
				break;
			}
		}
		return s;

	}

	public static Board readBoard() {// Friend 객체 받아와서 한 줄로 넣으면 따로
		while (true) {
			System.out.println("글번호, 제목, 내용, 저자 > ");
			String result = sc.next();
			String[] arr = result.split(",");

			Board b = new Board();
			// or Friend friend = new Friend(arr[0], arr[1], arr[2]); or (arr)
			int b_id = Integer.parseInt(arr[0]);
			b.setB_id(b_id);
			b.setB_title(arr[1]);
			b.setB_content(arr[2]);
			b.setB_writer(arr[3]);
			return b;
		}
	}

	public static Board readReply() {
		// List<Board> re = new ArrayList<>();
		
		System.out.println(" 내용, 저자 > ");
		String result = sc.next();
		String[] arr = result.split(",");

		Board b = new Board();
		// or Friend friend = new Friend(arr[0], arr[1], arr[2]); or (arr)
		
		b.setB_content(arr[0]);
		b.setB_writer(arr[1]);
	
		return b;
	}

}
