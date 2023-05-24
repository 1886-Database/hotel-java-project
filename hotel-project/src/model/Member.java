package model;

public class Member {
	
	private int memberID;
	private String loginName;
	private String realName;
	private String password;
	private String birthday;
	private String grade;
	
	//기본 생성자
	public Member() {}
	
	//매개변수를 모두 받는 생성자
	public Member(int memberID,String loginName,String realName,String password,String birthday,String grade) {
		super();
		this.setMemberID(memberID);
		this.setLoginName(loginName);
		this.setRealName(realName);
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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
	
