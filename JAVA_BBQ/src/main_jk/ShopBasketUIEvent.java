package main_jk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	      
	      if(obj ==shop.btn_back) {  
	    	  shop.f.setVisible(false);
	    	  new InnerMain();
	    	  
	      }else if(obj == shop.btn_all_delete) {
	    	 shop.menu_panel.setVisible(false);
		     shop.center_panel.remove(shop.menu_panel);
		     
	         System.out.println("전체삭제");
	         
	      }else if(obj == shop.btn_order) {
	         System.out.println("추가 주문");
	         new MenulistUI();
	         
	      }else if(obj == shop.btn_pay) {
	         shop.f.setVisible(false);
	         new PayUI();
	         
	      }else if(obj == shop.btn_mdelete) {
	    	  //버튼클릭시 db삭제
//	    	 order.getcartdeleteResult(shop.cvo.get(0).getrno());
	         shop.menu_panel.setVisible(false);
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
