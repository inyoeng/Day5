package exam4;

public class Exam4 {
	public static void main(String[] args) {
		
	
	String[] arr = {"101002-2","991012-1","960304-1","881012-2","010103-1"};
	
	int male = 0;
	int fe = 0;
	
	for (int i = 0; i <arr.length ; i++) {
		String sex =arr[i].substring(7,8); 
		int a = Integer.parseInt(sex);
		if( a ==1 ) {
			male +=1;
		}else {
			fe+=1;
		}
	}
	
	System.out.println("남"+male+" 여"+fe);
	
	int teen =0;
	int tw =0;
	int th = 0;
	int fo = 0;
	
	for (int i = 0; i <arr.length ; i++) {
		String age =arr[i].substring(0,2); 
		int a = Integer.parseInt(age);
		if( a <11 ) {
			int b = 21-a;
			if(b<20) {
				teen +=1;
			} else if(b <30) {
				tw +=1;
			}else if(b<40) {
				th +=1;
			}else {
				fo +=1;
			}
		}else {
			int b = 2021-(a+1900);
			if(b<20) {
				teen +=1;
			} else if(b <30) {
				tw +=1;
			}else if(b<40) {
				th +=1;
			}else {
				fo +=1;
			}
		}
		
	}
	System.out.println("10대 "+teen +"명");
	System.out.println("20대 "+tw+"명");
	System.out.println("30대 "+th+"명");
	System.out.println("40대 "+fo+"명");
	
	
	}
	
}