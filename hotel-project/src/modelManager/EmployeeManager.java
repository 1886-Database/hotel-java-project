package modelManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Employee;
import myConnection.MY_Connection;

public class EmployeeManager {
	private MY_Connection myConnection;
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	public EmployeeManager() {
		try {
			myConnection = new MY_Connection();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String id, String pw) {
		String SQL = "SELECT * FROM DB2023_employee WHERE loginID=? and password=?";
		try {
			con=myConnection.getConnection();
		    ps = con.prepareStatement(SQL);
		    ps.setString(1, id);
		    ps.setString(2,pw);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) { 
		    	System.out.println("직원 로그인 성공");
		    	return 1; //로그인 성공
		    }
		    return 0; //로그인 실패 (잘못된 id/pw)
		}catch(Exception e){
		    e.printStackTrace();
		}finally {
			System.out.println("자원 반납");
			myConnection.close(rs,null,ps,con);
		}
		return -1; //데이터베이스 오류 
	 }
	
	public int checkID(String id) {
		String SQL = "SELECT * FROM DB2023_employee WHERE loginID=?";
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
		}catch(Exception e){
		    e.printStackTrace();
		}finally {
			myConnection.close(rs,null,ps,con);
		}
		return -1; //데이터베이스 오류 
	}
	
	//패스워드 변경
		public int passwordChange(String loginID,String password) {
			String SQL="UPDATE DB2023_employee SET password=? WHERE loginID=?";
			try {
				con=myConnection.getConnection();
				ps=con.prepareStatement(SQL);
				ps.setString(1, password);
				ps.setString(2, loginID);
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				myConnection.close(null, null, ps, con);
			}
			return -1;
		}
	
	//직원의 로그인 ID 값으로 다른 속성 값 얻기
		public Employee getByLoginID(String loginID) {
			String SQL = "SELECT * FROM DB2023_employee WHERE loginID=?";
			try {
				con=myConnection.getConnection();
				ps=con.prepareStatement(SQL);
				ps.setString(1, loginID);
				rs = ps.executeQuery();
				while(rs.next()) {
					Employee employee = new Employee(loginID,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					return employee;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				myConnection.close(rs, null, ps, con);
			}
			Employee employee = new Employee();
			return employee;
		}
		
		//직원관리 화면 : employee 테이블 모든 레코드를 각각 Employee 객체에 저장한 후 객체 배열 반환
		public Employee[] getAllEmployee() {
			Employee[] e_array;
			int rowCnt=0;
			int index=0;
			String emp = "SELECT * FROM DB2023_employee";
			String empCnt = "SELECT COUNT(*) FROM DB2023_employee";
			try {
				con=myConnection.getConnection();
				stmt=con.createStatement();
				
				//member 테이블의 레코드 개수 크기 만큼의 객체배열 생성
				ResultSet rsCnt=stmt.executeQuery(empCnt);
				
				if(rsCnt.next()) {
					rowCnt =rsCnt.getInt(1);
				}
				e_array=new Employee[rowCnt];
				for (int i = 0; i < e_array.length; ++i)
					e_array[i] = new Employee();
				
				rsCnt.close();     //자원반납
				
				//각 객체에 값 저장
				rs=stmt.executeQuery(emp);
				while(rs.next()) {
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
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				myConnection.close(rs, stmt, null, con);
			}
			
			e_array=new Employee[rowCnt];
			return e_array;
		}
}
