package BBQ_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BBQ_VO.MenuVO;
import BBQ_VO.OrderVO;

public class InnerMain implements ActionListener {
	
	//Field
	public static int MAIN = 0;
	public static int MENULIST = 1;
	public static int MENULIST2 = 2;
	public static int DETAILMENU = 3;
	public static int CART = 4;
	public static int ORDERSTATUS = 5;
	public static int ORDERLIST = 6;
	public static int ORDERDETAIL = 7;
	public static int PAY = 8;
	public static int CHATCON = 9;
	public static int CHATRE = 10;
	
	JFrame frame = new JFrame();
	JButton btn_mainlist, btn_cart, btn_ing, btn_ed;
	MenulistUI list1 = new MenulistUI(this);
	MenulistUI2 list2 = new MenulistUI2(this);
	DetailMenuUI detailMenu = new DetailMenuUI(this);
	ShopBasketUI basket = new ShopBasketUI(this);
	Orderstatus_on ing = new Orderstatus_on(this);
	OrderListUI orderlistUI = new OrderListUI(this);
	OrderDetailUI orderDetailUI = new OrderDetailUI(this);
	ChatUI chatUI = new ChatUI(this);
	PayUI payUI = new PayUI(this);
	int idnum;
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
		panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(255, 255, 255));
		
		//광고 패널
		ImageIcon icon1 = new ImageIcon("images/bbqpsad.png");
		JLabel ad = new JLabel(icon1);
		
		
		JPanel north_panel = new JPanel(new BorderLayout());
		JPanel adpanel = new JPanel();
		JPanel blank = new JPanel();
		JPanel blank2 = new JPanel();
		blank.setPreferredSize(new Dimension(8,20));
		blank2.setPreferredSize(new Dimension(10,0));
		blank2.setBackground(new Color(255, 255, 255));
		blank.setBackground(new Color(255, 255, 255));
		adpanel.setBackground(new Color(255, 255, 255));
		adpanel.add(ad);
		north_panel.add(BorderLayout.NORTH,blank);
		north_panel.add(BorderLayout.CENTER,adpanel);
		north_panel.add(BorderLayout.SOUTH,blank2);
		
		panel.add(BorderLayout.NORTH,north_panel);
		
		
		//버튼 패널
		JPanel btn_panel = new JPanel(new GridLayout(2,2));
		
		int insidesize = 0;
		int outsidesize = 30;
		//주문 버튼
		ImageIcon ordericon = new ImageIcon("images/주문하기.png");
		ImageIcon ordericon2 = new ImageIcon("images/주문하기2.png");
		
		btn_mainlist = new JButton(ordericon);
		btn_mainlist.setPressedIcon(ordericon2);
		btn_mainlist.setBorderPainted(false); 
		btn_mainlist.setFocusPainted(false); 
		btn_mainlist.setContentAreaFilled(false);
		
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		JPanel c = new JPanel();
		JPanel d = new JPanel();
		JPanel btn_mainlist_panel = new JPanel(new BorderLayout());
		btn_mainlist_panel.setBackground(new Color(255,255,255));
		//공백 사이즈 조절
		int size= outsidesize;
		btn_mainlist_panel.add(a);
		a.setPreferredSize(new Dimension(size,size));
		a.setBackground(new Color(255,255,255));
		btn_mainlist_panel.add(b);
		b.setPreferredSize(new Dimension(0,0));
		b.setBackground(new Color(255,255,255));
		btn_mainlist_panel.add(c);
		c.setPreferredSize(new Dimension(size,size));
		c.setBackground(new Color(255,255,255));
		btn_mainlist_panel.add(d);
		d.setPreferredSize(new Dimension(insidesize,insidesize));
		d.setBackground(new Color(255,255,255));
		btn_mainlist_panel.add(BorderLayout.NORTH,a);
		btn_mainlist_panel.add(BorderLayout.SOUTH,b);
		btn_mainlist_panel.add(BorderLayout.WEST,c);
		btn_mainlist_panel.add(BorderLayout.EAST,d);
		btn_mainlist_panel.add(BorderLayout.CENTER,btn_mainlist);
		
		//장바구니 버튼
		ImageIcon carticon = new ImageIcon("images/장바구니.png");
		ImageIcon carticon2 = new ImageIcon("images/장바구니2.png");
		
		btn_cart = new JButton(carticon);
		btn_cart.setPressedIcon(carticon2);
		btn_cart.setBorderPainted(false); 
		btn_cart.setFocusPainted(false); 
		btn_cart.setContentAreaFilled(false);
		
		JPanel f = new JPanel();
		JPanel g = new JPanel();
		JPanel h = new JPanel();
		JPanel i = new JPanel();
		JPanel btn_cart_panel = new JPanel(new BorderLayout());
		btn_cart_panel.setBackground(new Color(255,255,255));
		//공백 사이즈 조절 2
		int size2 = outsidesize;
		btn_cart_panel.add(f);
		f.setPreferredSize(new Dimension(size2,size2));
		f.setBackground(new Color(255,255,255));
		btn_cart_panel.add(g);
		g.setPreferredSize(new Dimension(0,0));
		g.setBackground(new Color(255,255,255));
		btn_cart_panel.add(h);
		h.setPreferredSize(new Dimension(insidesize,insidesize));
		h.setBackground(new Color(255,255,255));
		btn_cart_panel.add(i);
		i.setPreferredSize(new Dimension(size2,size2));
		i.setBackground(new Color(255,255,255));
		btn_cart_panel.add(BorderLayout.NORTH,f);
		btn_cart_panel.add(BorderLayout.SOUTH,g);
		btn_cart_panel.add(BorderLayout.WEST,h);
		btn_cart_panel.add(BorderLayout.EAST,i);
		btn_cart_panel.add(BorderLayout.CENTER,btn_cart);
		
		//현황 버튼
		ImageIcon ingicon = new ImageIcon("images/주문현황.png");
		ImageIcon ingicon2 = new ImageIcon("images/주문현황2.png");
		
		btn_ing = new JButton(ingicon);
		btn_ing.setPressedIcon(ingicon2);
		
		btn_ing.setBorderPainted(false); 
		btn_ing.setFocusPainted(false); 
		btn_ing.setContentAreaFilled(false);
		JPanel j = new JPanel();
		JPanel k = new JPanel();
		JPanel l = new JPanel();
		JPanel m = new JPanel();
		JPanel btn_ing_panel = new JPanel(new BorderLayout());
		btn_ing_panel.setBackground(new Color(255,255,255));
		//공백 사이즈 조절 3
		int size3 = outsidesize;
		btn_ing_panel.add(j);
		j.setPreferredSize(new Dimension(0,0));
		j.setBackground(new Color(255,255,255));
		btn_ing_panel.add(k);
		k.setPreferredSize(new Dimension(size3,size3));
		k.setBackground(new Color(255,255,255));
		btn_ing_panel.add(l);
		l.setPreferredSize(new Dimension(size3,size3));
		l.setBackground(new Color(255,255,255));
		btn_ing_panel.add(m);
		m.setPreferredSize(new Dimension(insidesize,insidesize));
		m.setBackground(new Color(255,255,255));
		btn_ing_panel.add(BorderLayout.NORTH,j);
		btn_ing_panel.add(BorderLayout.SOUTH,k);
		btn_ing_panel.add(BorderLayout.WEST,l);
		btn_ing_panel.add(BorderLayout.EAST,m);
		btn_ing_panel.add(BorderLayout.CENTER,btn_ing);
		
		//내역버튼
		ImageIcon edicon = new ImageIcon("images/주문내역.png");
		ImageIcon edicon2 = new ImageIcon("images/주문내역2.png");
		
		btn_ed = new JButton(edicon);
		btn_ed.setPressedIcon(edicon2);
		btn_ed.setBorderPainted(false); 
		btn_ed.setFocusPainted(false); 
		btn_ed.setContentAreaFilled(false);
		
		JPanel n = new JPanel();
		JPanel o = new JPanel();
		JPanel p = new JPanel();
		JPanel q = new JPanel();
		JPanel btn_ed_panel = new JPanel(new BorderLayout());
		btn_ed_panel.setBackground(new Color(255,255,255));
		//공백 사이즈 조절 4
		int size4 = outsidesize;
		btn_ed_panel.add(n);
		n.setPreferredSize(new Dimension(0,0));
		n.setBackground(new Color(255,255,255));
		btn_ed_panel.add(o);
		o.setPreferredSize(new Dimension(size4,size4));
		o.setBackground(new Color(255,255,255));
		btn_ed_panel.add(p);
		p.setPreferredSize(new Dimension(insidesize,insidesize));
		p.setBackground(new Color(255,255,255));
		btn_ed_panel.add(q);
		q.setPreferredSize(new Dimension(size4,size4));
		q.setBackground(new Color(255,255,255));
		btn_ed_panel.add(BorderLayout.NORTH,n);
		btn_ed_panel.add(BorderLayout.SOUTH,o);
		btn_ed_panel.add(BorderLayout.WEST,p);
		btn_ed_panel.add(BorderLayout.EAST,q);
		btn_ed_panel.add(BorderLayout.CENTER,btn_ed);
		
		btn_panel.add(btn_mainlist_panel);
		btn_panel.add(btn_cart_panel);
		btn_panel.add(btn_ing_panel);
		btn_panel.add(btn_ed_panel);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(30, 22, 520, 820);
		panel.add(btn_panel);
		
		btn_mainlist.addActionListener(this);
		btn_cart.addActionListener(this);
		btn_ing.addActionListener(this);
		btn_ed.addActionListener(this);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void switchPanel(int ui) {
		if(ui == MAIN) {
			panelinit();
		}else if(ui == MENULIST) {
			frame.add(list1.initialize());
		}else if(ui == MENULIST2) {
			frame.add(list2.initialize());
		}else if(ui == CART) {
			frame.add(basket.init());
		}else if(ui == ORDERSTATUS) {
			frame.add(ing.init());
		}else if(ui == ORDERLIST) {
			frame.add(orderlistUI.init());
		}else if(ui == PAY) {
			frame.add(payUI.init());
		}else if(ui == CHATCON) {
			idnum += 1;
			chatUI.createsocket(idnum);
			frame.add(chatUI.init());
		}else if(ui == CHATRE) {
			frame.add(chatUI.init());
			String[] array = chatUI.msg_array;
			String msg = "";
			for(int i=0;i<array.length;i++) {
				msg += array[i]+"\n";
			}
			chatUI.chatmain.setText(msg);
		}
	}
	
	public void switchPanel(int ui, Object obj) {
		// 다른 매개변수가 필요한 패널
		if(ui == DETAILMENU) {
			frame.add(detailMenu.init((MenuVO)obj));
		}else if(ui == ORDERDETAIL) {
			frame.add(orderDetailUI.init((OrderVO)obj));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_mainlist) {
			panel.setVisible(false);
//			frame.add(list1.initialize());
			switchPanel(InnerMain.MENULIST);
		}else if(obj == btn_cart) {
//			System.out.println("cart");
			panel.setVisible(false);
//			frame.add(basket.init());
			switchPanel(InnerMain.CART);
		}else if(obj == btn_ing) {
			panel.setVisible(false);
//			frame.add(ing.init());
			switchPanel(InnerMain.ORDERSTATUS);
		}else if(obj == btn_ed) {
			panel.setVisible(false);
//			frame.add(orderlistUI.init());
			switchPanel(InnerMain.ORDERLIST);
		}
	}
}
