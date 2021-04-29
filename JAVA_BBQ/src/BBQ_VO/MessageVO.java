package BBQ_VO;

import java.io.Serializable;
import java.util.Vector;

public class MessageVO implements Serializable {
	
	public static final int CONNECT = 0; //처음 접속
	public static final int TALK = 1; //대화중
	public static final int EXIT = 2; //종료
	
	//Field
	int status,idnum;
	String name, content;
	Vector<String> users;
	
	
	
	
	public int getIdnum() {
		return idnum;
	}
	public void setIdnum(int idnum) {
		this.idnum = idnum;
	}
	public Vector<String> getUsers() {
		return users;
	}
	public void setUsers(Vector<String> users) {
		this.users = users;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
