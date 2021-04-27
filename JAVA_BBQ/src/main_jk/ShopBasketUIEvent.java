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
		     
	         System.out.println("��ü����");
	         
	      }else if(obj == shop.btn_order) {
	         System.out.println("�߰� �ֹ�");
	         new MenulistUI();
	         
	      }else if(obj == shop.btn_pay) {
	         shop.f.setVisible(false);
	         new PayUI();
	         
	      }else if(obj == shop.btn_mdelete) {
	    	  //��ưŬ���� db����
//	    	 order.getcartdeleteResult(shop.cvo.get(0).getrno());
	         shop.menu_panel.setVisible(false);
	         shop.center_panel.remove(shop.menu_panel);
	         System.out.println("����");
	    	
	      }else if(obj == shop.tf_madd) {
		         System.out.println("���� �߰�");
		         
	      }else if(obj == shop.btn_madd) {
	         System.out.println("�߰�");
	         
	      }else if(obj == shop.btn_minus) {
	         System.out.println("����");
	         
	         
	      }
	   }//actionPerformed

}
