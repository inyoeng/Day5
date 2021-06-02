package pkg1;

public class DateUtil {
	/*
	 * 정적메서드 안에서는 정적필드만 접근할 수 있음!
	 * 
	 * 접근제어자 private   default   protected  public
	 *          클래스 안  같은 패키지  상속받은 패키지
	  */       
	public String date ="20210610";
	public static String curDate() {
		return "20210602";
	}
	
}
