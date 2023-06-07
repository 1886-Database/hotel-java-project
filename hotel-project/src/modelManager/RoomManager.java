package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import model.Room;
import myConnection.MY_Connection;

public class RoomManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	//기본 생성자 : 커넥션 객체 생성
	public RoomManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//룸리스트 화면 : room 테이블의 모든 레코드를 각각 room 객체에 저장한 후 객체 배열 반환
	public Room[] getAllRoom() {
		Room[] r_array;
		int rowCnt=0;
		int index=0;
		String room = "SELECT * FROM DB2023_room";
		String roomCnt = "SELECT COUNT(*) FROM DB2023_room";
		try {
			con=myConnection.getConnection();
			stmt=con.createStatement();
			
			//room 테이블의 레코드 개수 크기 만큼의 객체배열 생성
			ResultSet rsCnt=stmt.executeQuery(roomCnt);
			
			if(rsCnt.next()) {
				rowCnt =rsCnt.getInt(1);
			}
			r_array=new Room[rowCnt];
			for (int i = 0; i < r_array.length; ++i)
				r_array[i] = new Room();
			
			rsCnt.close();     //자원반납
			
			//각 객체에 값 저장
			rs=stmt.executeQuery(room);
			while(rs.next()) {
				r_array[index].setRoomNo(rs.getInt(1));
				r_array[index].setBedType(rs.getString(2));
				r_array[index].setCapacity(rs.getInt(3));
				r_array[index].setPrice(rs.getInt(4));
				r_array[index].setRoomType(rs.getString(5));
				r_array[index].setRoomSize(rs.getInt(6));
				r_array[index].setRoomName(rs.getString(7));
				r_array[index].setNonSmoking(rs.getBoolean(8));
				r_array[index].setParking(rs.getBoolean(9));
				index++;
			}
		
			return r_array;
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			myConnection.close(rs, stmt, null, con);
		}
		
		r_array=new Room[rowCnt];
		return r_array;
	}
	//룸리스트 재정렬 화면 : 필터링된 room 테이블의 레코드 반환
		public Room[] getRefreshRoom(String checkin, String checkout) {
			System.out.println(checkin+checkout);
			Room[] r_array;
			int rowCnt=11;
			int index=0;
			String room = "SELECT db2023_room.roomNo,bedType,capacity,price,roomType,roomSize,roomName,nonSmoking,parking \r\n"
					+ "FROM db2023_room JOIN db2023_reservation ON db2023_room.roomNo=db2023_reservation.roomNo\r\n"
					+ "WHERE db2023_room.roomNo !=\r\n"
					+ "ALL (SELECT db2023_room.roomNo\r\n"
					+ "FROM db2023_room JOIN db2023_reservation ON db2023_room.roomNo=db2023_reservation.roomNo\r\n"
					+ "WHERE ((? between checkIn AND checkOut and ? > checkOut)\r\n"
					+ "OR (? < checkIn and ? between checkIn and checkOut)\r\n"
					+ "OR (? between checkIn and checkOut and ? between checkIn and checkOut)\r\n"
					+ "OR (? < checkIn and ? > checkOut)))\r\n"
					+ "UNION ALL \r\n"
					+ "(SELECT db2023_room.roomNo,bedType,capacity,price,roomType,roomSize,roomName,nonSmoking,parking FROM db2023_room LEFT OUTER JOIN db2023_reservation ON db2023_room.roomNo=db2023_reservation.roomNo WHERE db2023_reservation.roomNo IS NULL)";
			
			try {
				con=myConnection.getConnection();
				ps = con.prepareStatement(room);
			    ps.setString(1, checkin);
			    ps.setString(2,checkout);
			    ps.setString(3, checkin);
			    ps.setString(4,checkout);
			    ps.setString(5, checkin);
			    ps.setString(6,checkout);
			    ps.setString(7, checkin);
			    ps.setString(8,checkout);
			    rs = ps.executeQuery();
				
				
				r_array=new Room[rowCnt];
				for (int i = 0; i < r_array.length; ++i)
					r_array[i] = new Room();
				
				
				while(rs.next()) {
					r_array[index].setRoomNo(rs.getInt(1));
					r_array[index].setBedType(rs.getString(2));
					r_array[index].setCapacity(rs.getInt(3));
					r_array[index].setPrice(rs.getInt(4));
					r_array[index].setRoomType(rs.getString(5));
					r_array[index].setRoomSize(rs.getInt(6));
					r_array[index].setRoomName(rs.getString(7));
					r_array[index].setNonSmoking(rs.getBoolean(8));
					r_array[index].setParking(rs.getBoolean(9));
					index++;
				}
				System.out.println("재정렬 성공");
			
				return r_array;
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				myConnection.close(rs, null, ps, con);
			}
			
			r_array=new Room[rowCnt];
			return r_array;
		}
		//삭제 메소드 
		public int delete(int roomNo) {
			String query1 = "UPDATE DB2023_room SET roomNo=null WHERE roomNo=?";
			String query2 = "DELETE FROM DB2023_room WHERE roomNo=?";
			try {
				con=myConnection.getConnection();
				con.setAutoCommit(false);  /**트랜잭션 시작**/
				ps=con.prepareStatement(query1);
				ps.setInt(1, roomNo);
				ps.executeUpdate(); //삭제하려는 회원의 예약신청 정보 수정 (예약한 회원의 id 는 null, 예약 상태는 '거절'이 되도록)
				ps=con.prepareStatement(query2);
				ps.setInt(1, roomNo);
				ps.executeUpdate(); //회원 정보 삭제
				con.commit();             
				con.setAutoCommit(true);  /**트랜잭션 종료**/
				return 1;
			}catch(SQLException se) {
				System.out.println("Roll back data...");
				se.printStackTrace();
				try {
					if(con!=null)
						con.rollback();
				}catch(SQLException se2) {
					se2.printStackTrace();
				}
			}finally {
				myConnection.close(null, null, ps, con);
			}
			
			return -1;
		}
		
		public int add(String roomno,String bedtype, String capacity, String price, String roomtype,String roomsize,String roomname) {
			String SQL = "INSERT INTO DB2023_room VALUES(?,?,?,?,?,?,?,1,1)";
			try {
				con=myConnection.getConnection();
				ps=con.prepareStatement(SQL);
				stmt=con.createStatement();
				while(rs.next()) {
					ps.setString(1, roomno);
					ps.setString(2,bedtype);
					ps.setString(3,capacity);
					ps.setString(4, price);
					ps.setString(5, roomtype);
					ps.setString(6, roomsize);
					ps.setString(7, roomname);
					ps.executeUpdate();
					return 1;   //성공
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				myConnection.close(null,stmt,ps,con);
			}
			return -1; //데이터베이스 오류
		}
		
		public int edit(String roomno,String bedtype, String capacity, String price, String roomtype,String roomsize,String roomname) {
			String SQL = "UPDATE DB2023_room SET roomNo=?, bedType=?, capacity=?, price=?, roomType=?, roomSize=?, roomName=?, nonSmoking=1, parking=1 WHERE roomNo=?";
			try {
				con=myConnection.getConnection();
				ps=con.prepareStatement(SQL);
				ps.setString(1, roomno);
				ps.setString(2,bedtype);
				ps.setString(3,capacity);
				ps.setString(4, price);
				ps.setString(5, roomtype);
				ps.setString(6, roomsize);
				ps.setString(7, roomname);
				ps.executeUpdate();
				return 1;
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				myConnection.close(null, stmt, null, con);
			}
			return -1;
		}
	
}

