package GuiTest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FrameTest {

	private static JPanel lPanel;
	private static JLabel lLogin;
	private JLabel lId;
	private JLabel lPassword;
	
	
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setTitle(" 예담 필라태스 ");
		f.setBounds(300, 300, 600, 600);
		f.setVisible(true);

		Panel p = new Panel(); // 객체생성 및 초기화
		

		lPanel = new JPanel();
		lPanel.setLayout(new BorderLayout());
		setContentPane(lPanel);

		lLogin = new JLabel("로그인");
		lLogin.setFont(new Font("돋움", Font.BOLD, 50));
		lLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lLogin.setPreferredSize(new Dimension(120, 120));
		lPanel.add(lLogin, BorderLayout.NORTH);

		JPanel Main = new JPanel(new GridLayout(2, 2, 15, 15));


		TextField tf1 = new TextField("아이디 입력", 20); // 생성,초기화 및 텍스트가 나올상자의 사이즈 지정
		TextField tf2 = new TextField("비밀번호 입력", 20); // 생성,초기화 및 텍스트가 나올상자의 사이즈 지정

		tf1.selectAll(); // 아이디의 입력된 모든 문자열 선택가능
		tf2.selectAll(); // 비밀번호의 입력된 모든 문자열 선택가능

		tf2.setEchoChar('*'); // 비밀번호의 입력을 *모양으로 표시되도록 설정

		p.add(tf1); // 아이디 입력창을 패널에 추가
		p.add(tf2); // 비밀번호 입력창을 패널에 추가

		f.add(p); // 패널을 프레임에 추가

		f.setSize(300, 300); // 패널의 가로 세로 크기를 설정
		f.setVisible(true); // 나타내기

		// new LoginFrame();
		
		
		
		Button btn1;
		
	        // 가위 버튼 생성
	        btn1 = new Button("로그인");
	       
	        // 패널에 3가지 버튼 생성
	        p.add(btn1); 
	        add(p);
	        // 보 버튼은 사용 안함
	      
	        // 윈도우창 크기는 200 x 200
	        setSize(200, 200);
	        // 윈도우창 
	        setVisible(true);
	    
	}

	private static void setContentPane(JPanel lPanel2) {
		// TODO Auto-generated method stub
		
	}

	private static void setSize(int i, int j) {
		
	}	

	private static void setVisible(boolean b) {
		
	}

	private static void add(Panel p2) {
		
	}

}
