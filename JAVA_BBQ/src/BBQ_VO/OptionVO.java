package BBQ_VO;

import java.io.Serializable;

// �޴� �ɼ� vo
public class OptionVO implements Serializable{
	String name;
	int oid, price;
	
	public OptionVO() {
		
	}
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
