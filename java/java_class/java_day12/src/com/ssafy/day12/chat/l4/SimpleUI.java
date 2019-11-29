package com.ssafy.day12.chat.l4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleUI {
	public static void main(String[] args) {
		SimpleUI su = new SimpleUI();
		su.createUI();
	}
	
	JTextField text = null;
	JButton button = null;
	JTextArea ta = null;
	public void eventHandling() {
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {	// 눌린 키가 Enter 키라면 
					String data = text.getText();
					ta.append("\n"+data);
					text.setText("");
					ta.setCaretPosition(ta.getDocument().getLength());
				}
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// text의 내용을 읽어서 ==> ta에 추가 
				String data = text.getText();
				ta.append(data + "\n");
				text.setText("");
			}
		});
	}
	
	public void createUI() {
		JFrame frame = new JFrame("Moon 채팅");			// 전체 화면의 틀 --> Container
		button = new JButton("전송");
		// container에 component 추가
		frame.add(button, BorderLayout.SOUTH);

		// 메세지를 출력할 TextArea
		ta = new JTextArea("Hello");	// 스크롤 기능이 자체적으로 없다.
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);
		frame.add(sp, BorderLayout.CENTER);

		// 복잡한 화면 구성 ==> 추가적인 container 사용
		JPanel panel = new JPanel();
		JLabel label = new JLabel("무엇이든 얘기하세요.");
		text = new JTextField("메세지를 입력하세요.");
		/*panel.add(label);	// 기본 레이아웃: FlowLayout
		panel.add(text);*/
		// 원하는 형태로 alyoutmanager를 변경하려면 ..
		BorderLayout blayout = new BorderLayout();
		BorderLayout blayout2 = new BorderLayout();
		
		panel.setLayout(blayout);
		panel.add(label, BorderLayout.WEST);
		panel.add(text, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		
		// 참가자 목록
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("참가자 명단");
		JTextField text2 = new JTextField();
		text2.setEditable(false);
		panel2.setLayout(blayout2);
		panel2.add(label2, BorderLayout.NORTH);
		panel2.add(text2, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.EAST);
		
		
		// 기본으로는 닫아도 종료되지 않는다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 보이려면 크기를 지정해줘야한다.
		frame.setSize(500, 300);
		// 기본적으로 frame은 안보인다. 보이게 해줘야 한다.
		frame.setVisible(true);
		eventHandling();
		
	}
}














