package model;

public class Employee {
	private int employeeID;
	private String loginID;
	private String name;
	private String password;
	private String phone;
	private String birthDate;
	private String department;
	
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
}
