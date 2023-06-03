package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import model.Message;
import myConnection.MY_Connection;

public class MessageManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	public MessageManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//메시지 입력받은 값 message 테이블에 insert
	
	public int sendMessage(String memberID,String messagestatus,String content,String sendtime) {
		String SQL = "INSERT INTO DB2023_message VALUES(?,?,?,?)";
		try {con=myConnection.getConnection();
		ps=con.prepareStatement(SQL);
		stmt=con.createStatement();
		rs=stmt.executeQuery("select max(messageID) from DB2023_message");
		while(rs.next()) {
			int messageID = rs.getInt(1)+1;
			ps.setInt(1, messageID);
			ps.setString(2, memberID);
			ps.setString(3, messagestatus);
			ps.setString(4, content);
			ps.setString(5, sendtime);
			ps.executeUpdate();
			return 1;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		myConnection.close(rs,stmt,ps,con);
	}
	return -1; //데이터베이스 오류
		
	}
	
	//메시지의 멤버ID 값으로 다른 속성 값 얻기
		public Message getByMemberID(String memberID) {
			String SQL = "SELECT * FROM DB2023_message WHERE memberID=?";
			try {
				con=myConnection.getConnection();
				ps=con.prepareStatement(SQL);
				ps.setString(1, memberID);
				rs = ps.executeQuery();
				while(rs.next()) {
					Message message = new Message(memberID,rs.getString(3),rs.getString(4),rs.getString(5));
					return message;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				myConnection.close(rs, null, ps, con);
			}
			Message message = new Message();
			return message;
		}
		
		public Message[] getMemberMessage(String memberID) {
			Message[] m_array;
			int rowCnt=0;
			int index=0;
			String mess = "SELECT * FROM DB2023_message WHERE memberID=? orederby sendtime desc";
			String messCnt = "SELECT COUNT(*) FROM DB2023_message WHERE memberID=?";
			try {
				con=myConnection.getConnection();
				ps = con.prepareStatement(mess);
				ps.setString(1,mess);
				ps = con.prepareStatement(messCnt);
				ps.setString(1,mess);
			
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
					m_array[index].setMemberID(rs.getString(2));
					m_array[index].setMessagestatus(rs.getString(3));
					m_array[index].setContent(rs.getString(5));
					m_array[index].setSendtime(rs.getString(6));
					index++;
				}
			
				return m_array;
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				myConnection.close(rs, stmt, null, con);
			}
			
			m_array=new Message[rowCnt];
			return m_array;
		}
		
		// message 테이블 모든 레코드를 각각 Message 객체에 저장한 후 객체 배열 반환
		public Message[] getAllMessage() {
			Message[] m_array;
			int rowCnt=0;
			int index=0;
			String mess = "SELECT * FROM DB2023_message";
			String messCnt = "SELECT COUNT(*) FROM DB2023_message";
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
					m_array[index].setMemberID(rs.getString(2));
					m_array[index].setMessagestatus(rs.getString(3));
					m_array[index].setContent(rs.getString(5));
					m_array[index].setSendtime(rs.getString(6));
					index++;
				}
			
				return m_array;
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				myConnection.close(rs, stmt, null, con);
			}
			
			m_array=new Message[rowCnt];
			return m_array;
		}
}

