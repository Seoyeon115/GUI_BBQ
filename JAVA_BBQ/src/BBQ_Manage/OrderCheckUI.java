package BBQ_Manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import BBQ_UI.Commons;
import BBQ_VO.MemberVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

public class OrderCheckUI implements ActionListener {

	ManagerSystem system;
	JFrame f;
	JButton dele30, dele60, dele90, delete;
	String id;
//	ArrayList<OrderVO> orderlist;
	OrderVO order;

	public OrderCheckUI() {
			init2();
	}
//	public OrderCheckUI(String id) {
//		this.id = id;
//		
//		
//		init();
//
//	}
	public OrderCheckUI(String id,ArrayList<OrderVO> orderlist) {
		this.id = id;
		for(OrderVO order : orderlist) {			
			if(order.getOrderId() == id) {
				this.order = order;
				break;
			}
		}
		init();
		
	}
	
	public OrderCheckUI(String id,ArrayList<OrderVO> orderlist, ManagerSystem system) {
		this.system = system;
		this.id = id;
		for(OrderVO order : orderlist) {			
			if(order.getOrderId() == id) {
				this.order = order;
				break;
			}
		}
		init();
	}

	public void init2() {
		f = new JFrame();
		f.setSize(588, 712);
		f.setLocation(700, 100);
		f.getContentPane().setBackground(new Color(204, 0, 51));
		f.getContentPane().setLayout(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 25, 520, 620);
		f.add(panel);

		f.setVisible(true);
		
	}
	public void init() {

		f = new JFrame();
		f.setSize(588, 712);
		f.setLocation(700, 100);
		f.getContentPane().setBackground(new Color(204, 0, 51));
		f.getContentPane().setLayout(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
//		for(int i =0;i<orderlist.size();i++) {
//			if(id == orderlist.get(i).getOrderId()) {
//				order = orderlist.get(i);
//			}
//		}
		
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 25, 520, 620);


		JPanel norNorthPn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		norNorthPn.setBackground(new Color(255, 255, 255));
		JLabel orderpro = new JLabel("주문 제품");
		orderpro.setFont(Commons.getFont(1, 28));
		norNorthPn.add(orderpro);
		
//		ArrayList<OrderVO> prolist = new ArrayList<OrderVO>();
//		for(int i =0; i<orderlist.size();i++) {
//			if(id.equals(orderlist.get(i).getOrderId())) {
//				OrderVO or = new OrderVO();
//				or = orderlist.get(i);
//				prolist.add(or);
//			}
//			
//		}
		JPanel northPn = new JPanel(new BorderLayout());
		northPn.setBackground(new Color(255, 255, 255));
		
		JPanel norcen = new JPanel(new GridLayout(order.getMenulist().size(),1));
//		JPanel norcen = new JPanel(new GridLayout(prolist.size(),1));
		norcen.setBorder(new LineBorder(new Color(0, 0, 0, 120), 2, true));
		
		for(int i=0;i<order.getMenulist().size();i++) {
			JPanel norCenterpn = new JPanel(new GridLayout(1, 3));
			norCenterpn.setBackground(new Color(255, 255, 255));
			JLabel pname = new JLabel("    " + order.getMenulist().get(i).getMenu().getName());
			pname.setFont(Commons.getFont(1, 20));
			JLabel amount = new JLabel("     " + order.getMenulist().get(i).getAmt() + "마리");
			amount.setFont(Commons.getFont(1, 20));
			
			String optionfinal = "";
			for(OptionVO op : order.getMenulist().get(i).getOptions()) {
				optionfinal += op.getName() +" ";
			}
			
//			String optionpro = prolist.get(i).getOption();
//			System.out.println(optionpro);
//			String[] optionlist = optionpro.split("/");
//			
//			String optionfinal = "";
//			for(int j = 0; j<optionlist.length; j++) {
//				if(optionlist[j].equals("1")) {
//					optionfinal += "치킨무 ";
//					
//				}else if(optionlist[j].equals("2")) {
//					optionfinal += "콜라 ";
//					
//				}else if(optionlist[j].equals("3")) {
//					optionfinal += "사이다 ";
//				}
//			}
			
			JLabel option = new JLabel(optionfinal);
	//		JLabel option = new JLabel("치킨무");
			option.setFont(Commons.getFont(1, 20));
			
			norCenterpn.add(pname);
			norCenterpn.add(amount);
			norCenterpn.add(option);
			norcen.add(norCenterpn);
		}
		

		// 여백
		JPanel north = new JPanel(new BorderLayout());
		JPanel blank1 = new JPanel();
		blank1.setBackground(new Color(255, 255, 255));
		JPanel blank2 = new JPanel();
		blank2.setBackground(new Color(255, 255, 255));
		north.add(BorderLayout.NORTH, blank1);
		north.add(BorderLayout.CENTER, norcen);
		north.add(BorderLayout.SOUTH, blank2);

		northPn.add(BorderLayout.NORTH, norNorthPn);
		northPn.add(BorderLayout.CENTER, north);

		// 센터패널
		JPanel centerPn = new JPanel(new BorderLayout());
		centerPn.setBackground(new Color(255, 255, 255));

		JPanel cenNorthPn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cenNorthPn.setBackground(new Color(255, 255, 255));
		JLabel orderinfo = new JLabel("주문 정보");
		orderinfo.setFont(Commons.getFont(1, 28));
		cenNorthPn.add(orderinfo);

		JPanel center = new JPanel(new BorderLayout());
		center.setBackground(new Color(255, 255, 255));
		center.setBorder(new LineBorder(new Color(0, 0, 0, 120), 2, true));

		JPanel cenWestPn = new JPanel(new GridLayout(5, 1, 0, 30));
		cenWestPn.setBackground(new Color(255, 255, 255));

		JPanel namelbpn = new JPanel();
		namelbpn.setBackground(new Color(255, 255, 255));
		JLabel namelb = new JLabel("고객명");
		namelb.setFont(Commons.getFont(1, 23));
		namelbpn.add(namelb);
		JPanel addrlbpn = new JPanel();
		addrlbpn.setBackground(new Color(255, 255, 255));
		JLabel addrlb = new JLabel("주소");
		addrlb.setFont(Commons.getFont(1, 23));
		addrlbpn.add(addrlb);
		JPanel hplbpn = new JPanel();
		hplbpn.setBackground(new Color(255, 255, 255));
		JLabel hplb = new JLabel("휴대폰");
		hplb.setFont(Commons.getFont(1, 23));
		hplbpn.add(hplb);

		JPanel blank7 = new JPanel();
		blank7.setBackground(new Color(255, 255, 255));
		JPanel blank8 = new JPanel();
		blank8.setBackground(new Color(255, 255, 255));
		cenWestPn.add(blank7);
		cenWestPn.add(namelbpn);
		cenWestPn.add(addrlbpn);
		cenWestPn.add(hplbpn);
		cenWestPn.add(blank8);

		JPanel cenCenterPn = new JPanel(new GridLayout(5, 1, 0, 30));
		cenCenterPn.setBackground(new Color(255, 255, 255));
		JPanel namepn = new JPanel(new FlowLayout());
		namepn.setBackground(new Color(255, 255, 255));
		JLabel name = new JLabel(order.getName());
		name.setFont(Commons.getFont(1, 19));
		namepn.add(name);
		JPanel addrpn = new JPanel(new FlowLayout());
		addrpn.setBackground(new Color(255, 255, 255));
		JLabel addr = new JLabel(order.getAddr());
		addr.setFont(Commons.getFont(1, 19));
		addrpn.add(addr);
		JPanel hppn = new JPanel(new FlowLayout());
		hppn.setBackground(new Color(255, 255, 255));

		ArrayList<MemberVO> member = system.getMemberList();

		String phone = "";
		for (int i = 0; i < member.size(); i++) {
			if (order.getName().equals(member.get(i).getId())) {
				phone = member.get(i).getHp1() + "-" + member.get(i).getHp2() + "-" + member.get(i).getHp3();
			}
		}
		JLabel hp = new JLabel(phone);
		hp.setFont(Commons.getFont(1, 19));
		hppn.add(hp);
		JPanel blank3 = new JPanel();
		blank3.setBackground(new Color(255, 255, 255));
		JPanel blank4 = new JPanel();
		blank4.setBackground(new Color(255, 255, 255));
		cenCenterPn.add(blank3);
		cenCenterPn.add(namepn);
		cenCenterPn.add(addrpn);
		cenCenterPn.add(hppn);
		cenCenterPn.add(blank4);

		center.add(BorderLayout.WEST, cenWestPn);
		center.add(BorderLayout.CENTER, cenCenterPn);

		JPanel cenblank = new JPanel(new BorderLayout());
		JPanel blank5 = new JPanel();
		blank5.setBackground(new Color(255, 255, 255));
		JPanel blank6 = new JPanel();
		blank6.setBackground(new Color(255, 255, 255));

		cenblank.add(BorderLayout.NORTH, blank5);
		cenblank.add(BorderLayout.CENTER, center);
		cenblank.add(BorderLayout.SOUTH, blank6);

		centerPn.add(BorderLayout.NORTH, cenNorthPn);
		centerPn.add(BorderLayout.CENTER, cenblank);

		centerPn.setBackground(new Color(255, 255, 255));

		JPanel southPn = new JPanel();
		southPn.setBackground(new Color(255, 255, 255));
		dele30 = new JButton("30분후");
		dele30.setFont(Commons.getFont(12));
		dele60 = new JButton("60분후");
		dele60.setFont(Commons.getFont(12));
		dele90 = new JButton("90분후");
		dele90.setFont(Commons.getFont(12));
		delete = new JButton("취소");
		delete.setFont(Commons.getFont(12));

		southPn.add(dele30);
		southPn.add(dele60);
		southPn.add(dele90);
		southPn.add(delete);

		dele30.addActionListener(this);
		dele60.addActionListener(this);
		dele90.addActionListener(this);
		delete.addActionListener(this);
		
		panel.add(BorderLayout.NORTH, northPn);
		panel.add(BorderLayout.CENTER, centerPn);
		panel.add(BorderLayout.SOUTH, southPn);

		f.add(panel);

		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
				if(obj == dele30) {
					order.setState(1);
					String date = order.getDate();
					String[] date1 = date.split(" ");
					String datevalue = date1[0];
					String[] date2 = date1[1].split(":");
					int hour = Integer.parseInt(date2[0]);
					int min = Integer.parseInt(date2[1]);
					String sec = date2[2];
					
					int addvalue = (hour*60) + min + 30;
					
					String addhour = String.valueOf(addvalue/60);
					String addmin = String.valueOf(addvalue%60);
					
					String finaldate = datevalue+" "+addhour+":"+addmin+":"+sec;
					
					order.setDate(finaldate);
					
					boolean result = system.orderupdate(order);
					if (result) {
						JOptionPane.showMessageDialog(null, Commons.getMsg("주문을 받았습니다~"));
						f.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, Commons.getMsg("주문 받기에 실패했습니다...."));
					}
				}else if(obj == dele60) {
					order.setState(1);
					String date = order.getDate();
					String[] date1 = date.split(" ");
					String datevalue = date1[0];
					String[] date2 = date1[1].split(":");
					int hour = Integer.parseInt(date2[0]);
					int min = Integer.parseInt(date2[1]);
					String sec = date2[2];
					
					int addvalue = (hour*60) + min + 60;
					
					String addhour = String.valueOf(addvalue/60);
					String addmin = String.valueOf(addvalue%60);
					
					String finaldate = datevalue+" "+addhour+":"+addmin+":"+sec;
					
					order.setDate(finaldate);
					
					boolean result = system.orderupdate(order);
					if (result) {
						JOptionPane.showMessageDialog(null, Commons.getMsg("주문을 받았습니다~"));
						f.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, Commons.getMsg("주문 받기에 실패했습니다...."));
					}
					
				}else if(obj == dele90) {
					order.setState(1);
					String date = order.getDate();
					String[] date1 = date.split(" ");
					String datevalue = date1[0];
					String[] date2 = date1[1].split(":");
					int hour = Integer.parseInt(date2[0]);
					int min = Integer.parseInt(date2[1]);
					String sec = date2[2];
					
					int addvalue = (hour*60) + min + 90;
					
					String addhour = String.valueOf(addvalue/60);
					String addmin = String.valueOf(addvalue%60);
					
					String finaldate = datevalue+" "+addhour+":"+addmin+":"+sec;
					
					order.setDate(finaldate);
					
					boolean result = system.orderupdate(order);
					if (result) {
						JOptionPane.showMessageDialog(null, Commons.getMsg("주문을 받았습니다~"));
						f.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, Commons.getMsg("주문 받기에 실패했습니다...."));
					}
				}else if(obj == delete) {
					f.setVisible(false);
				}
	}

}
