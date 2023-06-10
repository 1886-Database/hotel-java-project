package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import myConnection.MY_Connection;
import view.form.Form_Reservation;
import view.form.Form_RoomReservation;

import model.Employee;
import model.Reservation;
import myConnection.MY_Connection;

//예약 관리
public class ReservationManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	private Form_Reservation form3;
	private Form_RoomReservation rr;

	// 기본 생성자 : 커넥션 객체 생성
	public ReservationManager() {
		try {
			myConnection = new MY_Connection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 입력받은 정보를 reservation 테이블에 insert
	public int reservation(String roomno, String checkin, String checkout, String reserveddate, String requirement,
			String breakfast, String reservedstatus, String guestno) {
		String SQL = "INSERT INTO DB2023_reservation VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select max(reservedNo) from DB2023_reservation");
			while (rs.next()) {

				String ROOMNO = roomno;
				String CHECKIN = checkin;
				String CHECKOUT = checkout;
				String RESERVEDDATE = reserveddate;
				String MEMBERID = "1";
				String REQUIREMENT = requirement;
				String BREAKFAST_ = breakfast;
				String RESERVEDSTATUS = reservedstatus;
				String GUESTNO = guestno;

				int reservedNo = rs.getInt(1) + 1;
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
				System.out.println("예약 완료" + " 예약 번호: " + reservedNo + " 예약 객실: " + ROOMNO + " 체크인: " + CHECKIN
						+ " 체크아웃: " + CHECKOUT + " 예약 날짜: " + RESERVEDDATE + " 멤버아이디: " + MEMBERID + " 요구사항: "
						+ REQUIREMENT + " 조식여부: " + BREAKFAST_ + " 상테 :" + RESERVEDSTATUS + " 인원: " + GUESTNO);
				return 1;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			myConnection.close(rs, stmt, ps, con);
		}
		return -1; // 데이터베이스 오류
	}

	public Reservation[] getReservationView() {
		Reservation[] r_array;
		int rowCnt = 0;
		int index = 0;
		String res = "CREATE OR REPLACE VIEW DB2023_MemberReservationView AS "
				+ "SELECT member.name, member.phone, reservation.reservedNo, reservation.roomNo, reservation.checkIn, reservation.checkOut, "
				+ "reservation.reservedDate, reservation.memberID, reservation.reservedStatus, reservation.requirement "
				+ "FROM DB2023_member AS member "
				+ "JOIN DB2023_reservation AS reservation ON member.memberID = reservation.memberID;";
		String resCnt = "SELECT COUNT(*) FROM DB2023_reservation";
		try {
			con = myConnection.getConnection();
			stmt = con.createStatement();

			// 뷰가 이미 존재하는지 확인
			String dropView = "DROP VIEW IF EXISTS DB2023_MemberReservationView";
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
					+ "FROM DB2023_MemberReservationView";
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

	// 예약 조회 화면 : 멤버의 로그인 ID 를 받은 후 해당 멤버의 예약내역 리스트를 return
	public Reservation[] getMyReserv(String loginID) {
		Reservation[] r_array;
		int rowCnt = 0;
		int index = 0;
		String reserv = "SELECT * FROM DB2023_reservation WHERE memberID in (select memberID from DB2023_member where loginID=?)";
		try {
			con = myConnection.getConnection();

			ps = con.prepareStatement(reserv, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, loginID);

			// member 테이블의 레코드 개수 크기 만큼의 객체배열 생성

			rs = ps.executeQuery();

			while (rs.next()) {
				rowCnt++;
			}

			r_array = new Reservation[rowCnt];

			for (int i = 0; i < r_array.length; ++i)
				r_array[i] = new Reservation();

			rs.beforeFirst();

			// 각 객체에 값 저장

			while (rs.next()) {
				r_array[index].setReservedNo(rs.getInt(1));
				r_array[index].setRoomNo(rs.getInt(2));
				r_array[index].setCheckIn(rs.getString(3));
				r_array[index].setCheckOut(rs.getString(4));
				r_array[index].setReservedDate(rs.getString(5));
				r_array[index].setMemberID(rs.getInt(6));
				r_array[index].setRequirement(rs.getString(7));
				r_array[index].setBreakfast(rs.getString(8));
				r_array[index].setReservedStatus(rs.getString(9));
				r_array[index].setGusetNo(rs.getInt(10));

				index++;
			}

			return r_array;

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			myConnection.close(rs, null, ps, con);
		}

		r_array = new Reservation[rowCnt];
		return r_array;
	}
	
	//예약조회 : 예약 상태를 '취소'로 변경
	public int cancel(int reservedNo) {
		String SQL = "UPDATE DB2023_reservation SET reservedStatus = '취소' WHERE reservedNo=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setInt(1, reservedNo);
			ps.executeUpdate();
			return 1; //예약 취소 완료
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			myConnection.close(null, null, ps, con);
		}
		return -1; //데이터베이스 오류
	}

	public int edit(int reservedNo, String reservedStatus) {
		String SQL = "UPDATE DB2023_reservation SET reservedStatus=? WHERE reservedNo=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, reservedStatus);
			ps.setInt(2, reservedNo);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myConnection.close(null, null, ps, con);
		}
		return -1;

	}
}
