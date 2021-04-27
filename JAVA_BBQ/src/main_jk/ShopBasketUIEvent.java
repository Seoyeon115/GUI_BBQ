package main_jk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import BBQ_DAO_jk.OrderDAO;

public class ShopBasketUIEvent implements ActionListener {
	ShopBasketUI shop;
	OrderDAO order;
	 int i;
	
	public ShopBasketUIEvent(ShopBasketUI shop) {
		this.shop = shop;
	}
	
	   @Override
	   public void actionPerformed(ActionEvent e) {
	      Object obj = e.getSource();
	     
	      
	      if(obj ==shop.btn_back) {  
	    	  shop.f.setVisible(false);
	    	  new InnerMain();
	    	  
	      }else if(obj == shop.btn_all_delete) {
	    	 for(JPanel panel :shop.m_panel) {
	    		 panel.setVisible(false);
	    		 shop.center_panel.remove(panel);
	    	 }
	         System.out.println("전체삭제");
	         
	      }else if(obj == shop.btn_order) {
	         System.out.println("추가 주문");
	         new MenulistUI();
	         
	      }else if(obj == shop.btn_pay) {
	         shop.f.setVisible(false);
	         new PayUI();
	         
	      }else if(obj == shop.btn_mdelete || shop.btn_mdelete== shop.m_btn.get(i)) {
	    	  //버튼클릭시 db삭제
//	    	  for(int i=0; i<shop.cvo.size(); i++) {
//	    		  if(shop.cvo.get(i).getRno() == ) {
//	    			  shop.menu_panel.setVisible(false);
//	    		      shop.center_panel.remove(shop.menu_panel);
//	    		  }
//	    	 order.getcartdeleteResult(shop.cvo.get(0).getRno());
//	    		  
//	    	  }
	         shop.m_panel.get(i).setVisible(false);
	         shop.center_panel.remove(shop.menu_panel);
	    		  
	         System.out.println("삭제");
	    	  
	      }else if(obj == shop.tf_madd) {
		         System.out.println("수량 추가");
		         
	      }else if(obj == shop.btn_madd) {
	         System.out.println("추가");
	         
	      }else if(obj == shop.btn_minus) {
	         System.out.println("빼기");
	         
	         
	      }
	   }//actionPerformed

}
