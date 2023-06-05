package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Employee;
import model.Reservation;
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

	
public Reservation[] getAllReservation() {
	Reservation[] r_array;
	int rowCnt=0;
	int index=0;
	String res = "SELECT * FROM DB2023_reservation";
	String resCnt = "SELECT COUNT(*) FROM DB2023_reservation";
	try {
		con=myConnection.getConnection();
		stmt=con.createStatement();
		
		//reservation 테이블의 레코드 개수 크기 만큼의 객체배열 생성
		ResultSet rsCnt=stmt.executeQuery(resCnt);
		
		if(rsCnt.next()) {
			rowCnt =rsCnt.getInt(1);
		}
		r_array=new Reservation[rowCnt];
		for (int i = 0; i < r_array.length; ++i)
			r_array[i] = new Reservation();
		
		rsCnt.close();     //자원반납
		
		//각 객체에 값 저장
		rs=stmt.executeQuery(res);
		while(rs.next()) {
			r_array[index].setReservedNo(rs.getInt(1));
			r_array[index].setRoomNo(rs.getInt(2));
			r_array[index].setCheckIn(rs.getString(3));
			r_array[index].setCheckOut(rs.getString(4));
			r_array[index].setReservedDate(rs.getString(5));
			r_array[index].setMemberID(rs.getInt(6));
			r_array[index].setRequirement(rs.getString(7));
			r_array[index].setBreakfast(rs.getBoolean(8));
			r_array[index].setReservedStatus(rs.getString(9));
			r_array[index].setGusetNo(rs.getInt(10));
			
			index++;
		}
	
		return r_array;
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		myConnection.close(rs, stmt, null, con);
	}
	
	r_array=new Reservation[rowCnt];
	return r_array;
}
}