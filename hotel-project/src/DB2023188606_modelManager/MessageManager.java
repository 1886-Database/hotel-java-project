package DB2023188606_modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import DB2023188606_model.Member;
import DB2023188606_model.Message;
import DB2023188606_modelManager.MemberManager;
import DB2023188606_myConnection.MY_Connection;


public class MessageManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	private MemberManager member;
	
	

	public MessageManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			
		}
	}
	
	//회원 메시지 화면: member 메시지 입력받은 값 message 테이블에 insert
	/**
	 * member 메시지 입력받은 값 message 테이블에 insert
	 * @return insert 에러 확인용 정수
	 */
	public int sendMessage(int memberID, String messagestatus, String content, String sendtime) {
	    String SQL = "INSERT INTO DB2023_message VALUES(?,?,?,?,?)";
	    try {
	        con = myConnection.getConnection();
	        ps = con.prepareStatement(SQL);
	        stmt = con.createStatement();
	        rs = stmt.executeQuery("select max(messageID) from DB2023_message");
	        while (rs.next()) {
	            int messageID = rs.getInt(1) + 1;
	            ps.setInt(1, messageID);
	            ps.setInt(2, memberID);
	            ps.setString(3, messagestatus);
	            ps.setString(4, content);
	            ps.setString(5, sendtime);
	            ps.executeUpdate();
	            return 1;
	        }
	    } catch (Exception e) {
	        
	    } finally {
	        myConnection.close(rs, stmt, ps, con);
	    }
	    return -1; // 데이터베이스 오류
	}
	//직원 메시지 화면: employee 메시지 입력받은 값 message 테이블에 insert
	/**
	 *직원 메시지 입력받은 값 message 테이블에 insert
	 * @return insert 에러 확인용 정수
	 */
	public int EmsendMessage(int memberID, String messagestatus, String content, String sendtime) {
	    String SQL = "INSERT INTO DB2023_message VALUES(?,?,?,?,?)";
	   
	    try {
	    	
	        con = myConnection.getConnection();
	        ps = con.prepareStatement(SQL);
	        stmt = con.createStatement();
	        rs = stmt.executeQuery("select max(messageID) from DB2023_message");
	        while (rs.next()) {
	            int messageID = rs.getInt(1) + 1;
	            ps.setInt(1, messageID);
	            ps.setInt(2, memberID);
	            ps.setString(3, messagestatus);
	            ps.setString(4, content);
	            ps.setString(5, sendtime);
	            ps.executeUpdate();
	            return 1;
	        }
	    } catch (Exception e) {
	        
	    } finally {
	        myConnection.close(rs, stmt, ps, con);
	    }
	    return -1; // 데이터베이스 오류
	}

	//회원 메시지 화면: memberid를 인수로 받아 member가 보낸 메시지 가져옴
		/**
		 *memberid를 인수로 받아 member가 보낸 메시지 값을 객체에 저장하여 가져오는 메소드
		 * @return member message 객체 배열
		 */
		public Message[] getMemberSendMessage(int memberID) {
			String mess = "SELECT messageID, memberID, messagestatus, content, sendtime FROM DB2023_message WHERE memberID=? and messagestatus='memsend' ORDER BY sendtime ASC";

			ArrayList<Message> messageList = new ArrayList<>();
			try {
				con = myConnection.getConnection();
				ps = con.prepareStatement(mess);
				ps.setInt(1, memberID);

				//각 객체에 값 저장
				rs = ps.executeQuery();
				while (rs.next()) {
					Message message = new Message();
					message.setMessageID(rs.getInt(1));
					message.setMemberID(rs.getInt(2));
					message.setMessagestatus(rs.getString(3));
					message.setContent(rs.getString(4));
					message.setSendtime(rs.getString(5));
					messageList.add(message);
				}

				return messageList.toArray(new Message[0]);
			} catch (Exception e) {
				
			} finally {
				myConnection.close(rs, stmt, null, con);
			}

	        return new Message[0];
	    }
	
		
		//회원 메시지 화면: memberid를 인수로 받아 member가 받은 메시지 가져옴
				/**
				 *memberid를 인수로 받아 member가 받은 메시지 값을 객체에 저장하여 가져오는 메소드
				 * @return member message 객체 배열
				 */
public Message[] getMemberRecieveMessage(int memberID) {
	String mess = "SELECT messageID, memberID, messagestatus, content, sendtime FROM DB2023_message WHERE memberID=? and messagestatus='memreceive' ORDER BY sendtime ASC";

	ArrayList<Message> messageList = new ArrayList<>();
	try {
		con = myConnection.getConnection();
		ps = con.prepareStatement(mess);
		ps.setInt(1, memberID);

		//각 객체에 값 저장
		rs = ps.executeQuery();
		while (rs.next()) {
			Message message = new Message();
			message.setMessageID(rs.getInt(1));
			message.setMemberID(rs.getInt(2));
			message.setMessagestatus(rs.getString(3));
			message.setContent(rs.getString(4));
			message.setSendtime(rs.getString(5));
			messageList.add(message);
		}

		return messageList.toArray(new Message[0]);
	} catch (Exception e) {
		
	} finally {
		myConnection.close(rs, stmt, null, con);
	}

    return new Message[0];
}
//직원 메시지 화면: employee가 보낸 메시지 가져옴
		/**
		 *employee가 보낸 메시지 값을 객체에 저장하여 가져오는 메소드
		 * @return employee message 객체 배열
		 */
public Message[] getEmployeeSendMessage() {
	Message[] m_array;
	int rowCnt=0;
	int index=0;
	String mess = "SELECT messageID, memberID, messagestatus, content, sendtime FROM DB2023_message WHERE messagestatus='memreceive' ORDER BY sendtime ASC";
	String messCnt = "SELECT COUNT(*) FROM DB2023_message WHERE messagestatus='memreceive'";
	try {
		con=myConnection.getConnection();
		stmt=con.createStatement();
		
		//message 테이블의 레코드 개수 크기 만큼의 객체배열 생성
		ResultSet rsCnt=stmt.executeQuery(messCnt);
		
		if(rsCnt.next()) {
			rowCnt =rsCnt.getInt(1);
		}
		m_array=new Message[rowCnt];
		for (int i = 0; i < m_array.length; ++i)
			m_array[i] = new Message();
		
		rsCnt.close();     //자원반납
		
		//각 객체에 값 저장
		rs=stmt.executeQuery(mess);
		while(rs.next()) {
			m_array[index].setMessageID(rs.getInt(1));
			m_array[index].setMemberID(rs.getInt(2));
			m_array[index].setMessagestatus(rs.getString(3));
			m_array[index].setContent(rs.getString(4));
			m_array[index].setSendtime(rs.getString(5));
			index++;
		}
	
		return m_array;
		
	}catch(Exception e) {
		
	}finally {
		myConnection.close(rs, stmt, null, con);
	}
	
	m_array=new Message[rowCnt];
	return m_array;
}

//직원 메시지 화면: employee가 받은 메시지 가져옴
		/**
		 *employee가 받은 메시지 값을 객체에 저장하여 가져오는 메소드
		 * @return employee message 객체 배열
		 */

public Message[] getEmployeeRecieveMessage() {
	Message[] m_array;
	int rowCnt=0;
	int index=0;
	String mess = "SELECT messageID, memberID, messagestatus, content, sendtime FROM DB2023_message WHERE messagestatus='memsend' ORDER BY sendtime ASC";
	String messCnt = "SELECT COUNT(*) FROM DB2023_message WHERE messagestatus='memsend'";
	try {
		con=myConnection.getConnection();
		stmt=con.createStatement();
		
		//message 테이블의 레코드 개수 크기 만큼의 객체배열 생성
		ResultSet rsCnt=stmt.executeQuery(messCnt);
		
		if(rsCnt.next()) {
			rowCnt =rsCnt.getInt(1);
		}
		m_array=new Message[rowCnt];
		for (int i = 0; i < m_array.length; ++i)
			m_array[i] = new Message();
		
		rsCnt.close();     //자원반납
		
		//각 객체에 값 저장
		rs=stmt.executeQuery(mess);
		while(rs.next()) {
			m_array[index].setMessageID(rs.getInt(1));
			m_array[index].setMemberID(rs.getInt(2));
			m_array[index].setMessagestatus(rs.getString(3));
			m_array[index].setContent(rs.getString(4));
			m_array[index].setSendtime(rs.getString(5));
			index++;
		}
	
		return m_array;
		
	}catch(Exception e) {
		
	}finally {
		myConnection.close(rs, stmt, null, con);
	}
	
	m_array=new Message[rowCnt];
	return m_array;
}
}




