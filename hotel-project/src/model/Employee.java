package model;

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
	
	//employeeID 를 제외한 매개변수를 받는 생성자
	public Employee(String loginID,String name,String password,String phone,String birthDate,String department) {
		super();
		this.setLoginID(loginID);
		this.setName(name);
		this.setPassword(password);
		this.setPhone(phone);
		this.setBirthDate(birthDate);
		this.setDepartment(department);
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
