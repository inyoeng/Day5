package 배열_1교시_6월1일;

public class Score {
	//성적 저장용 클래스 
	
	//필드
	String name;
	int kor;
	int mat;
	int eng;
	int total;
	double avg;

	
	//생성자 만들기 source에 to string 
	public Score(String name, int kor, int mat, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
		
		this.total = kor+ mat+ eng;
		this.avg = (double) this.total /3;
	}
	
	
	
	
}
