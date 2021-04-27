package main_jk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import BBQ_DAO_jk.MemberDAO;
import BBQ_DAO_jk.OrderDAO;
import BBQ_VO.CartVO;
import BBQ_VO.OptionVO;
import main.Commons;
import main.OrderUI;

public class ShopBasketUI {
	  // Field
	   JFrame f;
	   JButton btn_check,btn_back,btn_alldel,btn_order,btn_pay,btn_all_delete,
	         btn_mdelete, btn_madd, btn_minus;
	   JPanel panel_content,top_panel,center_panel,menu_panel,bottom_panel;
	   public JLabel total_label,price_label, menu_label, option_label, m_price_label;
	   JTextField tf_madd;
	   int ttl_price;
	   OrderUI order;
	   InnerMain main;
	   OrderDAO orderlist = new OrderDAO();
	   MemberDAO mdao = new MemberDAO();
	   BBQ_System system;
	   ShopBasketUIEvent eventobj = new ShopBasketUIEvent(this);
	   LoginUI login = new LoginUI();
	   ArrayList<CartVO> cvo;
	   ArrayList<OptionVO> ovo;
	  
	   int m_price;
	   
	   // Constructor
	   public ShopBasketUI() {
	      init();
	   }
	   public ShopBasketUI(OrderUI order) {
	      this.order = order;
	      init();
	   }
	   
	   // Method
	   public void init() {
	      f = new JFrame("장바구니");
	      f.getContentPane().setBackground(new Color(204, 0, 51));
	      f.getContentPane().setForeground(new Color(255, 255, 255));
	      f.setBounds(100, 90, 600, 750);
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setLayout(null);
	
	      
	      panel_content = new JPanel(new BorderLayout());
	      panel_content.setBackground(new Color(255, 255, 255));
//	      panel_content.setBackground(Color.pink);
	      panel_content.setBounds(30, 22, 520, 650);
	      
	      f.add(panel_content);
	      f.setVisible(true);
	      
	      top_panel = new JPanel(new BorderLayout());
	      top_panel.setBackground(new Color(255, 255, 255));
	      center_panel = new JPanel(new GridLayout(6,1));
	      center_panel.setBackground(new Color(255, 255, 255));
//	      center_panel.setBackground(Color.green);
	      bottom_panel = new JPanel(new GridLayout(2,1));
	      bottom_panel.setBackground(new Color(255, 255, 255));
	      
	      
	      //top_panel
	      ImageIcon image_back = Commons.imageResize(new ImageIcon("images/homer.png"), 50, 40);
	      ImageIcon image_backPressed = Commons.imageResize(new ImageIcon("images/homey.png"), 50, 40);
			
	      btn_back = new JButton("", image_back);
	      btn_back.setPressedIcon(image_backPressed);
	      btn_back.setBorderPainted(false);
	      btn_back.setContentAreaFilled(false);
	      btn_back.setBounds(5, 0, 50, 40);
	      btn_back.setPreferredSize(new Dimension(50, 40));
	      
	      btn_all_delete = new JButton("전체삭제");
	      top_panel.add(BorderLayout.WEST, new JPanel(new GridLayout(1, 1)).add(btn_back));
	      top_panel.add(new JLabel("                                       "
	      		+ "        장바구니"));
	      top_panel.add(BorderLayout.EAST, new JPanel(new GridLayout(1, 1)).add(btn_all_delete));
	      
	      //center_panel
	      menulist();
	      JPanel order_panel = new JPanel(new GridLayout(2,1));
	      order_panel.setBackground(new Color(255, 255, 255));
	      btn_order = new JButton("추가 주문");
	      btn_order.setPreferredSize(new Dimension(50, 18));
	      order_panel.add(btn_order);
	      center_panel.add(order_panel);

//	      panel_content.add(btn_order);
	      
	      //bottom_panel
	      JLabel total_label = new JLabel("총주문금액: " + ttl_price + "원");
	      btn_pay = new JButton("   결제    ");
	      bottom_panel.add(total_label);
	      bottom_panel.add(btn_pay);
	      
	      //setting
	      
	      panel_content.add(BorderLayout.NORTH, top_panel);
	      panel_content.add(BorderLayout.CENTER, center_panel);
	      panel_content.add(BorderLayout.SOUTH, bottom_panel);
	      
	      JScrollPane content = new JScrollPane(center_panel); 
	      panel_content.add(content);
	      
	      f.setVisible(true);
	      
	      btn_back.addActionListener(eventobj);
	      btn_all_delete.addActionListener(eventobj);
	      btn_order.addActionListener(eventobj);
	      btn_pay.addActionListener(eventobj);
	      
	   }//init

	   
	   /** 메뉴 생성 GUI **/
	   public void menulist() {
		   cvo = orderlist.getShopBasketResult(login.id); 
		   ovo = orderlist.getShopBasketOption();
		   int i;
		   for(i=0; i< cvo.size();i++) {
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
			   
//	      menu_panel = new JPanel(new GridLayout(1,2));
//	      menu_panel.setBounds(0, 40, 400, 200);
			  menu_label = new JLabel();
			  menu_label.setText(cvo.get(i).getRno()+". 메뉴: " + cvo.get(i).getMenu() + cvo.get(i).getPrice());;
			  option_label = new JLabel();
			  option_label.setText("옵션: " +ovo.get(i).getOption() + ovo.get(i).getPrice());
			  m_price_label = new JLabel();
			  m_price =((cvo.get(i).getPrice() * cvo.get(i).getAmt())+ovo.get(i).getPrice());
			  m_price_label.setText("가격: "+ m_price);
			  ttl_price += m_price; 
			  
			  JPanel left_panel =new JPanel(new GridLayout(3,1));
			  left_panel.add(menu_label);
			  left_panel.add(option_label);
			  left_panel.add(m_price_label);
			  menu_panel.add(BorderLayout.WEST, left_panel);
			  
	      JPanel right_panel =new JPanel();
	      btn_mdelete = new JButton("x");
	      btn_mdelete.setFont(Commons.getFont(10));
	      right_panel.setLayout(null);
	      btn_mdelete.setBounds(200, 0, 40, 38);
//	      btn_madd = new JButton("+");
//	      btn_minus = new JButton("-");
//	      tf_madd = new JTextField(8);
//	      tf_madd.setText(Integer.toString(cvo.get(i).getAmt()));
//	      JPanel count_panel = new JPanel();
//	      count_panel.add(btn_minus);
//	      count_panel.add(tf_madd);
//	      count_panel.add(btn_madd);
//	      count_panel.setBounds(0,50, 300, 60);
	      right_panel.add(btn_mdelete);
//	      right_panel.add(count_panel);
	      
	      menu_panel.add(BorderLayout.EAST, right_panel);
//	      panel_content.add(menu_panel);     ///////
	      center_panel.add(menu_panel);    
//	      panel_content.add(center_panel);     
	      
	      btn_mdelete.addActionListener(eventobj);
//	      tf_madd.addActionListener(eventobj);
//	      btn_madd.addActionListener(eventobj);
//	      btn_minus.addActionListener(eventobj);
		  }

	   }//menulist_btn


	}//ShopBasketUI