package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import myConnection.MY_Connection;
import view.form.Form_Reservation;
import view.form.Form_RoomReservation;

public class ReservationManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	private Form_Reservation form3;
	private Form_RoomReservation rr;
	
	//기본 생성자 : 커넥션 객체 생성
	public ReservationManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		form3 = new Form_Reservation();
		rr = new Form_RoomReservation();
	}
	//입력받은 정보를 reservation 테이블에 insert
		public int reservation(){
			String SQL = "INSERT INTO DB2023_member VALUES(?,?,?,?,?,?,?,?,?,?)";
			try {
				con=myConnection.getConnection();
				ps=con.prepareStatement(SQL);
				stmt=con.createStatement();
				rs=stmt.executeQuery("select max(reservedNo) from DB2023_room");
				while(rs.next()) {
					String[] s = form3.dataArr();
					String MEMBERID = s[0];
		            String ROOMNO = s[1];
		            String CHECKIN = s[2];
		            String CHECKOUT = s[3];
		            
		            String[] s2 = rr.dataArr2();
		            String RESERVEDDATE = s2[0];
		            String REQUIREMENT = s2[1];
		            String BREAKFAST_ = s2[2];
		            String RESERVEDSTATUS = s2[3];
		            String GUESTNO = s2[4];
		           
					int reservedNo = rs.getInt(1)+1;
					ps.setInt(1, reservedNo);
					ps.setString(2, ROOMNO);
					ps.setString(3, CHECKIN);
					ps.setString(4, CHECKOUT);
					ps.setString(5, RESERVEDDATE);
					ps.setString(6, MEMBERID);
					ps.setString(7, REQUIREMENT);
					ps.setString(8, BREAKFAST_);
					ps.setString(9, RESERVEDSTATUS);
					ps.setString(10, GUESTNO);
					ps.executeUpdate();
					System.out.println("예약 완료"+" 예약 번호: "+reservedNo+" 예약 객실: "+ROOMNO+" 체크인: "+CHECKIN+" 체크아웃: "+CHECKOUT+" 예약 날짜: "+RESERVEDDATE+
							" 멤버아이디: "+MEMBERID+" 요구사항: "+REQUIREMENT+" 조식여부: "+BREAKFAST_+" 상테 :"+RESERVEDSTATUS+" 인원: "+GUESTNO);
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
