package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ReservedRoom;
import myConnection.MY_Connection;

public class ReservedRoomManager {

	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ReservedRoomManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ReservedRoom getByReservedNo(int reservedNo) {
		String SQL = "SELECT * FROM DB2023_reservedRoom WHERE reservedNo=?";
		try {
			con=myConnection.getConnection();
			ps=con.prepareStatement(SQL);
			ps.setInt(1, reservedNo);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ReservedRoom rR = new ReservedRoom(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getBoolean(14),rs.getBoolean(15));
				return rR;
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			myConnection.close(rs, null, ps, con);
		}
		ReservedRoom empty = new ReservedRoom();
		return empty;
	}
	
}
