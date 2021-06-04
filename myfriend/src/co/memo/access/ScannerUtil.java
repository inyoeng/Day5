package co.memo.access;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import co.memo.model.Memo;


public class ScannerUtil {
	static Scanner sc= new Scanner(System.in);
	//스캔해서 넣은거 while try해서 
	public static int readInt() {
		 String s = null;
	      int i = 0; 
	      
	      while(true) {
	         try {
	            System.out.println("Enter Number: ");
	            s = sc.next();
	            i = Integer.valueOf(s);
	            System.out.println( i );
	            break;
	         } 
	            catch(Exception e){
	               System.out.println("정수 값을 입력하세요.");
	               }
	         }
	      return i;

	} //숫자 넣어라. 
	public static String readStr() {
	     String s = null;
	      int i = 0;
	      
	      while(true) {
	         try {
	            System.out.println("Enter String: ");
	            s = sc.next();
	            i = Integer.valueOf(s);
	            System.out.println("문자 값을 입력하세요.");
	            } catch(Exception e){
	               System.out.println( s );
	               break;
	               }
	      }
	      return s;

	} // 문자 넣어라.
	public static String readDate() {
		
		String date1 = null;
		while(true) {
	         try {
	            System.out.println("날짜를 입력하세요(dd-MM-yyyy) >> ");
	            String date = sc.nextLine();
	            Date date11 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
	            System.out.println( date11 );
	            break;
	            } catch(Exception e){
	               System.out.println("날짜를 입력하세요.");
	               }
	      }
		return date1;

	}// 날짜 넣으라고 하고. 날짜가 아니면
	
	
	public static Memo readMemo() {//Friend 객체 받아와서 한 줄로 넣으면 따로
		System.out.println("내용, 날짜 입력");
		String result = sc.next();
		String [] arr = result.split(",");
		Memo memo = new Memo(arr[0],arr[1]);
		
		return memo;
	}
	
	 public static void main(String[] args) {
	      System.out.println();
	      readInt();
	      readStr();
	      readDate();
	   }

	}
	


