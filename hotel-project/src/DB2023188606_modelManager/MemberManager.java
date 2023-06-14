package DB2023188606_modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import DB2023188606_model.Member;
import DB2023188606_myConnection.MY_Connection;

public class MemberManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	// 기본 생성자 : 커넥션 객체 생성
	public MemberManager() {
		try {
			myConnection = new MY_Connection();
		} catch (Exception e) {
			
		}
	}

	// 로그인 화면 : 입력받은 loginID와 pw 와 일치하는 정보가 member 테이블에 존재하는지 확인 후 존재하면 return 1
	/**
	 *  입력받은 loginID와 pw 와 일치하는 정보가 member 테이블에 존재하는지 확인하는 메소드
	 * 
	 * @return member 로그인 정보 존재여부
	 */
	public int login(String id, String pw) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=? and password=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();

			if (rs.next()) {
				return 1; // 로그인 성공
			}
			return 0; // 로그인 실패 (잘못된 id/pw)
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		return -1; // 데이터베이스 오류
	}

	// 회원가입 화면 ID 중복 검사 기능 : 인자로 받은 loginID 값이 member 테이블 loginID 필드에 이미 존재하는 속성 값인지
	// 확인 후 존재하면 return 0.
	// 존재하지 않으면 return 1
	/**
	 * 인자로 받은 loginID 값이 member 테이블 loginID 필드에 이미 존재하는 속성 값인지 확인하는 메소드
	 * @return member login id 중복 여부
	 */
	public int checkID(String id) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return 0; // 중복 ID 존재
			}
			return 1; // 중복 ID 존재하지 않음
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		return -1; // 데이터베이스 오류
	}

	// 회원가입 화면 : 회원가입 화면에서 입력받은 정보를 인자로 받아서 member 테이블에 insert.
	// 이때, memberID 와 grade 는 사용자에게서 입력받지 않고 프로그램에서 계산한 값(혹은 default 값)으로 처리
	/**
	 * 회원가입 화면에서 입력받은 정보를 인자로 받아서 member 테이블에 insert하는 메소드
	 */
	public int signUp(String name, String loginID, String password, String phoneNum, String birthDate) {
		String SQL = "INSERT INTO DB2023_member VALUES(?,?,?,?,?,?,?)";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select max(memberID) from DB2023_member");
			while (rs.next()) {
				int memberID = rs.getInt(1) + 1;
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
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, stmt, ps, con);
		}
		return -1; // 데이터베이스 오류
	}

	// 마이페이지 화면 패스워드 변경 기능 : 인자로 받은 loginID 와 일치하는 레코드의 password 속성 값을 인자로 받은 pw 값으로
	// 변경
	/**
	 *  인자로 받은 loginID 와 일치하는 레코드의 password 속성 값을 인자로 받은 pw 값으로 변경하는 메소드
	 */
	public int passwordChange(String loginID, String password) {
		String SQL = "UPDATE DB2023_member SET password=? WHERE loginID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, password);
			ps.setString(2, loginID);
			ps.executeUpdate();
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(null, null, ps, con);
		}
		return -1;
	}

	// 마이페이지 화면 : 인자로 받은 loginID 와 일치하는 레코드를 select 한 후 해당 레코드의 정보를 모두 Member 객체에 저장
	// -> Member 객체 return
	/**
	 *인자로 받은 loginID 와 일치하는 레코드를 select 한 후 해당 레코드의 정보를 모두 Member 객체에 저장하는 메소드
	 *@return member 객체
	 */
	public Member getByLoginID(String loginID) {
		String SQL = "SELECT * FROM DB2023_member WHERE loginID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, loginID);
			rs = ps.executeQuery();
			while (rs.next()) {
				Member member = new Member(rs.getInt(1), loginID, rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				return member;
			}
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		Member member = new Member();
		return member;
	}
	
	//Member Message 화면 : 인자로 받은 member ID와 일치하는 레코드에서 LoginID를 찾아 반환.
	/**
	 *인자로 받은 member ID와 일치하는 레코드에서 LoginID를 찾아 반환하는 메소드입니다.
	 *@return login ID
	 */
	public String getLoginIDbyMemberID(int memberID) {
		String SQL = "SELECT loginID FROM DB2023_member WHERE memberID=?";
		String loginID = "";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setInt(1, memberID);
			rs = ps.executeQuery();

			if (rs.next()) { // 결과 집합에 데이터가 있는지 확인
				loginID = rs.getString(1);
			}
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		return loginID;
	}
	//Member Message 화면 : 인자로 받은 login ID와 일치하는 레코드에서 member ID를 찾아 반환.
		/**
		 *인자로 받은 loginID 와 일치하는 레코드를 select 한 후 해당 레코드의 정보를 모두 Member 객체에 저장하는 메소드입니다.
		 *@return membe 객체
		 */
	public int getMemberIDbyLoginID(String LoginID) {
		String SQL = "SELECT memberID FROM DB2023_member WHERE loginID=?";
		int memberID = 0;
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, LoginID);
			rs = ps.executeQuery();

			if (rs.next()) { // 결과 집합에 데이터가 있는지 확인
				memberID = rs.getInt(1);
			}
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		return memberID;
	}

	// 회원 관리 화면 : member 테이블의 모든 레코드를 각각 Member 객체에 저장한 후 Member 객체들이 담긴 객체 배열
	// return member 객체배열
	/**
	 *member 테이블의 모든 레코드를 각각 Member 객체에 저장한 후 Member 객체들이 담긴 객체 배열을 반환하는 메소드입니다.
	 *@return member 객체
	 */
	public Member[] getAllMember() {
		Member[] m_array;
		int rowCnt = 0;
		int index = 0;
		String mem = "SELECT * FROM DB2023_member";
		String memCnt = "SELECT COUNT(*) FROM DB2023_member";
		try {
			con = myConnection.getConnection();
			stmt = con.createStatement();

			// member 테이블의 레코드 개수 크기 만큼의 객체배열 생성
			ResultSet rsCnt = stmt.executeQuery(memCnt);

			if (rsCnt.next()) {
				rowCnt = rsCnt.getInt(1);
			}
			m_array = new Member[rowCnt];
			for (int i = 0; i < m_array.length; ++i)
				m_array[i] = new Member();

			rsCnt.close(); // 자원반납

			// 각 객체에 값 저장
			rs = stmt.executeQuery(mem);
			while (rs.next()) {
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

		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, stmt, null, con);
		}

		m_array = new Member[rowCnt];
		return m_array;
	}

	// 마이페이지 화면 회원 탈퇴 기능 + 회원관리 화면 삭제 기능 : 인자로 받은 memberID 와 일치하는 레코드를 member 테이블에서
	// 삭제.
	// 이때, memberID를 참조하는 reservation 테이블과 message 테이블의 memberID 속성 값을 각각 null 로
	// 변경해준다.
	/**
	 *인자로 받은 memberID 와 일치하는 레코드를 member 테이블에서 삭제하는 메소드입니다.
	 */
	public int delete(int memberID) {
		String query0 = "UPDATE DB2023_message SET memberID = null WHERE memberID=?";
		String query1 = "DELETE FROM DB2023_reservation WHERE memberID=?";
		String query2 = "DELETE FROM DB2023_member WHERE memberID=?";
		try {
			con = myConnection.getConnection();
			con.setAutoCommit(false); /************************* 트랜잭션 시작 ***********************/
			ps = con.prepareStatement(query0);
			ps.setInt(1, memberID);
			ps.executeUpdate(); // 삭제하려는 회원이 과거 보냈던 메시지 데이터의 memberID 값을 null 로 변경
			ps = con.prepareStatement(query1);
			ps.setInt(1, memberID);
			ps.executeUpdate(); // 삭제하려는 회원의 과거 신청했던 예약데이터도 삭제 
			ps = con.prepareStatement(query2);
			ps.setInt(1, memberID);
			ps.executeUpdate(); // 회원 데이터를 member 테이블에서 삭제
			con.commit(); /****** 커밋 ******/
			con.setAutoCommit(true); /************************* 트랜잭션 종료 **************************/
			return 1;
		} catch (SQLException se) {
			
			try {
				if (con != null) {
					con.rollback(); /****** 롤백 ******/
					con.setAutoCommit(true);
				}
			} catch (SQLException se2) {
				
			}
		} finally {
			myConnection.close(null, null, ps, con);
		}

		return -1;
	}
}
