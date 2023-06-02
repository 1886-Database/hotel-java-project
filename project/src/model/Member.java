package model;

public class Member {
	
	private int memberID;
	private String loginID;
	private String name;
	private String password;
	private String phone;
	private String birthDate;
	private String grade;
	
	//기본 생성자
	public Member() {}
	
	public Member(int memberID,String loginID,String name,String password,String phone,String birthDate,String grade) {
		super();
		this.setMemberID(memberID);
		this.setLoginID(loginID);
		this.setName(name);
		this.setPassword(password);
		this.setPhone(phone);
		this.setBirthDate(birthDate);
		this.setGrade(grade);
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
	
