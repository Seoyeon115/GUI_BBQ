package mainlistui;

import java.awt.Color;

import javax.swing.JFrame;

public class Orderstatus {
	JFrame frame = new JFrame();
	
	public Orderstatus() {
		
		init();
		
	}
	
	public void init() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(204, 0, 51));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 90, 600, 910);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
	}
	
	
	
	
}
