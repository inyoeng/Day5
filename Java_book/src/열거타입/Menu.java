package 열거타입;

public enum Menu {
	등록(1), 수정(2), 삭제(3),조회(4), 종료(0);
	
	//순서 지정위한 생성자만들기 
	int value;
	
	public int getValue() {
		return value;
	}
	
	Menu(int value){
		this.value = value;
	}
	
	
	public static void print() {
		Menu [] arr =Menu.values();//menu배열 받음
		for (Menu m :arr) {
			System.out.println(m.value+" "+m);
		}
		
	} //요걸로하면 Menu 순서나 종류 달라져도 바로 업데이트 가능.
	
	public static Menu getMenu(int v) {
		 Menu []arr = Menu.values();
		 for (Menu m :arr) {
				if(m.getValue()== v) {
					return m;
						}
	 }
		 return null;
	}
}
//아무 것도 지정 안하면 그냥 0부터 감.