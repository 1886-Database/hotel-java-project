package model;

public class Member {
	
	private int memberID;
	private String loginID;
	private String name;
	private String password;
	private String birthday;
	private String grade;
	
	//기본 생성자
	public Member() {}
	
	//memberID 를 제외한 매개변수를 받는 생성자
	public Member(String loginID,String name,String password,String birthday,String grade) {
		super();
		this.setLoginID(loginID);
		this.setName(name);
		this.setPassword(password);
		this.setBirthday(birthday);
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
	
