package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Employee;
import model.Reservation;
import myConnection.MY_Connection;

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

<<<<<<< Updated upstream
	
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
=======
		public Reservation[] getReservationView() {
		    Reservation[] r_array;
		    int rowCnt = 0;
		    int index = 0;
		    String res = "CREATE OR REPLACE VIEW MemberReservationView AS "
		            + "SELECT member.name, member.phone, reservation.reservedNo, reservation.roomNo, reservation.checkIn, reservation.checkOut, "
		            + "reservation.reservedDate, reservation.memberID, reservation.reservedStatus, reservation.requirement "
		            + "FROM DB2023_member AS member "
		            + "JOIN DB2023_reservation AS reservation ON member.memberID = reservation.memberID;";
		    String resCnt = "SELECT COUNT(*) FROM DB2023_reservation";
		    try {
		        con = myConnection.getConnection();
		        stmt = con.createStatement();

		        // 뷰가 이미 존재하는지 확인
		        String dropView = "DROP VIEW IF EXISTS MemberReservationView";
		        stmt.executeUpdate(dropView);

		        // MemberReservationView 뷰 생성
		        stmt.executeUpdate(res);

		        // reservation 테이블의 레코드 개수 확인
		        ResultSet rsCnt = stmt.executeQuery(resCnt);

		        if (rsCnt.next()) {
		            rowCnt = rsCnt.getInt(1);
		        }
		        r_array = new Reservation[rowCnt];
		        for (int i = 0; i < r_array.length; ++i)
		            r_array[i] = new Reservation();

		        rsCnt.close(); // 자원 반환

		        // MemberReservationView 뷰에서 데이터 조회
		        String query = "SELECT name, phone, reservedNo, roomNo, checkIn, checkOut, reservedDate, memberID, reservedStatus, requirement "
		                + "FROM MemberReservationView";
		        rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            r_array[index].setMemberName(rs.getString(1));
		            r_array[index].setMemberPhone(rs.getString(2));
		            r_array[index].setReservedNo(rs.getInt(3));
		            r_array[index].setRoomNo(rs.getInt(4));
		            r_array[index].setCheckIn(rs.getString(5));
		            r_array[index].setCheckOut(rs.getString(6));
		            r_array[index].setReservedDate(rs.getString(7));
		            r_array[index].setMemberID(rs.getInt(8));
		            r_array[index].setReservedStatus(rs.getString(9));
		            r_array[index].setRequirement(rs.getString(10));
		            index++;
		        }

		        return r_array;

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        myConnection.close(rs, stmt, null, con);
		    }

		    r_array = new Reservation[rowCnt];
		    return r_array;
		}


public int edit(int reservedNo,String reservedStatus) {
	String SQL = "UPDATE DB2023_reservation SET reservedStatus=? WHERE reservedNo=?";
	try {
		con=myConnection.getConnection();
		ps=con.prepareStatement(SQL);
		ps.setString(1, reservedStatus);
		ps.setInt(2,reservedNo);
		ps.executeUpdate();
		return 1;
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		myConnection.close(null, stmt, null, con);
	}
	return -1;
>>>>>>> Stashed changes
}
}