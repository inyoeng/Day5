package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {

	// 계속 필요한거 field로 선언하기
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 1. 조회 2.입력 3. 수정 4. 삭제 5. 전체리스트 (각각기능 분리) => 메소드로 기능 분리

	// 전체 리스트
	public static ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<>(); // null값 담긴 객체 생성

		connect(); // 연결객체 사용, 객체 연결 꼭!! 해줘야 함.

		String sql = "select * from Person";
		try {
			// 요 두 개는 공식이라고 생각하자!
			psmt = conn.prepareStatement(sql); // PreparedStatment 쿼리 실행. 결과 받아 옴.
			rs = psmt.executeQuery(); // 쿼리 실행결과 가져오는 부분.
			while (rs.next()) {
				// System.out.println(rs.getInt("id")+","+rs.getString("name"));
				Person person = new Person(); // db에서 가져온 컬럼을 person필드에 담으려고 함.
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;

	}

	// 단건 조회
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from Person where id = ?"; //
		Person p = null; // 변수 p에다가 뉴 인스턴스 만들어주고 하나하나 넣어줌. (null값이니까.) 일단 선언 해주고 데이터 값 있으면 그때 인스턴스 생성.

		try {
			psmt = conn.prepareStatement(sql); // preparedStatememt 객체 생성 , 리소스를 가져오는 것은 예외처리 해주어야 함.
			psmt.setInt(1, id); // 첫번째 ?가 id
			rs = psmt.executeQuery(); // select할 때만
			if (rs.next()) {
				p = new Person(); // 인스턴스를 생성하고 변수 p에 대입.
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return p;
	}

	// 입력!!!

	public static void insertPerson(int id, String name, int age, String phone) {
		connect();
		String sql = "insert into Person values (?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, phone);
			int r = psmt.executeUpdate(); // insert, update, delete일 때 사용
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// update
	public static void update(Person p) {

		connect();
		String sql = "update Person set name =?, age =?, phone=? where id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(4, p.getId());
			psmt.setString(1, p.getName());
			psmt.setInt(2, p.getAge());
			psmt.setString(3, p.getPhone());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// delete id기준
	public static void delete(int id) {
		connect();
		String sql = "delete from Person where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
			System.out.println("삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 이름으로 사람 찾기
	public static ArrayList<Person> searchByName(String name) {
		connect();
		ArrayList<Person> personlist = new ArrayList<>();
		String sql = "select * from Person where name = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery(); // select할 때만

			while (rs.next()) {
				Person person = new Person();
				// 인스턴스를 생성하고 변수 p에 대입.
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personlist.add(person);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return personlist;
	}

	// 연결메소드->연결 객체 이용
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close() { // connect한 후에는 꼭 close 해 줘야 함.
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("1. 전체 리스트 조회 2. 입력 3. 수정 4. 삭제 5. 한건조회 6. 이름 조회 9. 종료");

			int menu = sc.nextInt();

			if (menu == 1) {
				// 전체 초회
				System.out.println("조회결과");
				ArrayList<Person> list = getPersonList(); // list에 결과 받아 옴
				for (Person person : list) {
					System.out.println(person);
				}

			} else if (menu == 2) {

				// 입력기능

				System.out.println("id를 입력하세용 >> ");
				int searchid = sc.nextInt();
				sc.nextLine();
				System.out.println("이름을 입력하세용>> ");
				String name = sc.nextLine();
				sc.nextLine();
				System.out.println("나이를 입력하세용>> ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("전화번호 입력하세용 >> ");
				String phone = sc.next();

				insertPerson(searchid, name, age, phone);

			} else if (menu == 3) {
				System.out.println("변경할 값의 아이디를 입력하세요>> ");
				int id = sc.nextInt();
				sc.nextLine();

				Person p = getPerson(id);

				if (p == null) {
					System.out.println("존재하지 않는 아이디입니다.");
					continue;
				}

				System.out.println("변경할 이름을 입력하세용!! >>");
				String cname = sc.nextLine(); // line으로 받으면 비어있는 값 받음.
				System.out.println("변경할 나이을 입력하세용!! >>");
				String cage = sc.nextLine();
				System.out.println("변경할 전화번호를 입력하세용!! >>");
				String cphone = sc.nextLine();

				if (!cname.equals("")) {// 값이 없다면 변경 안함
					p.setName(cname);
				}
				if (!cage.equals("")) {
					p.setAge(Integer.parseInt(cage));
				}
				if (!cphone.equals("")) {
					p.setPhone(cphone);
				}

				update(p);

			} else if (menu == 4) {
				System.out.println("삭제 할 아이디를 입력하세요 >>");
				int id = sc.nextInt();
				delete(id);

			} else if (menu == 5) {
				// 한건 조회

				System.out.println("조회할 아이디를 입력하세요. >>");
				int searchId = sc.nextInt();
				Person p = getPerson(searchId);
				if (p == null) {
					System.out.println("조회된 값이 없습니다. ㅠ^ㅠ ");
				} else {

					System.out.println(p);
				}

			} else if (menu == 6) {
				// 이름조회
				System.out.println("조회할 이름을 입력하새욤!>> ");
				String searchName = sc.next();
				ArrayList<Person> list = searchByName(searchName); // list에 결과 받아 옴
				for (Person person : list) {
					System.out.println(person);
				}
//				if(list == null) {
//					System.out.println("조회된 값이 없습니다. ㅠ^ㅠ ");
//				}else {
//					
//					System.out.println(p);
//				}

			}

			else if (menu == 9) {
				break;
			}
		} // end of while

		sc.close();
		System.out.println("정상적인 종료.");

	} // end of main
} // end of class
