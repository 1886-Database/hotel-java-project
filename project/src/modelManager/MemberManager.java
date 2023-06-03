package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import model.Member;
import myConnection.MY_Connection;

public class MemberManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	//기본 생성자 : 커넥션 객체 생성
	public MemberManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//로그인 화면 : 입력받은 id와 pw 와 일치하는 정보가 member 테이블에 존재하는지 확인
	public int login(String id, String pw) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=? and password=?";
		try {
			con=myConnection.getConnection();
		    ps = con.prepareStatement(SQL);
		    ps.setString(1, id);
		    ps.setString(2,pw);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) { 
		    	System.out.println("멤버 로그인 성공");
		    	return 1; //로그인 성공
		    }
		    return 0; //로그인 실패 (잘못된 id/pw)
		}catch(SQLException se){
		    se.printStackTrace();
		}finally {
			myConnection.close(rs,null,ps,con);
		}
		return -1; //데이터베이스 오류 
	 }
	
	//회원가입 화면 : ID 중복 검사
	public int checkID(String id) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=?";
		System.out.println("checkID");
		try {
			con=myConnection.getConnection();
		    ps = con.prepareStatement(SQL);
		    ps.setString(1, id);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) { 
		    	System.out.println("중복 ID 존재");
		    	return 0; //중복 ID 존재
		    }
		    return 1; //중복 ID 존재하지 않음
		}catch(SQLException se){
		    se.printStackTrace();
		}finally {
			myConnection.close(rs,null,ps,con);
		}
		return -1; //데이터베이스 오류 
	}
	
	//회원가입 화면 : 입력받은 정보를 member 테이블에 insert
	public int signUp(String name,String loginID,String password,String phoneNum,String birthDate){
		String SQL = "INSERT INTO DB2023_member VALUES(?,?,?,?,?,?,?)";
		try {
			con=myConnection.getConnection();
			ps=con.prepareStatement(SQL);
			stmt=con.createStatement();
			rs=stmt.executeQuery("select max(memberID) from DB2023_member");
			while(rs.next()) {
				int memberID = rs.getInt(1)+1;
				ps.setInt(1, memberID);
				ps.setString(2, loginID);
				ps.setString(3, name);
				ps.setString(4, password);
				ps.setString(5, phoneNum);
				ps.setString(6, birthDate);
				ps.setString(7, "bronze");
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
	
	//마이페이지 화면 : 인자로 받은 id 에 해당하는 레코드의 비밀번호를 인자로 받은 pw 값으로 변경
	public int passwordChange(String loginID,String password) {
		String SQL="UPDATE DB2023_member SET password=? WHERE loginID=?";
		try {
			con=myConnection.getConnection();
			ps=con.prepareStatement(SQL);
			ps.setString(1, password);
			ps.setString(2, loginID);
			ps.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			myConnection.close(null, null, ps, con);
		}
		return -1;
	}
	
	//마이페이지 화면 : 인자로 받은 id 에 해당하는 레코드를 Member 객체에 저장한 후 Member 객체 반환
	public Member getByLoginID(String loginID) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=?";
		try {
			con=myConnection.getConnection();
			ps=con.prepareStatement(SQL);
			ps.setString(1, loginID);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member(rs.getInt(1),loginID,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				return member;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			myConnection.close(rs, null, ps, con);
		}
		Member member = new Member();
		return member;
	}
	
	//회원관리 화면 : member 테이블의 모든 레코드를 각각 Member 객체에 저장한 후 객체 배열 반환
	public Member[] getAllMember() {
		Member[] m_array;
		int rowCnt=0;
		int index=0;
		String mem = "SELECT * FROM DB2023_member";
		String memCnt = "SELECT COUNT(*) FROM DB2023_member";
		try {
			con=myConnection.getConnection();
			stmt=con.createStatement();
			
			//member 테이블의 레코드 개수 크기 만큼의 객체배열 생성
			ResultSet rsCnt=stmt.executeQuery(memCnt);
			
			if(rsCnt.next()) {
				rowCnt =rsCnt.getInt(1);
			}
			m_array=new Member[rowCnt];
			for (int i = 0; i < m_array.length; ++i)
				m_array[i] = new Member();
			
			rsCnt.close();     //자원반납
			
			//각 객체에 값 저장
			rs=stmt.executeQuery(mem);
			while(rs.next()) {
				m_array[index].setMemberID(rs.getInt(1));
				m_array[index].setLoginID(rs.getString(2));
				m_array[index].setName(rs.getString(3));
				m_array[index].setPassword(rs.getString(4));
				m_array[index].setPhone(rs.getString(5));
				m_array[index].setBirthDate(rs.getString(6));
				m_array[index].setGrade(rs.getString(7));
				index++;
			}
		
			return m_array;
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			myConnection.close(rs, stmt, null, con);
		}
		
		m_array=new Member[rowCnt];
		return m_array;
	}
	
	//삭제 메소드 
	public int delete(int memberID) {
		String query1 = "UPDATE DB2023_reservation SET memberID=null,reservedStatus='거절' WHERE memberID=?";
		String query2 = "DELETE FROM DB2023_member WHERE memberID=?";
		try {
			con=myConnection.getConnection();
			con.setAutoCommit(false);  /**트랜잭션 시작**/
			ps=con.prepareStatement(query1);
			ps.setInt(1, memberID);
			ps.executeUpdate(); //삭제하려는 회원의 예약신청 정보 수정 (예약한 회원의 id 는 null, 예약 상태는 '거절'이 되도록)
			ps=con.prepareStatement(query2);
			ps.setInt(1, memberID);
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
}
