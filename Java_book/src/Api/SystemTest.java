package Api;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;




public class SystemTest {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		System.out.println(System.currentTimeMillis());
		//업로드한 파일 이름 바꿀 때 사용
		//시간을 초기화할 떼 사용 할 수도 있다. 실핼시간체크
		
		Map<String, String> map = System.getenv();
		System.out.println(map.get("Java.Home"));
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+":"+map.get(key));
		}
		
		Field[] fields = Book.class.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName()+":"+f.getType());
		}
		
		URI uri = Book.class.getResource("/resources/menu.txt").toURI();  //상대경로
		Scanner sc = new Scanner( new File(uri));
		System.out.println(sc.next());
		
	}

}
