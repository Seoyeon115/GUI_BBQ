package BBQ_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import BBQ_SYSTEM.BBQ_System;
import BBQ_VO.CartVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;

public class ShopBasketUI implements ActionListener{
	  // Field
	   JButton btn_check,btn_back,btn_alldel,btn_order,btn_pay,btn_all_delete, 
	   			btn_madd, btn_minus;
	   ArrayList<JButton> btns_del;
	   JPanel panel_content,top_panel,center_panel,menu_panel,bottom_panel;
	   public JLabel total_label,price_label, menu_label, option_label, m_price_label;
	   JTextField tf_madd;
	   OrderUI order;
	   LoginUI login;
	   InnerMain main;
	   BBQ_System system;
	   ArrayList<CartVO> cart;
	  
	   int m_price;
	   int o_price;
	   int ttl_price;
	   int each_m_price;
	   
	   // Constructor
	   public ShopBasketUI() {
	      init();
	   }
	   public ShopBasketUI(OrderUI order) {
	      this.order = order;
	      init();
	   }
	   public ShopBasketUI(InnerMain main) {
		   this.main = main;
		   this.system = main.system;
	   }
	   
	   // Method
	   public JPanel init() {
	      panel_content = new JPanel(new BorderLayout());
	      panel_content.setBackground(new Color(255, 255, 255));
//	      panel_content.setBackground(Color.pink);
	      panel_content.setBounds(30, 22, 520, 650);
	      
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
	      
	      total_label = new JLabel("총주문금액: "+ ttl_price +"원");
	      btn_pay = new JButton("   결제    ");
	      bottom_panel.add(total_label);
	      bottom_panel.add(btn_pay);
	      
	      //setting
	      
	      panel_content.add(BorderLayout.NORTH, top_panel);
	      panel_content.add(BorderLayout.CENTER, center_panel);
	      panel_content.add(BorderLayout.SOUTH, bottom_panel);
	      
	      JScrollPane content = new JScrollPane(center_panel); 
	      panel_content.add(content);
	      
	      btn_back.addActionListener(this);
	      btn_all_delete.addActionListener(this);
	      btn_order.addActionListener(this);
	      btn_pay.addActionListener(this);

	      return panel_content;
	   }//init

	   
	   /** 메뉴 생성 GUI **/
	   public void menulist() {
		   cart = system.getCart();
		   btns_del = new ArrayList<JButton>();
		   for(int i=0; i< cart.size();i++) {
				
				menu_panel = new JPanel(new GridLayout(1,8)) {
					@Override
					public Dimension getPreferredSize() {
						return new Dimension(50,100);
					}
				};
				menu_panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			  
				MenuVO menu = cart.get(i).getMenu();
				ArrayList<OptionVO> options = cart.get(i).getOptions();
				
			  menu_label = new JLabel();
			  menu_label.setText("메뉴: " + menu.getName() + cart.get(i).getPrice());;
			  
			  String optionInfo = "";
			  for(OptionVO op : options) {
				  if(optionInfo.equals("")) {
					  optionInfo = op.getName() +"("+ op.getPrice() +")";
				  }else {
					  optionInfo += " / "+ op.getName() +"("+ op.getPrice() +")";
				  }
				  
			  }
			  option_label = new JLabel();
			  option_label.setText("옵션: " +optionInfo);
			  m_price_label = new JLabel();
			  m_price =((cart.get(i).getPrice() * cart.get(i).getAmt()));
			  
			  //ttl_price 계산
			  each_m_price =(m_price +o_price);
			  m_price_label.setText("가격: "+ each_m_price);
			  ttl_price += each_m_price;
			  
			  JPanel left_panel =new JPanel(new GridLayout(3,1));
			  left_panel.add(menu_label);
			  left_panel.add(option_label);
			  left_panel.add(m_price_label);
			  menu_panel.add(BorderLayout.WEST, left_panel);
			  
		      JPanel right_panel =new JPanel();
		      JButton btn_mdelete = new JButton("x");
		      btn_mdelete.setFont(Commons.getFont(10));
		      right_panel.setLayout(null);
		      btn_mdelete.setBounds(200, 0, 40, 38);
		      btn_madd = new JButton("+");
		      btn_minus = new JButton("-");
		      tf_madd = new JTextField(8);
		      tf_madd.setText(Integer.toString(cart.get(i).getAmt()));
		      JPanel count_panel = new JPanel();
		      count_panel.add(btn_minus);
		      count_panel.add(tf_madd);
		      count_panel.add(btn_madd);
		      count_panel.setBounds(0,50, 300, 60);
		      right_panel.add(btn_mdelete);
		      right_panel.add(count_panel);
		      
		      menu_panel.add(BorderLayout.EAST, right_panel);
		      center_panel.add(menu_panel);    
		      
		      btns_del.add(btn_mdelete);
		      
		      btn_mdelete.addActionListener(this);
		      tf_madd.addActionListener(this);
		      btn_madd.addActionListener(this);
		      btn_minus.addActionListener(this);
		  }

	   }//menulist_btn
	   
	   

	   void deleteMenu(Object obj) {
		   for(int i=0;i<btns_del.size();i++) {
			   if(btns_del.get(i) == obj) {
				   system.deleteCartMenu(i);
				   i = btns_del.size();
			   }
		   }
	   }
	   
	   public void actionPerformed(ActionEvent e) {
		   Object obj = e.getSource();
		      
		      if(obj ==btn_back) {
		    	  panel_content.setVisible(false);
		    	  main.switchPanel(InnerMain.MAIN);
		    	  
		      }else if(obj == btn_all_delete) {
		    	  system.deleteCartAll();
		    	  panel_content.setVisible(false);
		    	  main.switchPanel(InnerMain.CART);
			     
		         System.out.println("전체삭제");
		    	
		      }else if(obj == btn_order) {
		         System.out.println("추가 주문");
		         panel_content.setVisible(false);
		         main.switchPanel(InnerMain.MENULIST);
		         
		      }else if(obj == btn_pay) {
		    	  panel_content.setVisible(false);
		    	  main.switchPanel(InnerMain.PAY);
		    	  
		      }else if(btns_del.contains(obj)) {
		    	  deleteMenu(obj);
		    	  panel_content.setVisible(false);
		    	  main.switchPanel(InnerMain.CART);
//		         System.out.println("삭제");
		         
		    	
//		      }else if(obj == shop.tf_madd) {
//			         System.out.println("수량 추가");
//			         
//		      }else if(obj == shop.btn_madd) {
//		         System.out.println("추가");
//		         
//		      }else if(obj == shop.btn_minus) {
//		         System.out.println("빼기");
		         
		         
		      }
		  }//actionPerformed

	}//ShopBasketUI