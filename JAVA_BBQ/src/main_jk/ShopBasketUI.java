package main_jk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ShopBasketUI implements ActionListener{
	//Field
	
	JFrame f;
	JPanel title_panel, center_panel, bottom_panel, menu_panel;
	JLabel shop_basket, branch_name, ttl_order, order_price;
	JButton btn_back, btn_all_delete, btn_add_order, btn_order, btn_mdelete, btn_madd, btn_minus;
	ImageIcon icon1;
	OrderUI order;
	
	//Constructor
	public ShopBasketUI() {
		init();
	}
	public ShopBasketUI(OrderUI order) {
		this.order = order;
		init();
	}
	
	//Method
		public void init() {
			f = new JFrame("BBQ");
			title_panel = new JPanel(new GridLayout(1,3));
			title_panel.setBackground(new Color(255, 255, 255));
			center_panel = new JPanel(new GridLayout(10,2));
			center_panel.setBackground(new Color(255, 255, 255));
			bottom_panel = new JPanel(new GridLayout(2,1));
			bottom_panel.setBackground(new Color(255, 255, 255));
			f.setBounds(100, 90, 600, 750);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//title_panel
			btn_all_delete = new JButton("전체삭제");
			btn_back = new JButton("<");
			JLabel shop_basket = new JLabel("            "
					+ "          장바구니");
			title_panel.add(btn_back);
			title_panel.add(shop_basket);
			title_panel.add(btn_all_delete);
			
		//center_panel
			menulist();
			btn_add_order = new JButton("추가주문");
			center_panel.add(btn_add_order);
			
		//bottom_panel
			JLabel order_price_label = new JLabel("총주문금액: price +원");
			btn_order = new JButton("Price + 주문하기");
			bottom_panel.add(order_price_label);
			bottom_panel.add(btn_order);

			f.add(BorderLayout.NORTH, title_panel);
			f.add(BorderLayout.CENTER, center_panel);
			f.add(BorderLayout.SOUTH, bottom_panel);


			Dimension fsize = f.getSize();
			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
			int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

			JScrollPane content = new JScrollPane(center_panel); 
			f.add(content);
			
			f.setLocation(width, height);
			f.setVisible(true);
			
			
			// 윈도우 이벤트 호출-종료
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("프로그램을 종료합니다."));
					System.exit(0);
				}
			});
			btn_back.addActionListener(this);
			btn_all_delete.addActionListener(this);
			btn_add_order.addActionListener(this);
			btn_order.addActionListener(this);
			
		}//init
	/** 메뉴 생성 **/
		public void menulist() {
			JPanel pc = new JPanel();
			
			f.add(pc,BorderLayout.CENTER);
			
			menu_panel = new JPanel(new GridLayout(1,8)) {
				@Override
				public Dimension getPreferredSize() {
					return new Dimension(50,100);
				}
			};
			menu_panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			pc.add(menu_panel);
			f.setVisible(true);

			JLabel menu_label = new JLabel("select menu");
			JLabel option_label = new JLabel("option");
			JLabel price_label = new JLabel("price");
			
			JPanel right_panel =new JPanel();
			JPanel left_panel =new JPanel(new GridLayout(3,1));
			btn_mdelete = new JButton("x");
			right_panel.setLayout(null);
			btn_mdelete.setBounds(245, 0, 40, 28);
			btn_madd = new JButton("+");
			btn_minus = new JButton("-");
			JTextField tf_madd = new JTextField(8);
			
			JPanel count_panel = new JPanel();
			count_panel.add(btn_minus);
			count_panel.add(tf_madd);
			count_panel.add(btn_madd);
			count_panel.setBounds(0,50, 300, 60);
			right_panel.add(btn_mdelete);
			right_panel.add(count_panel);
			left_panel.add(menu_label);
			left_panel.add(option_label);
			left_panel.add(price_label);
			
			menu_panel.add(BorderLayout.WEST, left_panel);
			menu_panel.add(BorderLayout.EAST, right_panel);
		
			center_panel.add(menu_panel);
			
			btn_mdelete.addActionListener(this);
			btn_madd.addActionListener(this);
			btn_minus.addActionListener(this);
		}
		
	/**액션 이벤트**/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn_mdelete) {
			System.out.println("삭제");
			menu_panel.setVisible(false);
			center_panel.remove(menu_panel);
			
		}else if(obj == btn_madd) {
			System.out.println("추가");
			
		}else if(obj == btn_minus) {
			System.out.println("빼기");
			
		}else if(obj == btn_back) {
			System.out.println("뒤로");
			
		}else if(obj == btn_all_delete) {
			System.out.println("전체삭제");
			
		}else if(obj == btn_add_order) {
			System.out.println("추가주문");
			
		}else if(obj == btn_order) {
			System.out.println("주문");
			
			
		}
	}

}//class
