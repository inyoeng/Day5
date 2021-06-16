package GuiTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.pilates.model.Pilates;

public class RegisterFrame extends JFrame {

private JPanel rPanel;
private JLabel rLabel;
private JLabel rId, rPassword, rName, rPhone, rAge, rSessions;
private JTextField tId, tPassword, tName, tPhone, tAge, tSessions;
private JRadioButton rMan, rWoman;
private JButton rButton;

public RegisterFrame() {

    super("회원등록");
    super.setResizable(true);
    setSize(350, 400);
    setLocationRelativeTo(null);

    rPanel = new JPanel();
    rPanel.setLayout(new BorderLayout());
    setContentPane(rPanel);

    rLabel = new JLabel("회원등록");
    rLabel.setFont(new Font("돋움", Font.BOLD, 40));
    rLabel.setHorizontalAlignment(SwingConstants.CENTER);
    rPanel.add(rLabel, BorderLayout.NORTH);

    JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));

    rId = new JLabel("아이디");
    rId.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(rId);

    tId = new JTextField();
    main.add(tId);

    rPassword = new JLabel("비밀번호");
    rPassword.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(rPassword);

    tPassword = new JTextField();
    main.add(tPassword);

    rName = new JLabel("성명");
    rName.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(rName);

    tName = new JTextField();
    main.add(tName);

    rPhone = new JLabel("전화번호");
    rPhone.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(rPhone);

    tPhone = new JTextField();
    main.add(tPhone);

    rAge = new JLabel("나이");
    rAge.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(rAge);

    tAge = new JTextField();
    main.add(tAge);
    
    rSessions = new JLabel("수강권");
    rSessions.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(rSessions);

    tSessions = new JTextField();
    main.add(tSessions);


    ButtonGroup bg = new ButtonGroup();

    rMan = new JRadioButton("남자");
    rMan.setHorizontalAlignment(SwingConstants.CENTER);
    bg.add(rMan);

    main.add(rMan);
    rWoman = new JRadioButton("여자");
    rWoman.setHorizontalAlignment(SwingConstants.CENTER);
    bg.add(rWoman);
    main.add(rWoman); 

    rPanel.add(main, BorderLayout.CENTER);

    JPanel sMain = new JPanel();
    rPanel.add(sMain, BorderLayout.EAST);

    rButton = new JButton("등록하기");
    rButton.setFont(new Font("Serif", Font.BOLD, 20));
    rPanel.add(rButton, BorderLayout.SOUTH);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    rButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ManagementDTO mdto = new ManagementDTO();
            String Age = String.valueOf(tAge.getText());
            String sessions = String.valueOf(tSessions.getText());
            mdto.setId(tId.getText());
            mdto.setPassword(tPassword.getText());
            mdto.setName(tName.getText());
            mdto.setPhone(tPhone.getText());
            mdto.setAge(Age);
            mdto.setSessions(sessions);
            if(rMan.isSelected())  
                mdto.setGender(rMan.getText());
            else  
                mdto.setGender(rWoman.getText());


            ManagementDAO mdao = ManagementDAO.getInstance();
            int result = mdao.insertMember(mdto);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "회원등록 완료");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "회원동록 실패");
                dispose();
            }
        }
    });

}

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                RegisterFrame rf = new RegisterFrame();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

   }
}