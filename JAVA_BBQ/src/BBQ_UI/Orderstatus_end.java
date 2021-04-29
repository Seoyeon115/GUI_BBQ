package BBQ_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Orderstatus_end implements ActionListener {
	InnerMain main;
	
//	JFrame frame;
	JPanel panel;
	JButton btn_home,btn_cart;
	
	public Orderstatus_end() {
		init();
		
	}
	public Orderstatus_end(InnerMain main) {
		this.main = main;
		init();
	}
	
	public JPanel init() {
		
//		frame = new JFrame();
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(new Color(204, 0, 51));
//		frame.getContentPane().setForeground(new Color(255, 255, 255));
//		frame.setBounds(100, 90, 600, 910);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
				
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(30, 22, 520, 820);
		
//		frame.add(panel);
		
		//north_panel
		ImageIcon icon1 = new ImageIcon("images/normal.png");
		
		JPanel menu1 = new JPanel(new BorderLayout());
		menu1.setBounds(0, 0, 520, 273);
		menu1.setBackground(new Color(255, 255, 255));
		
		JPanel north_panel = new JPanel(new BorderLayout());
		north_panel.setPreferredSize(new Dimension(510,45));
		north_panel.setBackground(new Color(255,255,255));
		
		//홈버튼 장바구니버튼 넣기
		ImageIcon home = new ImageIcon("images/homer.png");
		ImageIcon home2 = new ImageIcon("images/homey.png");
		
		btn_home = new JButton();
		btn_home.setIcon(home);
		btn_home.setPressedIcon(home2);
		btn_home.setForeground(new Color(255, 255, 255));
		btn_home.setBackground(new Color(255, 255, 255));
		btn_home.setPreferredSize(new Dimension(40,40));;
		btn_home.setContentAreaFilled(false);
		
		//이미지만 넣기
		btn_home.setBorderPainted(false); 
		btn_home.setFocusPainted(false); 
		btn_home.setContentAreaFilled(false);
		btn_home.addActionListener(this);
		
		north_panel.add(BorderLayout.WEST,btn_home);
		menu1.add(BorderLayout.NORTH,north_panel);
		
		//hull panel
		JPanel hull_panel = new JPanel(new BorderLayout());
		hull_panel.setBackground(new Color(255,255,255));
		
		JPanel noexist_p = new JPanel(new BorderLayout());
		noexist_p.setBackground(new Color(255,255,255));
		JPanel noexist_sort = new JPanel(new FlowLayout());
		noexist_sort.setBackground(new Color(255,255,255));
		
		JLabel noexist = new JLabel("맛있게 드세요~");
		noexist.setFont(Commons.getFont(1,55));
		noexist.setForeground(new Color(163,45,97));
		
		JLabel blank = new JLabel();
		blank.setBackground(new Color(255,255,255));
		blank.setPreferredSize(new Dimension(50,30));
		noexist_sort.add(noexist);
		
		noexist_p.add(BorderLayout.SOUTH,blank);
		noexist_p.add(BorderLayout.CENTER,noexist_sort);
		
		JPanel hull_pn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		hull_pn.setBackground(new Color(255,255,255));
		JLabel hull = new JLabel("잘 도착했나요 ?");
		hull.setFont(Commons.getFont(1,45));;
		
		hull_pn.add(hull);
		
		JPanel northsize = new JPanel();
		northsize.setPreferredSize(new Dimension(50,120));
		northsize.setBackground(new Color(255,255,255));
		
		hull_panel.add(BorderLayout.NORTH,northsize);
		hull_panel.add(BorderLayout.CENTER,hull_pn);
		hull_panel.add(BorderLayout.SOUTH,noexist_p);
		
		
		ImageIcon thx = new ImageIcon("images/thank.jpg");
		JLabel tnx_lb = new JLabel(thx);
		
		menu1.add(BorderLayout.CENTER,hull_panel);
		menu1.add(BorderLayout.SOUTH,tnx_lb);
			
		panel.add(menu1);
//		frame.setVisible(true);
		
		return panel;
		
	}
public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btn_home){
			panel.setVisible(false);
//			main.panelinit();
			main.switchPanel(InnerMain.MAIN);
		}
		
	}
	
	
	
}