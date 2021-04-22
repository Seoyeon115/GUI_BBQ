package BBQ_SYSTEM;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import BBQ_VO.MessageVO;

public class ChatClientVO {
	Socket s;
	ObjectInputStream ois;
//	ObjectOutputStream oos;
	MessageVO transVO;
	
	public ChatClientVO() {
		try {
			s = new Socket("localhost", 9000);
			ois = new ObjectInputStream(s.getInputStream());
//			oos = new ObjectOutputStream(s.getOutputStream());

			// 수신작업 실행(무한루프) - inner class 형식의 쓰레드 객체 생성
			ClientThread ct = new ClientThread();
			ct.start();

//			// 1.처음접속
//			MessageVO vo = new MessageVO();
//			vo.setStatus(MessageVO.TALK);
//			vo.setName(transVO.getName());
//			vo.setIdnum(transVO.getIdnum());
//			oos.writeObject(vo);



		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void setVO(MessageVO vo) {
		
		transVO = vo;
	}
	public MessageVO getVO() {
		
		return transVO;
	}
	
	
	class ClientThread extends Thread {

		public void run() {

			try {
				while (true) {
					
					MessageVO vo = (MessageVO) ois.readObject();
					if(vo.getStatus() == MessageVO.CONNECT) {
//						chatmain.append(vo.getContent() + "\n");
						setVO(vo);
					}else if(vo.getStatus() == MessageVO.TALK) {
						setVO(vo);
//						chatmain.append(vo.getName()+" > "+vo.getContent() + "\n");
						
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	
	
}
