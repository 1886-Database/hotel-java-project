package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import myConnection.MY_Connection;

public class ReservationManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//기본 생성자 : 커넥션 객체 생성
	public ReservationManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//입력받은 정보를 reservation 테이블에 insert
		public int reservation(String ReservedNo,int RoomNo,String CheckIn,String CheckOut,String ReservedDate,int MemberID, String Requirement,Boolean Breakfast,String ReservedStatus,int GuestNo){
			String SQL = "INSERT INTO DB2023_member VALUES(?,?,?,?,?,?,?,?,?,?)";
			try {
				con=myConnection.getConnection();
				ps=con.prepareStatement(SQL);
				stmt=con.createStatement();
				rs=stmt.executeQuery("select max(memberID) from DB2023_member");
				while(rs.next()) {
					int memberID = rs.getInt(1)+1;
					ps.setString(1, ReservedNo);
					ps.setInt(2, RoomNo);
					ps.setString(3, CheckIn);
					ps.setString(4, CheckOut);
					ps.setString(5, ReservedDate);
					ps.setInt(6, MemberID);
					ps.setString(7, Requirement);
					ps.setBoolean(8, Breakfast);
					ps.setInt(9, GuestNo);
					ps.executeUpdate();
					return 1;
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				myConnection.close(rs,stmt,ps,con);
			}
			return -1; //데이터베이스 오류
		}	
}
