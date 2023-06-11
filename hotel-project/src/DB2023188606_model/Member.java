/**
 * employee model 객체를 관리하는 class입니다.
 */
package DB2023188606_model;

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
	/**
	 * memberID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return memberID를 반환합니다.
	 */
	public int getMemberID() {
		return memberID;
	}
	
	/**
	 * memberID를 객체에 저장하는 메소드입니다.
	 */
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	/**
	 * member의 loginID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member의 loginID를 반환합니다.
	 */
	public String getLoginID() {
		return loginID;
	}

	/**
	 * member의 loginID를 객체에 저장하는 메소드입니다.
	 */
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	/**
	 * member name를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member nameD를 반환합니다.
	 */
	public String getName() {
		return name;
	}

	/**
	 * member name를 객체에 저장하는 메소드입니다.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * member의 password를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member의 password를 반환합니다.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * member의 password를 객체에 저장하는 메소드입니다.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * member BirthDate를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member BirthDate를 반환합니다.
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * member BirthDate를 객체에 저장하는 메소드입니다.
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * member grade를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member grade를 반환합니다.
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * member grade를 객체에 저장하는 메소드입니다.
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * member phone number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return  member phone number를 반환합니다.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 *  member phone number를 객체에 저장하는 메소드입니다.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
	
