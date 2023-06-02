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
	
	//회원관리 화면 : member 테이블의 모든 레코드를 각각 Member 객체에 저장한 후 객체 배열 반환
	public Room[] getAllRoom() {
		Room[] r_array;
		int rowCnt=0;
		int index=0;
		String mem = "SELECT * FROM DB2023_room";
		String memCnt = "SELECT COUNT(*) FROM DB2023_room";
		try {
			con=myConnection.getConnection();
			stmt=con.createStatement();
			
			//member 테이블의 레코드 개수 크기 만큼의 객체배열 생성
			ResultSet rsCnt=stmt.executeQuery(memCnt);
			
			if(rsCnt.next()) {
				rowCnt =rsCnt.getInt(1);
			}
			r_array=new Room[rowCnt];
			for (int i = 0; i < r_array.length; ++i)
				r_array[i] = new Room();
			
			rsCnt.close();     //자원반납
			
			//각 객체에 값 저장
			rs=stmt.executeQuery(mem);
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
	//회원관리 화면 : member 테이블의 모든 레코드를 각각 Member 객체에 저장한 후 객체 배열 반환
		public Room[] getRefreshRoom(String checkin, String checkout) {
			System.out.println(checkin+checkout);
			Room[] r_array;
			int rowCnt=11;
			int index=0;
			String mem = "(SELECT db2023_room.RoomNo,BedType,Capacity,Price,RoomType,RoomSize,RoomName,NonSmoking,Parking FROM db2023_room LEFT OUTER JOIN db2023_reservation ON db2023_room.roomNo=db2023_reservation.roomNo WHERE db2023_reservation.checkIn!=? AND db2023_reservation.checkOut!=?) UNION ALL (SELECT db2023_room.RoomNo,BedType,Capacity,Price,RoomType,RoomSize,RoomName,NonSmoking,Parking FROM db2023_room LEFT OUTER JOIN db2023_reservation ON db2023_room.roomNo=db2023_reservation.roomNo WHERE db2023_reservation.roomNo IS NULL)";
			
			try {
				con=myConnection.getConnection();
				ps = con.prepareStatement(mem);
			    ps.setString(1, checkin);
			    ps.setString(2,checkout);
			    rs = ps.executeQuery();
				
				
				//member 테이블의 레코드 개수 크기 만큼의 객체배열 생성
			    
				
				
				r_array=new Room[rowCnt];
				for (int i = 0; i < r_array.length; ++i)
					r_array[i] = new Room();
				
				
				//각 객체에 값 저장
				//rs=stmt.executeQuery(mem);
				while(rs.next()) {
					System.out.println("재정렬 성공");
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
				myConnection.close(rs, null, ps, con);
			}
			
			r_array=new Room[rowCnt];
			return r_array;
		}
		
	
}

