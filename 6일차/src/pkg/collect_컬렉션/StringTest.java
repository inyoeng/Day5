package pkg.collect_컬렉션;

public class StringTest {

	public static void main(String[] args) {

		String str ="Hello Everyone!";
		char c= str.charAt(4);
		System.out.println("인덱스 위치의 한 글자: "+c);
		System.out.println(str.substring(6,11));
		System.out.println(str.contains("one"));
		System.out.println(str.endsWith("!"));
		System.out.println(str.startsWith("H"));
		
		
		String num = "201030-1231234";
		String[]arr = num.split("-");
		System.out.println(arr[0]);
		System.out.println(arr[1].substring(0, 1));
		
		
		String path = "c:/temp/image/a.jpeg";
		int pos = path.indexOf("/"); //그 글자가 어디있는지 번호 알려줌
		int pos2 = path.lastIndexOf("/"); //마지막 "/"의 번호
		int pos3 = path.lastIndexOf("/",pos2+1); //pos2+1이후부터 찾아봄
		System.out.println(pos+" : " +pos2);
		
		//확장자 찾기(마지막 "."위치부더 +1하고 마지막까지 가면 됨.
		//lastIndexod substring
		System.out.println("확장자: "+path.substring(path.lastIndexOf(".")+1));
		System.out.println("파일명: "+ StringUtil.getFilename(path));
		
		System.out.println("확장자: "+ StringUtil.getExtention(path));
		System.out.println("경로: "+ StringUtil.getPath(path));
		
		//인코딩
		String b = "문자열 문자";
		String d = new String(b.getBytes(),"euc-kr");
		
		b.replace("열", "값");
		System.out.println(b); //replace는 비파괴라서 담고 프린트 해야 함. 
	}
	

}
