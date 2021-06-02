package pkg.collect_컬렉션;

public class StringUtil {

	//파일명 추출
	public static String getFilename(String path) {//클래스를 객체로 생성하지 않아도 되니까 static 씀.
		
		String s = null;
		
		if (path == null) return null; //null값 입력해도 ...오류 안나게!
		
		s = path.substring(path.lastIndexOf("/")+1);
		
		return s;
	}
	
	//확장자 jpg
	public static String getExtention(String path) {
			String s = null;
			
			if (path == null) return null; 
			
			s = path.substring(path.lastIndexOf(".")+1);
			
			return s;
	
	}
	
	//경로
	public static String getPath(String path) {
		String s = null;
		
		if (path == null) return null; 
		
		s = path.substring(0,path.lastIndexOf("/"));
		
		return s;
		
	}
}

