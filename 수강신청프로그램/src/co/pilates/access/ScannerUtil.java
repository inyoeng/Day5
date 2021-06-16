package co.pilates.access;

import java.util.Scanner;

import co.pilates.model.Course;
import co.pilates.model.Pilates;
import co.pilates.model.Teacher;

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
			sc.close();
			return s;

		}
//
//		public static Board readBoard() {// Friend 객체 받아와서 한 줄로 넣으면 따로
//			while (true) {
//				System.out.println("글번호, 제목, 내용, 저자 > ");
//				String result = sc.next();
//				String[] arr = result.split(",");
//
//				Board b = new Board();
//				// or Friend friend = new Friend(arr[0], arr[1], arr[2]); or (arr)
//				int b_id = Integer.parseInt(arr[0]);
//				b.setB_id(b_id);
//				b.setB_title(arr[1]);
//				b.setB_content(arr[2]);
//				b.setB_writer(arr[3]);
//				return b;
//			}
//		}

		public static Pilates readPila() {
			while(true) {
				System.out.println("== 회원등록을 시작합니다. ==");
				System.out.println("아이디, 비밀번호, 이름, 나이, 번호, 수강권 입력>>");
				String result = sc.next();
				String [] arr = result.split(",");
				
				Pilates p = new Pilates();
				int age = Integer.parseInt(arr[3]);
				int session = Integer.parseInt(arr[5]);
				p.setId(arr[0]);
				p.setPw(arr[1]);
				p.setName(arr[2]);
				p.setAge(age);
				p.setPhone(arr[4]);
				p.setSession(session);
				
				return p;
			}
		}
		
		public static Course readCourse() {
			while(true) {
				System.out.println("== 과정 등록을 시작합니다. ==");
				System.out.println("코스명, 레벨, 날짜, 강사명 입력 >> ");
				String result = sc.next();
				String [] arr = result.split(",");
				
				Course c = new Course();
				c.setCourse(arr[0]);
				c.setLevel(arr[1]);
				c.setDate(arr[2]);
				c.setTeacher(arr[3]);
				
				return c;
			}
		}
		
		public static Teacher readTeacher() {
			while(true) {
				System.out.println("== 강사 등록을 시작합니다. ==");
				System.out.println("이름, 나이, 경력, 분야, 전화번호 입력>> ");
				
				String result = sc.next();
				String [] arr = result.split(",");
				
				Teacher t = new Teacher();
				int age = Integer.parseInt(arr[1]);
				t.setName(arr[0]);
				t.setAge(age);
				t.setExperience(arr[2]);
				t.setSpeciality(arr[3]);
				t.setPhone(arr[4]);
				
				
				return t;
			}
			
		}
}
