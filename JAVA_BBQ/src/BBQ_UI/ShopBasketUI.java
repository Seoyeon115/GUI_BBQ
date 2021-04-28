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
	   JButton btn_check,btn_back,btn_alldel,btn_order,btn_pay,btn_all_delete;
	   ArrayList<JButton> btns_del;
	   ArrayList<JButton> btns_madd;
	   ArrayList<JButton> btns_minus;
	   ArrayList<JLabel> labels_menuPrice;
	   ArrayList<JLabel> labels_amt;
	   JPanel panel_content,top_panel,center_panel,menu_panel,bottom_panel;
	   JLabel total_label,price_label, menu_label, option_label;
	   OrderUI order;
	   LoginUI login;
	   InnerMain main;
	   BBQ_System system;
	   ArrayList<CartVO> cart;
	  
	   int m_price;
	   int price_final;
	   
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
	      total_label = new JLabel();
	      priceChanged();
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
		   btns_madd = new ArrayList<JButton>();
		   btns_minus = new ArrayList<JButton>();
		   labels_menuPrice = new ArrayList<JLabel>();
		   labels_amt = new ArrayList<JLabel>();
		   for(int i=0; i< cart.size();i++) {
//				JPanel pc = new JPanel();
				
//				f.add(pc,BorderLayout.CENTER);
				
				menu_panel = new JPanel(new GridLayout(1,8)) {
					@Override
					public Dimension getPreferredSize() {
						return new Dimension(50,100);
					}
				};
				menu_panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//				pc.add(menu_panel);
			  
				MenuVO menu = cart.get(i).getMenu();
				ArrayList<OptionVO> options = cart.get(i).getOptions();
				
//	      menu_panel = new JPanel(new GridLayout(1,2));
//	      menu_panel.setBounds(0, 40, 400, 200);
			  menu_label = new JLabel();
			  menu_label.setText("메뉴: " + menu.getName() + cart.get(i).getMenu().getPrice());
			  System.out.println("2222");
			  
			  String optionInfo = "";
			  for(OptionVO op : options) {
				  if(optionInfo.equals("")) optionInfo = op.getName() +"("+ op.getPrice() +")";
				  else optionInfo += " / "+ op.getName() +"("+ op.getPrice() +")";
			  }
			  option_label = new JLabel();
			  option_label.setText("옵션: " +optionInfo);
			  JLabel m_price_label = new JLabel();
			  m_price =((cart.get(i).getPrice() * cart.get(i).getAmt()));
			  m_price_label.setText("가격: "+ m_price);
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
		      JButton btn_madd = new JButton("+");
		      JButton btn_minus = new JButton("-");
		      JLabel label_amt = new JLabel();
		      label_amt.setText(Integer.toString(cart.get(i).getAmt()));
		      JPanel count_panel = new JPanel();
		      count_panel.add(btn_minus);
		      count_panel.add(label_amt);
		      count_panel.add(btn_madd);
		      count_panel.setBounds(0,50, 300, 60);
		      right_panel.add(btn_mdelete);
		      right_panel.add(count_panel);
		      
		      
		      menu_panel.add(BorderLayout.EAST, right_panel);
	//	      panel_content.add(menu_panel);     ///////
		      center_panel.add(menu_panel);    
	//	      panel_content.add(center_panel);     
		      
		      labels_menuPrice.add(m_price_label);
		      labels_amt.add(label_amt);
		      btns_del.add(btn_mdelete);
		      btns_madd.add(btn_madd);
		      btns_minus.add(btn_minus);
		      
		      btn_mdelete.addActionListener(this);
		      btn_madd.addActionListener(this);
		      btn_minus.addActionListener(this);
		  }

	   }//menulist_btn
	   
	   void priceChanged() {
		   price_final = 0;
		   for(CartVO menu : cart) {
			   price_final += menu.getPrice() * menu.getAmt();
		   }
		   total_label.setText("총주문금액: "+ price_final +"원");
	   }

	   void deleteMenu(Object obj) {
		   for(int i=0;i<btns_del.size();i++) {
			   if(btns_del.get(i) == obj) {
				   system.deleteCartMenu(i);
				   i = btns_del.size();
			   }
		   }
	   }
	   
	   void addAmt(Object obj) {
		   for(int i=0;i<btns_madd.size();i++) {
			   if(btns_madd.get(i) == obj) {
				   system.addCart(i);
				   labels_menuPrice.get(i).setText("가격: "+ cart.get(i).getPrice() * cart.get(i).getAmt());
				   labels_amt.get(i).setText(String.valueOf(cart.get(i).getAmt())); 
				   i = btns_madd.size();
			   }
		   }
		   priceChanged();
	   }
	   
	   void reduceAmt(Object obj) {
		   for(int i=0;i<btns_minus.size();i++) {
			   if(btns_minus.get(i) == obj) {
				   if(cart.get(i).getAmt() > 1) {					   
					   system.reduceCart(i);
					   labels_menuPrice.get(i).setText("가격: "+ cart.get(i).getPrice() * cart.get(i).getAmt());
					   labels_amt.get(i).setText(String.valueOf(cart.get(i).getAmt()));
				   }
				   i = btns_minus.size();
			   }
		   }
		   priceChanged();
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
		      }else if(btns_madd.contains(obj)) {
		    	  addAmt(obj);
		      }else if(btns_minus.contains(obj)) {
		    	  reduceAmt(obj);
		    	  System.out.println("빼기 클릭");
		      }
		  }//actionPerformed

	}//ShopBasketUI