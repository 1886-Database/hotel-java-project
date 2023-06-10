/**
 * employee model 객체를 관리하는 class입니다.
 */

package DB2023188606_model;

public class Employee {
	
	private int employeeID;
	private String loginID;
	private String name;
	private String password;
	private String phone;
	private String birthDate;
	private String department;
	
	//기본 생성자
	public Employee() {}
	
	public Employee(int employeeID,String loginID,String name,String password,String phone,String birthDate,String department) {
		super();
		this.setEmployeeID(employeeID);
		this.setLoginID(loginID);
		this.setName(name);
		this.setPassword(password);
		this.setPhone(phone);
		this.setBirthDate(birthDate);
		this.setDepartment(department);
	}
	
	/**
	 * EmployeeID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return employeeID를 반환합니다.
	 */
	public int getEmployeeID() {
		return employeeID;
	}
	/**
	 * EmployeeID를 객체에 저장하는 메소드입니다.
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 *LoginID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return LoginID를 반환합니다.
	 */
	public String getLoginID() {
		return loginID;
	}
	/**
	 * LoginID를 객체에 저장하는 메소드입니다.
	 */
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	/**
	 * Employee name을 객체에서 가져오는 메소드입니다.
	 * 
	 * @return Employee name를 반환합니다.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Employee name를 객체에 저장하는 메소드입니다.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Employee Password를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return Employee Password를 반환합니다.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Employee Password를 객체에 저장하는 메소드입니다.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Employee Phone number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return Employee Phone number를 반환합니다.
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Employee Phone number를 객체에 저장하는 메소드입니다.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Employee birth date를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return Employee birth date를 반환합니다.
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * Employee birth date를 객체에 저장하는 메소드입니다.
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * Employee department를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return  Employee department를 반환합니다.
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 *  Employee department를 객체에 저장하는 메소드입니다.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
}
