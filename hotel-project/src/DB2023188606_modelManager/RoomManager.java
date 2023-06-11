package DB2023188606_modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import DB2023188606_model.Room;
import DB2023188606_myConnection.MY_Connection;

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
			
		}
	}
	
	//룸리스트 화면 : room 테이블의 모든 레코드를 각각 room 객체에 저장한 후 객체 배열 반환
	/**
	 * room 테이블의 모든 레코드를 각각 room 객체에 저장한 후 객체 배열 반환하는 메소드입니다.
	 * @return room 객체 배열 반환
	 */
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
			
		}finally {
			myConnection.close(rs, stmt, null, con);
		}
		
		r_array=new Room[rowCnt];
		return r_array;
	}
	
	//룸리스트 재정렬 화면 : 필터링된 room 테이블의 레코드 반환
	/**
	 * checkin, checkout 날짜 인수를 받아 필터링된 room 테이블의 레코드를 반환하는 메소드입니다.
	 * @return room 객체 배열 반환
	 */
		public Room[] getRefreshRoom(String checkin, String checkout) {
			Room[] r_array;
			int rowCnt=0;
			int index=0;
			String room = "select roomNo,bedType,capacity,price,roomType,roomSize,roomName,nonSmoking,parking "
					+ "from DB2023_room where roomNo not in "
					+ "(select roomNo from DB2023_reservedRoom where ? between checkIn and checkOut or ? between checkIn and checkOut "
					+ "or checkIn between ? and ? or checkOut between ? and ?)";
			
			try {
				con=myConnection.getConnection();
				ps = con.prepareStatement(room, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			    ps.setString(1, checkin);
			    ps.setString(2, checkout);
			    ps.setString(3, checkin);
			    ps.setString(4, checkout);
			    ps.setString(5, checkin);
			    ps.setString(6, checkout);
			    
			    rs = ps.executeQuery();
				
			    //rs의 레코드 개수 크기 만큼의 객체 배열 생성
			    
			    while (rs.next()) {
					rowCnt++;
				}
				
				r_array=new Room[rowCnt];
				
				for (int i = 0; i < r_array.length; ++i)
					r_array[i] = new Room();
				
				rs.beforeFirst();
				
				//각 객체에 값 저장
				
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
				
			}finally {
				myConnection.close(rs, null, ps, con);
			}
			
			r_array=new Room[rowCnt];
			return r_array;
		}
		
	
}
