/**
 *employee 객체를 사용하는 Method를 관리하는 class입니다.
 */
package DB2023188606_modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB2023188606_model.Employee;
import DB2023188606_myConnection.MY_Connection;

public class EmployeeManager {

	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	// 기본 생성자 : 커넥션 객체 생성
	public EmployeeManager() {
		try {
			myConnection = new MY_Connection();
		} catch (Exception e) {
			
		}
	}

	// 로그인 화면 : 입력받은 loginID와 pw 와 일치하는 정보가 employee 테이블에 존재하는지 확인 후 존재하면 return 1
	/**
	 *입력받은 loginID와 pw 와 일치하는 정보가 employee 테이블에 존재하는지 확인 후 존재하는 지 확인하는 메소드입니다.
	 *@return 로그인 정보 존재 여부(1,0,-1)
	 */
	public int login(String id, String pw) {
		String SQL = "SELECT * FROM DB2023_employee WHERE loginID=? and password=?";
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
		} catch (SQLException e) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		return -1; // 데이터베이스 오류
	}

	// 직원 관리 화면 (직원을 추가할 때 id 중복검사) : 인자로 받은 loginID 값이 member 테이블 loginID 필드에 이미
	// 존재하는 속성 값인지
	// 확인 후 존재하면 return 0.
	// 존재하지 않으면 return 1
	
	/**
	 * 인자로 받은 loginID 값이 member 테이블 loginID 필드에 이미 존재하는 속성 값인지 확인하는 메소드입니다.
	 *@return 로그인 정보 존재 여부(0,1)
	 */
	public int checkID(String id) {
		String SQL = "SELECT * FROM DB2023_employee WHERE loginID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return 0; // 중복 ID 존재
			}
			return 1; // 중복 ID 존재하지 않음
		} catch (SQLException e) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		return -1; // 데이터베이스 오류
	}

	// 마이페이지 화면 패스워드 변경 기능 : 인자로 받은 loginID 와 일치하는 레코드의 password 속성 값을 인자로 받은 pw 값으로
	// 변경
	
	/**
	 * 인자로 받은 loginID 와 일치하는 레코드의 password 속성 값을 인자로 받은 pw 값으로 변경하는 메소드입니다.
	 */
	public int passwordChange(String loginID, String password) {
		String SQL = "UPDATE DB2023_employee SET password=? WHERE loginID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, password);
			ps.setString(2, loginID);
			ps.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			myConnection.close(null, null, ps, con);
		}
		return -1;
	}

	// 마이페이지 화면 : 인자로 받은 loginID 와 일치하는 레코드를 select 한 후 해당 레코드의 정보를 모두 Employee 객체에
	// 저장
	// -> Employee 객체 return
	
	/**
	 * 인자로 받은 loginID 와 일치하는 레코드를 select 한 후 해당 레코드의 정보를 모두 Employee 객체에 저장하는 메소드입니다.
	 * @return employee 객체
	 */
	public Employee getByLoginID(String loginID) {
		String SQL = "SELECT * FROM DB2023_employee WHERE loginID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, loginID);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), loginID, rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
				return employee;
			}
		} catch (SQLException e) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		Employee employee = new Employee();
		return employee;
	}

	// 직원 관리 화면 : Employee 테이블의 모든 레코드를 각각 Employee 객체에 저장한 후 Employee 객체들이 담긴 객체 배열
	// return 
	/**
	 * Employee 테이블의 모든 레코드를 각각 Employee 객체에 저장한 후 Employee 객체들이 담긴 객체 배열을 반환하는 메소드입니다.
	 * @return employee 객체배열
	 */
	public Employee[] getAllEmployee() {
		Employee[] e_array;
		int rowCnt = 0;
		int index = 0;
		String emp = "SELECT * FROM DB2023_employee";
		String empCnt = "SELECT COUNT(*) FROM DB2023_employee";
		try {
			con = myConnection.getConnection();
			stmt = con.createStatement();

			// member 테이블의 레코드 개수 크기 만큼의 객체배열 생성
			ResultSet rsCnt = stmt.executeQuery(empCnt);

			if (rsCnt.next()) {
				rowCnt = rsCnt.getInt(1);
			}
			e_array = new Employee[rowCnt];
			for (int i = 0; i < e_array.length; ++i)
				e_array[i] = new Employee();

			rsCnt.close(); // 자원반납

			// 각 객체에 값 저장
			rs = stmt.executeQuery(emp);
			while (rs.next()) {
				e_array[index].setEmployeeID(rs.getInt(1));
				e_array[index].setLoginID(rs.getString(2));
				e_array[index].setName(rs.getString(3));
				e_array[index].setPassword(rs.getString(4));
				e_array[index].setPhone(rs.getString(5));
				e_array[index].setBirthDate(rs.getString(6));
				e_array[index].setDepartment(rs.getString(7));
				index++;
			}

			return e_array;

		} catch (SQLException e) {
			
		} finally {
			myConnection.close(rs, stmt, null, con);
		}

		e_array = new Employee[rowCnt];
		return e_array;
	}

	// 직원관리 화면 : 인자로 받은 employeeID 와 일치하는 레코드를 employee 테이블에서 삭제
	/**
	 *  인자로 받은 employeeID 와 일치하는 레코드를 employee 테이블에서 삭제하는 메소드입니다.
	 */
	public int delete(int id) {
		String SQL = "DELETE FROM DB2023_employee WHERE employeeID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			
		} finally {
			myConnection.close(null, stmt, null, con);
		}
		return -1;
	}

	// 직원관리 화면 : 직원 관리 화면에서 입력받은 정보를 인자로 받아서 employee 테이블에 insert
	// 이때, employeeID 는 사용자에게서 입력받지 않고 프로그램이 계산한 값으로 처리하고, password 는 1234 로 초기화해준다.
	/**
	 *   직원 관리 화면에서 입력받은 정보를 인자로 받아서 employee 테이블에 insert하는 메소드입니다.
	 */
	public int add(String loginID, String name, String phone, String birthDate, String dept) {
		String SQL = "INSERT INTO DB2023_employee VALUES(?,?,?,?,?,?,?)";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select max(employeeID) from DB2023_employee");
			while (rs.next()) {
				int employeeID = rs.getInt(1) + 1;
				ps.setInt(1, employeeID);
				ps.setString(2, loginID);
				ps.setString(3, name);
				ps.setString(4, "1234");
				ps.setString(5, phone);
				ps.setString(6, birthDate);
				ps.setString(7, dept);
				ps.executeUpdate();
				return 1; // 성공
			}
		} catch (SQLException e) {
			
		} finally {
			myConnection.close(rs, stmt, ps, con);
		}
		return -1; // 데이터베이스 오류
	}

	// 직원관리 화면 : 직원관리 화면에서 사용자에게서 입력받은 정보들과 특정 직원의 employeeID를 인자로 받은 후, 해당
	// employeeID 를 가진 레코드의 다른 속성 값들을 변경
	/**
	 * 직원관리 화면에서 사용자에게서 입력받은 정보들과 특정 직원의 employeeID를 인자로 받은 후, 해당 employeeID 를 가진 레코드의 다른 속성 값들을 변경하는 메소드입니다.
	 */
	public int edit(int id, String loginID, String name, String phone, String birthDate, String dept) {
		String SQL = "UPDATE DB2023_employee SET loginID=?, name=?, phone=?, birthDate=?, department=? WHERE employeeID=?";
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, loginID);
			ps.setString(2, name);
			ps.setString(3, phone);
			ps.setString(4, birthDate);
			ps.setString(5, dept);
			ps.setInt(6, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			
		} finally {
			myConnection.close(null, stmt, null, con);
		}
		return -1;
	}

	// Employeemain 화면 : 직원 메시지화면으로 employeeid로 바꿔보낼 때
	
	/**
	 * 직원 메시지화면으로 employeeid로 바꿔보내주는 메소드입니다.
	 */
	public int getEmployeeIDbyloginID(String id) {
		String SQL = "SELECT employeeID FROM DB2023_employee WHERE loginID=?";
		int employeeID = 0;
		try {
			con = myConnection.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) { // 결과 집합에 데이터가 있는지 확인
				employeeID = rs.getInt(1);
			}
		} catch (SQLException se) {
			
		} finally {
			myConnection.close(rs, null, ps, con);
		}
		return employeeID;
	}

}
