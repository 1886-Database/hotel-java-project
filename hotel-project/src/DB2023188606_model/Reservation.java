/**
 * reservation model 객체를 관리하는 class입니다.
 */
package DB2023188606_model;

public class Reservation {
	private int ReservedNo;
	private int RoomNo;
	private String CheckIn;
	private String CheckOut;
	private String ReservedDate;
	private int MemberID;
	private String Requirement;
	private String Breakfast;
	private String ReservedStatus;
	private int GusetNo;
	private String MemberName;
	private String MemberPhone;

	// 기본 생성자
	public Reservation() {
	}
	/**
	 * reservation administration view 생성자
	 */
	public Reservation(String MemberName, String MemberPhone, int ReservedNo, int RoomNo, String CheckIn,
			String CheckOut, String ReservedDate, int MemberID, String Requirement, String Breakfast,
			String ReservedStatus, int GuestNo) {

		super();
		this.setMemberName(MemberName);
		this.setMemberPhone(MemberPhone);
		this.setReservedNo(ReservedNo);
		this.setRoomNo(RoomNo);
		this.setCheckIn(CheckIn);
		this.setCheckOut(CheckOut);
		this.setReservedDate(ReservedDate);
		this.setMemberID(MemberID);
		this.setRequirement(Requirement);
		this.setBreakfast(Breakfast);
		this.setReservedStatus(ReservedStatus);
		this.setGusetNo(GusetNo);
	}
	
	/**
	 * member name를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member name를 반환합니다.
	 */
	public String getMemberName() {
		return MemberName;
	}
	/**
	 * member name를 객체에 저장하는 메소드입니다.
	 */
	public void setMemberName(String MemberName) {
		this.MemberName = MemberName;
	}
	/**
	 * member phone number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member phone number를 반환합니다.
	 */
	public String getMemberPhone() {
		return MemberPhone;
	}
	/**
	 * member phone number를 객체에 저장하는 메소드입니다.
	 */
	public void setMemberPhone(String MemberPhone) {
		this.MemberPhone = MemberPhone;
	}
	/**
	 * member phone number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return member phone number를 반환합니다.
	 */
	public int getReservedNo() {
		return ReservedNo;
	}
	/**
	 * reservation number를 객체에 저장하는 메소드입니다.
	 */
	public void setReservedNo(int ReservedNo) {
		this.ReservedNo = ReservedNo;
	}
	/**
	 * reservation number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reservation number를 반환합니다.
	 */
	public int getRoomNo() {
		return RoomNo;
	}
	/**
	 * checkin time를 객체에 저장하는 메소드입니다.
	 */
	public void setRoomNo(int RoomNo) {
		this.RoomNo = RoomNo;
	}
	/**
	 * checkin time를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return checkin time를 반환합니다.
	 */
	public String getCheckIn() {
		return CheckIn;
	}
	/**
	 * checkin time를 객체에 저장하는 메소드입니다.
	 */
	public void setCheckIn(String CheckIn) {
		this.CheckIn = CheckIn;
	}
	/**
	 * checkout time를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return checkout time를 반환합니다.
	 */
	public String getCheckOut() {
		return CheckOut;
	}
	/**
	 * checkout time를 객체에 저장하는 메소드입니다.
	 */
	public void setCheckOut(String CheckOut) {
		this.CheckOut = CheckOut;
	}
	/**
	 * reservation date를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reservation date를 반환합니다.
	 */
	public String getReservedDate() {
		return ReservedDate;
	}
	/**
	 * reservation date를 객체에 저장하는 메소드입니다.
	 */
	public void setReservedDate(String ReservedDate) {
		this.ReservedDate = ReservedDate;
	}
	/**
	 * memberID를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return memberID를 반환합니다.
	 */
	public int getMemberID() {
		return MemberID;
	}
	/**
	 * memberID를 객체에 저장하는 메소드입니다.
	 */
	public void setMemberID(int MemberID) {
		this.MemberID = MemberID;
	}
	/**
	 * reservation requirement를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reservation requirement를 반환합니다.
	 */
	public String getRequirement() {
		return Requirement;
	}
	/**
	 * reservation requirement를 객체에 저장하는 메소드입니다.
	 */
	public void setRequirement(String Requirement) {
		this.Requirement = Requirement;
	}
	/**
	 * reservation breakfast 여부를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reservation breakfast 여부를 반환합니다.
	 */
	public String getBreakfast() {
		return Breakfast;
	}
	/**
	 * reservation breakfast 여부를 객체에 저장하는 메소드입니다.
	 */
	public void setBreakfast(String Breakfast) {
		this.Breakfast = Breakfast;
	}
	/**
	 * reserved status를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return reserved status를 반환합니다.
	 */
	public String getReservedStatus() {
		return ReservedStatus;
	}
	/**
	 * reserved status를 객체에 저장하는 메소드입니다.
	 */
	public void setReservedStatus(String ReservedStatus) {
		this.ReservedStatus = ReservedStatus;
	}
	/**
	 * guest number를 객체에서 가져오는 메소드입니다.
	 * 
	 * @return guest number를 반환합니다.
	 */
	public int getGusetNo() {
		return GusetNo;
	}
	/**
	 * guest number를 객체에 저장하는 메소드입니다.
	 */
	public void setGusetNo(int GusetNo) {
		this.GusetNo = GusetNo;
	}
}
