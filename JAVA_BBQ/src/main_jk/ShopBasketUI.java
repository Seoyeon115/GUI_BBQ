package main_jk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import main.Commons;
import main_jk.PayUI;
import main_sy.InnerMain;
import main_sy.MenulistUI;
import main_jk.OrderUI;

public class ShopBasketUI implements ActionListener{
     // Field
      JFrame f;
      JButton btn_check,btn_back,btn_alldel,btn_order,btn_pay,btn_all_delete,
            btn_mdelete, btn_madd, btn_minus;
      JPanel panel_content,top_panel,center_panel,menu_panel,bottom_panel;
      JLabel total_label,price_label;
      OrderUI order;
      InnerMain main;
      MenulistUI list1;
      
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
         f = new JFrame("��ٱ���");
         f.getContentPane().setBackground(new Color(204, 0, 51));
         f.getContentPane().setForeground(new Color(255, 255, 255));
         f.setBounds(100, 90, 600, 750);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setLayout(null);
   
         
         panel_content = new JPanel(new BorderLayout());
         panel_content.setBackground(new Color(255, 255, 255));
//         panel_content.setBackground(Color.pink);
         panel_content.setBounds(30, 22, 520, 650);
         
         f.add(panel_content);
         f.setVisible(true);
         
         top_panel = new JPanel(new BorderLayout());
         top_panel.setBackground(new Color(255, 255, 255));
         center_panel = new JPanel(new GridLayout(6,1));
         center_panel.setBackground(new Color(255, 255, 255));
//         center_panel.setBackground(Color.green);
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
         
         btn_all_delete = new JButton("��ü����");
         top_panel.add(BorderLayout.WEST, new JPanel(new GridLayout(1, 1)).add(btn_back));
         top_panel.add(new JLabel("                                       "
               + "        ��ٱ���"));
         top_panel.add(BorderLayout.EAST, new JPanel(new GridLayout(1, 1)).add(btn_all_delete));
         
         //center_panel
         menulist();
         JPanel order_panel = new JPanel(new GridLayout(2,1));
         order_panel.setBackground(new Color(255, 255, 255));
         btn_order = new JButton("�߰� �ֹ�");
         btn_order.setPreferredSize(new Dimension(50, 18));
         order_panel.add(btn_order);
         center_panel.add(order_panel);

//         panel_content.add(btn_order);
         
         //bottom_panel
         JLabel total_label = new JLabel("���ֹ��ݾ�: price +��");
         btn_pay = new JButton("   ����    ");
         bottom_panel.add(total_label);
         bottom_panel.add(btn_pay);
         
         //setting
         panel_content.add(BorderLayout.NORTH, top_panel);
         panel_content.add(BorderLayout.CENTER, center_panel);
         panel_content.add(BorderLayout.SOUTH, bottom_panel);
         
//         JScrollPane content = new JScrollPane(center_panel); 
//         f.add(content);
         
         f.setVisible(true);
         
         btn_back.addActionListener(this);
         btn_all_delete.addActionListener(this);
         btn_order.addActionListener(this);
         btn_pay.addActionListener(this);
         
      }//init

      
      /** �޴� ���� GUI **/
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
         
//         menu_panel = new JPanel(new GridLayout(1,2));
//         menu_panel.setBounds(0, 40, 520, 200);
         JLabel menu_label = new JLabel("select menu");
         JLabel option_label = new JLabel("option");
         JLabel price_label = new JLabel("price");
         
         JPanel right_panel =new JPanel();
         JPanel left_panel =new JPanel(new GridLayout(3,1));
         btn_mdelete = new JButton("x");
         btn_mdelete.setFont(Commons.getFont(10));
         right_panel.setLayout(null);
         btn_mdelete.setBounds(220, 0, 40, 38);
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
//         panel_content.add(menu_panel);     ///////
         center_panel.add(menu_panel);    
//         panel_content.add(center_panel);     
         
         
         btn_mdelete.addActionListener(this);
         btn_madd.addActionListener(this);
         btn_minus.addActionListener(this);
      }//menulist

      @Override
      public void actionPerformed(ActionEvent e) {
         Object obj = e.getSource();
         
         if(obj == btn_back) {  
            f.setVisible(false);
            new InnerMain();
            
         }else if(obj == btn_all_delete) {
            System.out.println("��ü����");
            
         }else if(obj == btn_order) {
            System.out.println("�߰� �ֹ�");
            new MenulistUI();
            
         }else if(obj == btn_pay) {
            f.setVisible(false);
            new PayUI();
            
         }else if(obj == btn_mdelete) {
            System.out.println("����");
            menu_panel.setVisible(false);
            center_panel.remove(menu_panel);
            
         }else if(obj == btn_madd) {
            System.out.println("�߰�");
            
         }else if(obj == btn_minus) {
            System.out.println("����");
            
            
         }
      }//actionPerformed

   }//ShopBasketUI