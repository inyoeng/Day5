package co.yedam.app;

public class Add {

	public static void main(String[] args) {
		// run config 가서 argument탭 가서 값 입력 또는 cmd창 가서

		String data1 = null;
		String data2 = null;

		//다중 catch
		try {
			data1 = args[0];
			data2 = args[1];

			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			System.out.println(value1 / value2);  //0을 나눌 수 없다 .
		} catch (NumberFormatException e) {
			System.out.println("숫자 입력");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자 두 개 입력");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
