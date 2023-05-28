package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import myConnection.MY_Connection;

public class MemberManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	public MemberManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String id, String pw) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=? and password=?";
		try {
			con=myConnection.getConnection();
		    ps = con.prepareStatement(SQL);
		    ps.setString(1, id);
		    ps.setString(2,pw);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) { 
		    	System.out.println("멤버 로그인 성공");
		    	return 1; //로그인 성공
		    }
		    return 0; //로그인 실패 (잘못된 id/pw)
		}catch(Exception e){
		    e.printStackTrace();
		}finally {
			myConnection.close(rs,null,ps,con);
		}
		return -1; //데이터베이스 오류 
	 }
	
	public int checkID(String id) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=?";
		System.out.println("checkID");
		try {
			con=myConnection.getConnection();
		    ps = con.prepareStatement(SQL);
		    ps.setString(1, id);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) { 
		    	System.out.println("중복 ID 존재");
		    	return 0; //중복 ID 존재
		    }
		    return 1; //중복 ID 존재하지 않음
		}catch(Exception e){
		    e.printStackTrace();
		}finally {
			myConnection.close(rs,null,ps,con);
		}
		return -1; //데이터베이스 오류 
	}
	
	public int signUp(String name,String loginID,String password,String phoneNum,String birthDate){
		String SQL = "INSERT INTO DB2023_member VALUES(?,?,?,?,?,?,?)";
		try {
			con=myConnection.getConnection();
			ps=con.prepareStatement(SQL);
			stmt=con.createStatement();
			rs=stmt.executeQuery("select max(memberID) from DB2023_member");
			while(rs.next()) {
				int memberID = rs.getInt(1)+1;
				ps.setInt(1, memberID);
				ps.setString(2, loginID);
				ps.setString(3, name);
				ps.setString(4, password);
				ps.setString(5, phoneNum);
				ps.setString(6, birthDate);
				ps.setString(7, "bronze");
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
}

