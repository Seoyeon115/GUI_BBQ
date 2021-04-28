package main_jk;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BBQ_DAO_jk.OrderDAO;

public class ShopBasketUIEvent implements ActionListener {
	ShopBasketUI shop;
	OrderDAO order;
	
	public ShopBasketUIEvent(ShopBasketUI shop) {
		this.shop = shop;
	}
	
	   @Override
	   public void actionPerformed(ActionEvent e) {
	      Object obj = e.getSource();
	      
	    for(int i=0; i < shop.cvo.size(); i++) {
	    	if(obj == shop.m_btn.get(i)) {
	    		shop.m_panel.get(i).setVisible(false);
	    		shop.center_panel.remove(shop.m_panel.get(i));
	    		shop.ttl_price -= (shop.cvo.get(i).getPrice() * shop.cvo.get(i).getAmt())+shop.ovo.get(i).getPrice(); //총주문금액 set해야함
	    		
	    		
	    		order.getcartdeleteResult(new LoginUI().id, shop.cvo.get(i).getCartid()); //db에서 삭제
	     }
	    }
	      
	      if(obj ==shop.btn_back) {  
	    	  shop.f.setVisible(false);
	    	  new InnerMain();
	    	  
	      }else if(obj == shop.btn_all_delete) {
	    	 for(JPanel panel :shop.m_panel) {
	    		 panel.setVisible(false);
	    		 shop.center_panel.remove(panel);
	    	 }
	    	 order.getcartdeleteResult(new LoginUI().id);
	         
	      }else if(obj == shop.btn_order) {
	         System.out.println("추가 주문");
	         new MenulistUI();
	         
	      }else if(obj == shop.btn_pay) {
	         shop.f.setVisible(false);
	         new PayUI();
	         
	      }else if(obj == shop.tf_madd) {
		         System.out.println("수량 추가");
		         
	      }else if(obj == shop.btn_madd) {
	         System.out.println("추가");
	         
	      }else if(obj == shop.btn_minus) {
	         System.out.println("빼기");
	         
	      
	         
	      }
	   }//actionPerformed

}
