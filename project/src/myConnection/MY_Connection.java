package myConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MY_Connection {
	//DB 연결을 위한 connection 객체를 반환하는 메소드
		public static Connection getConnection() {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2023188606","DB2023188606","DB2023188606");
				System.out.println("데이터베이스 연결 성공");
				return con;
			}
			catch(SQLException e){
				System.out.println("데이터베이스 연결 실패");
			}
			return null;	
		}
		//자원 반납을 위한 메소드
		public static void close(ResultSet rs, Statement st, PreparedStatement ps, Connection con) {
			try {
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		public static void main(String[] args) {
			getConnection();
		}
	
}