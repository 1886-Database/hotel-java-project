package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import myConnection.MY_Connection;

public class EmployeeManager {
	private MY_Connection myConnection;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public EmployeeManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String id, String pw) {
		String SQL = "SELECT * FROM DB2023_employee WHERE loginID=? and password=?";
		try {
			con=myConnection.getConnection();
		    ps = con.prepareStatement(SQL);
		    ps.setString(1, id);
		    ps.setString(2,pw);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) { 
		    	System.out.println("직원 로그인 성공");
		    	return 1; //로그인 성공
		    }
		    return 0; //로그인 실패 (잘못된 id/pw)
		}catch(Exception e){
		    e.printStackTrace();
		}finally {
			System.out.println("자원 반납");
			myConnection.close(rs,null,ps,con);
		}
		return -1; //데이터베이스 오류 
	 }
	
	public int checkID(String id) {
		String SQL = "SELECT * FROM DB2023_employee WHERE loginID=?";
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
}
