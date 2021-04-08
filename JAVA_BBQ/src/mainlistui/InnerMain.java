package mainlistui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InnerMain implements ActionListener {
	
	//Field
	
	JFrame frame = new JFrame();
	JButton btn_mainlist;
	MenulistUI list1 = new MenulistUI(this);
	JPanel panel;
	
	//Constructor
	public InnerMain() {
		init();
	}
	
	//Method
	
	public void init() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(204, 0, 51));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 90, 600, 910);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		panelinit();
	}
	public void panelinit() {
		panel = new JPanel();
		btn_mainlist = new JButton("주문하기");
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(30, 22, 520, 820);
		panel.add(btn_mainlist);
		btn_mainlist.addActionListener(this);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_mainlist) {
			panel.setVisible(false);
			frame.add(list1.initialize());
		}
	}
}
