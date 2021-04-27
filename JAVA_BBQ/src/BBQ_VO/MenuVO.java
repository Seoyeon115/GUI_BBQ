package BBQ_VO;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class MenuVO implements Serializable{
	ImageIcon image;
	String name, desc;
	ArrayList<OptionVO> options;
	int mid, price;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ArrayList<OptionVO> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<OptionVO> options) {
		this.options = options;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
